# WaveFunctionCollapseWorldGen

Procedural 2D overworld generation in Java using the **Wave Function Collapse**
(WFC) algorithm, rendered with Swing using the Punyworld overworld pixel-art
tileset.

## How it works

- **Rules** — every sprite in the tileset is described by the edge type on each of
  its four sides (`OverWorldSpriteEdges`: grass, water, coast, rock, path, river,
  …). Two tiles may sit next to each other only if their touching edges match.
- **Superposition** — each cell of a 40×30 grid starts with every sprite as a
  possibility.
- **Collapse** — the cell with the lowest entropy (fewest remaining possibilities)
  is collapsed to a single sprite, chosen at random weighted by each sprite's
  rarity.
- **Propagation** — the choice is pushed through the grid with a stack: each
  neighbour drops any possibility whose edge no longer fits, and any neighbour that
  changed is propagated in turn.
- **Restart on contradiction** — collapse/propagate repeats until no cells remain.
  If a cell runs out of possibilities, the grid is reset and generation starts
  again.

`World` then paints each cell's sprite at 2× scale.

## Running

Requires a JDK (Java 17+ recommended). Run from the repository root so
`src/assets/punyworld-overworld-tileset.png` resolves:

```sh
javac -d out $(find src -name '*.java')
java -cp out Main
```

The project can also be opened directly in IntelliJ IDEA (`WFC.iml`).

## Files

| File | Description |
|------|-------------|
| `src/Main.java` | Creates the world and window |
| `src/World.java` | Grid, lowest-entropy selection, collapse/propagate loop, painting |
| `src/Tile.java` | One cell: possibilities, weighted collapse, neighbour constraints |
| `src/SpriteSheet.java`, `src/SpriteSheetConfig.java` | Tileset loading and configuration |
| `src/OverworldSpriteSheetConfig.java` | Sprite size, path and adjacency rules for the overworld tileset |
| `src/sprites/` | Sprite and edge-type enums |
| `src/Rect.java` | Geometry helper |
