import sprites.OverWorldSprite;
import sprites.OverWorldSpriteEdges;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;

public abstract class SpriteSheetConfig {
    protected final String filePath;
    protected final int spritesX;
    protected final int spritesY;
    protected final int spriteSize;

    protected final HashMap<OverWorldSprite, OverWorldSpriteEdges[]> tileRules;

    protected SpriteSheetConfig(String filePath, int spritesX, int spritesY, int spriteSize,
                                HashMap<OverWorldSprite, OverWorldSpriteEdges[]> tileRules) {
        this.filePath = filePath;
        this.spritesX = spritesX;
        this.spritesY = spritesY;
        this.spriteSize = spriteSize;
        this.tileRules = tileRules;
    }

    public Rect getSourceRect(int spriteIndex) {
        int tlx, tly, brx, bry;

        tlx = (spriteIndex % spritesX)*spriteSize;
        tly = (spriteIndex / spritesX)*spriteSize;
        brx = tlx+spriteSize;
        bry = tly+spriteSize;

        return new Rect(
                tlx, tly,
                brx, bry
        );
    }
}
