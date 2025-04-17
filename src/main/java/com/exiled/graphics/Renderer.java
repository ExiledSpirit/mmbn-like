package com.exiled.graphics;

import static org.lwjgl.opengl.GL11.*;

import com.exiled.core.GameState;

public class Renderer {
  private final GameState gameState;

  public Renderer(GameState gameState) {
    this.gameState = gameState;
  }

  public void render() {
    renderGrid();
  }

  private void renderGrid() {
    for (int col = 0; col < gameState.gridCols; col++) {
      for (int row = 0; row < gameState.gridRows; row++) {
        int x = gameState.gridStartX + col * gameState.tileWidth;
        int y = gameState.gridStartY + row * gameState.tileHeight;

        // Fill
        glColor3f(0.2f, 0.6f, 1.0f);
        glBegin(GL_QUADS);
        glVertex2f(x, y);
        glVertex2f(x + gameState.tileWidth, y);
        glVertex2f(x + gameState.tileWidth, y + gameState.tileHeight);
        glVertex2f(x, y + gameState.tileHeight);
        glEnd();

        // Border
        glColor3f(0f, 0f, 0f);
        glBegin(GL_LINE_LOOP);
        glVertex2f(x, y);
        glVertex2f(x + gameState.tileWidth, y);
        glVertex2f(x + gameState.tileWidth, y + gameState.tileHeight);
        glVertex2f(x, y + gameState.tileHeight);
        glEnd();
      }
    }
  }
}
