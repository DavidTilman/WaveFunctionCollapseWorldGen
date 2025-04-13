import sprites.OverWorldSprite;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class World extends JPanel {
    private SpriteSheet spriteSheet;

    private final int gridCellsX = 40;
    private final int gridCellsY = 30;

    private final int spritePixelSizeFactor = 2;
    private final int gridCellPixelSize;

    private final int pixelWidth;
    private final int pixelHeight;

    private Tile[][] tiles = new Tile[gridCellsX][gridCellsY];

    Random rand = new Random();

    public World(SpriteSheetConfig config) {
        spriteSheet = new SpriteSheet(config);
        gridCellPixelSize = spriteSheet.getSpriteSize() * spritePixelSizeFactor;

        pixelWidth = gridCellsX * spriteSheet.getSpriteSize() * spritePixelSizeFactor;
        pixelHeight = gridCellsY * spriteSheet.getSpriteSize() * spritePixelSizeFactor;

        reset();

        while (!isDone()) {
            while (waveFunctionCollapse()) { continue; }
            if (!isDone()) {
                reset();
            }
        }
    }

    public void reset() {
        for (int x = 0; x < gridCellsX; x++) {
            for (int y = 0; y < gridCellsY; y++) {
                tiles[x][y] = new Tile(x,y, spriteSheet.getTileRules(), rand);
            }
        }

        for (int x = 0; x < gridCellsX; x++) {
            for (int y = 0; y < gridCellsY; y++) {
                if (y > 0) {
                    tiles[x][y].addNeighbour(0, tiles[x][y - 1]);
                }
                if (x > 0) {
                    tiles[x][y].addNeighbour(3, tiles[x - 1][y]);
                }
                if (x < gridCellsX - 1) {
                    tiles[x][y].addNeighbour(1, tiles[x+1][y]);
                }
                if (y < gridCellsY - 1) {
                    tiles[x][y].addNeighbour(2, tiles[x][y + 1]);
                };
            }
        }
    }

    public boolean isDone() {
        for (int x = 0; x < gridCellsX; x++) {
            for (int y = 0; y < gridCellsY; y++) {
                if (tiles[x][y].getSprite() == -1) {
                    return false;
                }
            }
        }
        return true;
    }

    public int getPixelWidth() {
        return pixelWidth;
    }

    public int getPixelHeight() {
        return pixelHeight;
    }

    private Rect getGridCellRect(int x, int y) {
        int tlx, tly, brx, bry;

        tlx = x * gridCellPixelSize;
        tly = y * gridCellPixelSize;
        brx = tlx + gridCellPixelSize;
        bry = tly + gridCellPixelSize;

        return new Rect(tlx, tly, brx, bry);
    }

    public Tile getTile(int x, int y) {
        return tiles[x][y];
    }

    public Tile getLowestEntropyTile() {
        int lowestEntropy = Integer.MAX_VALUE;
        for (int x = 0; x < gridCellsX; x++) {
            for (int y = 0; y < gridCellsY; y++) {
                Tile t = tiles[x][y];
                if (t.getEntropy() != -1 && t.getEntropy() < lowestEntropy) {
                    lowestEntropy = t.getEntropy();
                }
            }
        }
        ArrayList<Tile> lowestTiles = new ArrayList<>();
        for (int x = 0; x < gridCellsX; x++) {
           for (int y = 0; y < gridCellsY; y++) {
               Tile t = tiles[x][y];
               if (t.getEntropy() == lowestEntropy) {
                   lowestTiles.add(t);
               }
           }
        }
        if (lowestTiles.isEmpty()) {
            return null;
        }
        Tile randomTile = lowestTiles.get(rand.nextInt(lowestTiles.size()));
        return randomTile;
    }

    public void drawSprite(Graphics g, int spriteIndex, int gridX, int gridY) {
        Image sprite = spriteSheet.getSprite(spriteIndex);

        Rect cell = getGridCellRect(gridX, gridY);

        g.drawImage(
                sprite,
                cell.getX1(), cell.getY1(),
                gridCellPixelSize, gridCellPixelSize,
                null
        );
    }

    public boolean waveFunctionCollapse() {
        Tile lowestTile = getLowestEntropyTile();
        if (lowestTile == null) {
            return false;
        }
        lowestTile.collapse();

        Stack<Tile> stack = new Stack<>();
        stack.push(lowestTile);

        while (!stack.isEmpty()) {
            Tile t = stack.pop();


            ArrayList<OverWorldSprite> possibilities = t.getPossibilities();
            Tile[] neighbours = t.getNeighbours();

            for (int i = 0; i < neighbours.length; i++) {
                if (neighbours[i] == null) continue;
                if (neighbours[i].getEntropy() != -1) {
                    boolean reduced = neighbours[i].constrain(possibilities, i);
                    if (reduced) {
                        stack.push(neighbours[i]);
                    }
                }
            }
        }
        return true;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < gridCellsX; i++) {
            for (int j = 0; j < gridCellsY; j++) {
                if (tiles[i][j].getEntropy() == -1) {
                    int sprite = tiles[i][j].getSprite();
                    if (sprite == -1) continue;
                    drawSprite(g, sprite, i, j);
                }
            }
        }
    }
}
