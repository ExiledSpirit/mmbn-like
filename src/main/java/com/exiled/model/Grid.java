package com.exiled.model;

public class Grid {
  private final int width;
  private final int height;
  private final Tile[][] tiles;

  public Grid(int width, int height) {
    this.width = width;
    this.height = height;
    this.tiles = new Tile[width][height];

    // Initialize tiles
    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {
        tiles[x][y] = new Tile(x, y);
      }
    }
  }

  public boolean isInside(int x, int y) {
    return x >= 0 && x < width && y >= 0 && y < height;
  }

  public Tile getTile(int x, int y) {
    if (!isInside(x, y))
      return null;
    return tiles[x][y];
  }

  public Tile getTile(Position pos) {
    return getTile(pos.x(), pos.y());
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }
}
