package com.exiled.core;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL;

import com.exiled.graphics.Renderer;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.NULL;

public class Game {
  private long window;
  private int screenWidth;
  private int screenHeight;

  private GameState gameState;
  private Renderer renderer;

  public void run() {
    init();
    loop();
    glfwDestroyWindow(window);
    glfwTerminate();
  }

  private void init() {
    if (!glfwInit()) {
      throw new IllegalStateException("Failed to initialize GLFW");
    }

    long monitor = glfwGetPrimaryMonitor();
    var videoMode = glfwGetVideoMode(monitor);
    assert videoMode != null;

    screenWidth = videoMode.width();
    screenHeight = videoMode.height();

    window = glfwCreateWindow(screenWidth, screenHeight, "MMBN Grid", monitor, NULL);
    if (window == NULL)
      throw new RuntimeException("Failed to create window");

    glfwMakeContextCurrent(window);
    glfwSwapInterval(1);
    GL.createCapabilities();

    // Setup 2D projection
    glMatrixMode(GL_PROJECTION);
    glLoadIdentity();
    glOrtho(0, screenWidth, screenHeight, 0, -1, 1);
    glMatrixMode(GL_MODELVIEW);

    this.gameState = new GameState(screenWidth, screenHeight);
    this.renderer = new Renderer(gameState);
  }

  private void loop() {
    while (!glfwWindowShouldClose(window)) {
      glClear(GL_COLOR_BUFFER_BIT);
      glClearColor(0.1f, 0.1f, 0.1f, 1.0f);

      gameState.update(); // Future: handle animations, logic
      renderer.render();

      glfwSwapBuffers(window);
      glfwPollEvents();
    }
  }

  public static void main(String[] args) {
    new Game().run();
  }
}
