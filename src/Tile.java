import sprites.OverWorldSprite;
import sprites.OverWorldSpriteEdges;

import javax.print.attribute.standard.CopiesSupported;
import java.lang.reflect.Array;
import java.util.*;

public class Tile {
    Random rand;
    private int x, y;
    private final HashMap<OverWorldSprite, OverWorldSpriteEdges[]> rules;

    private OverWorldSprite sprite;
    private int entropy;

    private ArrayList<OverWorldSprite> possibilities;

    private Tile[] neighbours = new Tile[] {null, null, null, null};

    public Tile(int x, int y, HashMap<OverWorldSprite, OverWorldSpriteEdges[]> rules, Random rand) {
        this.x = x;
        this.y = y;
        this.rules = rules;
        this.entropy = rules.size();
        this.possibilities = new ArrayList<>(rules.keySet());
        this.rand = rand;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getEntropy() {
        return entropy;
    }

    public boolean collapse() {
        this.entropy = -1;
        if (possibilities.isEmpty()) {
            return false;
        }
        int random_index = rand.nextInt(possibilities.size());

        double totalWeight = 0.0;
        for (OverWorldSprite i : possibilities) {
            totalWeight += i.rarity;
        }

        int randomIndex = -1;
        double random = Math.random() * totalWeight;
        for (int i = 0; i < possibilities.size(); ++i)
        {
            random -= possibilities.get(i).rarity;
            if (random <= 0.0d)
            {
                randomIndex = i;
                break;
            }
        }

        this.sprite = possibilities.get(randomIndex);
        this.possibilities = new ArrayList<>();
        this.possibilities.add(sprite);
        return true;
    }

    public int getSprite() {
        if (this.sprite == null) {
            return -1;
        }
        return this.sprite.i;
    }

    public void addNeighbour (int dir, Tile tile) {
        neighbours[dir] = tile;
    }

    public ArrayList<OverWorldSprite> getPossibilities() {
        return possibilities;
    }

    public Tile[] getNeighbours() {
        return neighbours;
    }

    public boolean constrain(ArrayList<OverWorldSprite> neighbourPossibilities, int dir) {
        boolean reduced = false;

        if (getEntropy() > 0) {
            ArrayList<OverWorldSpriteEdges> connections = new ArrayList<>();
            for (OverWorldSprite possibility : neighbourPossibilities) {
                connections.add(rules.get(possibility)[dir]);
            }

            int opposite = -1;

            if (dir == 0) opposite = 2;
            if (dir == 1) opposite = 3;
            if (dir == 2) opposite = 0;
            if (dir == 3) opposite = 1;

            ArrayList<OverWorldSprite> possibilitiesCopy = new ArrayList<>(possibilities);

            for (OverWorldSprite possibility : possibilitiesCopy) {
                if (!connections.contains(rules.get(possibility)[opposite])) {
                    possibilities.remove(possibility);
                    reduced = true;
                }
            }

            entropy = possibilities.size();
        }
        return reduced;
    }
}
