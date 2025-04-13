package sprites;

public enum OverWorldSprite {
    GRASS_0(0*27+0, 100),
    GRASS_1(0*27+1, 1),
    GRASS_2(0*27+2, 1),
    GRASS_3(1*27+0, 1),
    GRASS_4(1*27+1, 1),
    GRASS_5(1*27+2, 1),
    GRASS_6(2*27+0, 1),
    GRASS_7(2*27+1, 1),
    GRASS_8(2*27+2, 1),

    WATER(11*27+8, 1),

    COAST_TL(10*27+7, 1),
    COAST_T(10*27+8, 5),
    COAST_TR(10*27+9, 1),
    COAST_L(11*27+7, 5),
    COAST_R(11*27+9, 5),
    COAST_BL(12*27+7, 1),
    COAST_B(12*27+8, 5),
    COAST_BR(12*27+9, 1),

    ROCK_TLO(4*27+0, 1),
    ROCK_TLI(4*27+3, 1),
    ROCK_T(4*27+1, 5),
    ROCK_TRO(4*27+2, 1),
    ROCK_TRI(4*27+4, 1),
    ROCK_L(5*27+0, 5),
    ROCK_R(5*27+2, 5),
    ROCK_BLO(6*27+0, 1),
    ROCK_BLI(5*27+3, 1),
    ROCK_B(6*27+1, 5),
    ROCK_BRO(6*27+2, 1),
    ROCK_BRI(5*27+4, 1),
    ROCK_BROTLO(6*27+3, 1),
    ROCK_BLOTRO(6*27+4, 1),

    STAIRS_T(4*27+6, 1),
    STAIRS_R(5*27+7, 1),
    STAIRS_B(6*27+6, 1),
    STAIRS_L(5*27+5, 1),

    MINE(4*27+19, 1),
    CAVE(4*27+20, 1),

    PATH_T(0*27+3, 5),
    PATH_V(1*27+3, 1),
    PATH_B(2*27+3, 5),

    PATH_D(3*27+3, 1),

    PATH_L(3*27+4, 5),
    PATH_H(3*27+5, 1),
    PATH_R(3*27+6, 5),

    PATH_TL(0*27+4, 1),
    PATH_TJ(0*27+5, 1),
    PATH_TR(0*27+6, 1),
    PATH_LJ(1*27+4, 1),
    PATH_MJ(1*27+5, 1),
    PATH_RJ(1*27+6, 1),
    PATH_BL(2*27+4, 1),
    PATH_BJ(2*27+5, 1),
    PATH_BR(2*27+6, 1),

    RIVER_T(10*27+0, 5),
    RIVER_V(11*27+0, 1),
    RIVER_B(12*27+0, 5),

    RIVER_D(13*27+0, 1),

    RIVER_L(13*27+1, 5),
    RIVER_H(13*27+2, 1),
    RIVER_R(13*27+3, 5),

    RIVER_TL(10*27+1, 1),
    RIVER_TJ(10*27+2, 1),
    RIVER_TR(10*27+3, 1),
    RIVER_LJ(11*27+1, 1),
    RIVER_MJ(11*27+2, 1),
    RIVER_RJ(11*27+3, 1),
    RIVER_BL(12*27+1, 1),
    RIVER_BJ(12*27+2, 1),
    RIVER_BR(12*27+3, 1),
    ;
    public final int i;
    public final int rarity;

    OverWorldSprite(int index, int rarity) {
        this.i = index; this.rarity = rarity;
    }
}
