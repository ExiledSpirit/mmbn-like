package com.exiled.core.scenes.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class MenuStateManager {
  private MenuState currentState;
  private final List<Consumer<MenuState>> listeners = new ArrayList<>();

  public MenuStateManager(MenuState initialState) {
    this.currentState = initialState;
  }

  public void setState(MenuState newState) {
    if (currentState != newState) {
      this.currentState = newState;
      notifyListeners();
    }
  }

  public MenuState getState() {
    return currentState;
  }

  public void addListener(Consumer<MenuState> listener) {
    listeners.add(listener);
  }

  private void notifyListeners() {
    for (Consumer<MenuState> listener : listeners) {
      listener.accept(currentState);
    }
  }
}