import sprites.OverWorldSprite;
import sprites.OverWorldSpriteEdges;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class SpriteSheet {
    private final SpriteSheetConfig config;
    private BufferedImage image;

    public SpriteSheet(SpriteSheetConfig config) {
        this.config = config;

        try {
            this.image = ImageIO.read(new File(config.filePath));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public int getSpriteSize() {
        return config.spriteSize;
    }

    public Rect getSourceRect(int spriteIndex) {
        return config.getSourceRect(spriteIndex);
    }

    public Image getSprite(int spriteIndex) {
        Rect spriteRect = config.getSourceRect(spriteIndex);
        int[] rectValues = spriteRect.getRectValues();

        return image.getSubimage(
                rectValues[0], rectValues[1],
                this.getSpriteSize(), this.getSpriteSize()
        );
    }

    public HashMap<OverWorldSprite, OverWorldSpriteEdges[]> getTileRules() {
        return config.tileRules;
    }
}
