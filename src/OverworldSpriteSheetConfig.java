import sprites.OverWorldSprite;
import sprites.OverWorldSpriteEdges;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import static sprites.OverWorldSprite.*;
import static sprites.OverWorldSpriteEdges.*;

public class OverworldSpriteSheetConfig extends SpriteSheetConfig {

    private static final String filePath = "src/assets/punyworld-overworld-tileset.png";

    private static final int spritesX = 27;
    private static final int spritesY = 26;
    private static final int spriteSize = 16;

    private static final HashMap<OverWorldSprite, OverWorldSpriteEdges[]> tileRules = new HashMap<>() {
        {
            put(GRASS_0, new OverWorldSpriteEdges[]{E_GRASS, E_GRASS, E_GRASS, E_GRASS});
            put(GRASS_1, new OverWorldSpriteEdges[]{E_GRASS, E_GRASS, E_GRASS, E_GRASS});
            put(GRASS_2, new OverWorldSpriteEdges[]{E_GRASS, E_GRASS, E_GRASS, E_GRASS});
            put(GRASS_3, new OverWorldSpriteEdges[]{E_GRASS, E_GRASS, E_GRASS, E_GRASS});
            put(GRASS_4, new OverWorldSpriteEdges[]{E_GRASS, E_GRASS, E_GRASS, E_GRASS});
            put(GRASS_5, new OverWorldSpriteEdges[]{E_GRASS, E_GRASS, E_GRASS, E_GRASS});
            put(GRASS_6, new OverWorldSpriteEdges[]{E_GRASS, E_GRASS, E_GRASS, E_GRASS});
            put(GRASS_7, new OverWorldSpriteEdges[]{E_GRASS, E_GRASS, E_GRASS, E_GRASS});
            put(GRASS_8, new OverWorldSpriteEdges[]{E_GRASS, E_GRASS, E_GRASS, E_GRASS});

            put(WATER, new OverWorldSpriteEdges[]{E_WATER, E_WATER, E_WATER, E_WATER});

            put(COAST_TL, new OverWorldSpriteEdges[] {E_GRASS, E_COAST_GRASS_T, E_COAST_GRASS_L, E_GRASS});
            put(COAST_T, new OverWorldSpriteEdges[] {E_GRASS, E_COAST_GRASS_T, E_WATER, E_COAST_GRASS_T});
            put(COAST_TR, new OverWorldSpriteEdges[] {E_GRASS, E_GRASS, E_COAST_GRASS_R, E_COAST_GRASS_T});
            put(COAST_L, new OverWorldSpriteEdges[] {E_COAST_GRASS_L, E_WATER, E_COAST_GRASS_L, E_GRASS});
            put(COAST_R, new OverWorldSpriteEdges[] {E_COAST_GRASS_R, E_GRASS, E_COAST_GRASS_R, E_WATER});
            put(COAST_BL, new OverWorldSpriteEdges[] {E_COAST_GRASS_L, E_COAST_GRASS_B, E_GRASS, E_GRASS});
            put(COAST_B, new OverWorldSpriteEdges[] {E_WATER, E_COAST_GRASS_B, E_GRASS, E_COAST_GRASS_B});
            put(COAST_BR, new OverWorldSpriteEdges[] {E_COAST_GRASS_R, E_GRASS, E_GRASS, E_COAST_GRASS_B});

            put(ROCK_TLO, new OverWorldSpriteEdges[] {E_GRASS, E_GRASS_ROCK_B, E_GRASS_ROCK_R, E_GRASS});
            put(ROCK_TLI, new OverWorldSpriteEdges[] {E_GRASS_ROCK_R, E_GRASS, E_GRASS, E_GRASS_ROCK_B});
            put(ROCK_T, new OverWorldSpriteEdges[] {E_GRASS, E_GRASS_ROCK_B, E_GRASS, E_GRASS_ROCK_B});
            put(ROCK_TRO, new OverWorldSpriteEdges[] {E_GRASS, E_GRASS, E_GRASS_ROCK_L, E_GRASS_ROCK_B});
            put(ROCK_TRI, new OverWorldSpriteEdges[] {E_GRASS_ROCK_L, E_GRASS_ROCK_B, E_GRASS, E_GRASS});
            put(ROCK_L, new OverWorldSpriteEdges[] {E_GRASS_ROCK_R, E_GRASS, E_GRASS_ROCK_R, E_GRASS});
            put(ROCK_R, new OverWorldSpriteEdges[] {E_GRASS_ROCK_L, E_GRASS, E_GRASS_ROCK_L, E_GRASS});
            put(ROCK_BLO, new OverWorldSpriteEdges[] {E_GRASS_ROCK_R, E_GRASS_ROCK_T, E_GRASS, E_GRASS});
            put(ROCK_BLI, new OverWorldSpriteEdges[] {E_GRASS, E_GRASS, E_GRASS_ROCK_R, E_GRASS_ROCK_T});
            put(ROCK_B, new OverWorldSpriteEdges[] {E_GRASS, E_GRASS_ROCK_T, E_GRASS, E_GRASS_ROCK_T});
            put(ROCK_BRO, new OverWorldSpriteEdges[] {E_GRASS_ROCK_L, E_GRASS, E_GRASS, E_GRASS_ROCK_T});
            put(ROCK_BRI, new OverWorldSpriteEdges[] {E_GRASS, E_GRASS_ROCK_T, E_GRASS_ROCK_L, E_GRASS});
            put(ROCK_BROTLO, new OverWorldSpriteEdges[] {E_GRASS_ROCK_L, E_GRASS_ROCK_B, E_GRASS_ROCK_R, E_GRASS_ROCK_T});
            put(ROCK_BLOTRO, new OverWorldSpriteEdges[] {E_GRASS_ROCK_R, E_GRASS_ROCK_T, E_GRASS_ROCK_L, E_GRASS_ROCK_B});

            put(STAIRS_T, new OverWorldSpriteEdges[] {E_GRASS, E_GRASS_ROCK_B, E_GRASS, E_GRASS_ROCK_B});
            put(STAIRS_R, new OverWorldSpriteEdges[] {E_GRASS_ROCK_L, E_GRASS, E_GRASS_ROCK_L, E_GRASS});
            put(STAIRS_B, new OverWorldSpriteEdges[] {E_GRASS, E_GRASS_ROCK_T, E_GRASS, E_GRASS_ROCK_T});
            put(STAIRS_L, new OverWorldSpriteEdges[] {E_GRASS_ROCK_R, E_GRASS, E_GRASS_ROCK_R, E_GRASS});

            put(MINE, new OverWorldSpriteEdges[] {E_GRASS, E_GRASS_ROCK_T, E_GRASS, E_GRASS_ROCK_T});
            put(CAVE, new OverWorldSpriteEdges[] {E_GRASS, E_GRASS_ROCK_T, E_GRASS, E_GRASS_ROCK_T});

            put(PATH_T, new OverWorldSpriteEdges[] {E_GRASS, E_GRASS, E_GRASS_PATH, E_GRASS});
            put(PATH_V, new OverWorldSpriteEdges[] {E_GRASS_PATH, E_GRASS, E_GRASS_PATH, E_GRASS});
            put(PATH_B, new OverWorldSpriteEdges[] {E_GRASS_PATH, E_GRASS, E_GRASS, E_GRASS});

            put(PATH_D, new OverWorldSpriteEdges[] {E_GRASS, E_GRASS, E_GRASS, E_GRASS});

            put(PATH_L, new OverWorldSpriteEdges[] {E_GRASS, E_GRASS_PATH, E_GRASS, E_GRASS});
            put(PATH_H, new OverWorldSpriteEdges[] {E_GRASS, E_GRASS_PATH, E_GRASS, E_GRASS_PATH});
            put(PATH_R, new OverWorldSpriteEdges[] {E_GRASS, E_GRASS, E_GRASS, E_GRASS_PATH});

            put(PATH_TL, new OverWorldSpriteEdges[] {E_GRASS, E_GRASS_PATH, E_GRASS_PATH, E_GRASS});
            put(PATH_TJ, new OverWorldSpriteEdges[] {E_GRASS, E_GRASS_PATH, E_GRASS_PATH, E_GRASS_PATH});
            put(PATH_TR, new OverWorldSpriteEdges[] {E_GRASS, E_GRASS, E_GRASS_PATH, E_GRASS_PATH});
            put(PATH_LJ, new OverWorldSpriteEdges[] {E_GRASS_PATH, E_GRASS_PATH, E_GRASS_PATH, E_GRASS});
            put(PATH_MJ, new OverWorldSpriteEdges[] {E_GRASS_PATH, E_GRASS_PATH, E_GRASS_PATH, E_GRASS_PATH});
            put(PATH_RJ, new OverWorldSpriteEdges[] {E_GRASS_PATH, E_GRASS, E_GRASS_PATH, E_GRASS_PATH});
            put(PATH_BL, new OverWorldSpriteEdges[] {E_GRASS_PATH, E_GRASS_PATH, E_GRASS, E_GRASS});
            put(PATH_BJ, new OverWorldSpriteEdges[] {E_GRASS_PATH, E_GRASS_PATH, E_GRASS, E_GRASS_PATH});
            put(PATH_BR, new OverWorldSpriteEdges[] {E_GRASS_PATH, E_GRASS, E_GRASS, E_GRASS_PATH});

            put(RIVER_T, new OverWorldSpriteEdges[] {E_GRASS, E_GRASS, E_RIVER, E_GRASS});
            put(RIVER_V, new OverWorldSpriteEdges[] {E_RIVER, E_GRASS, E_RIVER, E_GRASS});
            put(RIVER_B, new OverWorldSpriteEdges[] {E_RIVER, E_GRASS, E_GRASS, E_GRASS});

            put(RIVER_D, new OverWorldSpriteEdges[] {E_GRASS, E_GRASS, E_GRASS, E_GRASS});

            put(RIVER_L, new OverWorldSpriteEdges[] {E_GRASS, E_RIVER, E_GRASS, E_GRASS});
            put(RIVER_H, new OverWorldSpriteEdges[] {E_GRASS, E_RIVER, E_GRASS, E_RIVER});
            put(RIVER_R, new OverWorldSpriteEdges[] {E_GRASS, E_GRASS, E_GRASS, E_RIVER});

            put(RIVER_TL, new OverWorldSpriteEdges[] {E_GRASS, E_RIVER, E_RIVER, E_GRASS});
            put(RIVER_TJ, new OverWorldSpriteEdges[] {E_GRASS, E_RIVER, E_RIVER, E_RIVER});
            put(RIVER_TR, new OverWorldSpriteEdges[] {E_GRASS, E_GRASS, E_RIVER, E_RIVER});
            put(RIVER_LJ, new OverWorldSpriteEdges[] {E_RIVER, E_RIVER, E_RIVER, E_GRASS});
            put(RIVER_MJ, new OverWorldSpriteEdges[] {E_RIVER, E_RIVER, E_RIVER, E_RIVER});
            put(RIVER_RJ, new OverWorldSpriteEdges[] {E_RIVER, E_GRASS, E_RIVER, E_RIVER});
            put(RIVER_BL, new OverWorldSpriteEdges[] {E_RIVER, E_RIVER, E_GRASS, E_GRASS});
            put(RIVER_BJ, new OverWorldSpriteEdges[] {E_RIVER, E_RIVER, E_GRASS, E_RIVER});
            put(RIVER_BR, new OverWorldSpriteEdges[] {E_RIVER, E_GRASS, E_GRASS, E_RIVER});
        }
    };

    public OverworldSpriteSheetConfig() {
        super(filePath, spritesX, spritesY, spriteSize, tileRules);
    }
}
