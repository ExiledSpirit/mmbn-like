package com.exiled.core;

public class GameState {
  private final int screenWidth;
  private final int screenHeight;

  public final int tileWidth = 80;
  public final int tileHeight = 40;
  public final int gridCols = 6;
  public final int gridRows = 3;

  public final int gridStartX;
  public final int gridStartY;

  public GameState(int screenWidth, int screenHeight) {
    this.screenWidth = screenWidth;
    this.screenHeight = screenHeight;

    this.gridStartX = (screenWidth - (tileWidth * gridCols)) / 2;
    this.gridStartY = (screenHeight - (tileHeight * gridRows)) / 2;
  }

  public void update() {
    // Future logic: animations, card handling, input processing
  }
}
