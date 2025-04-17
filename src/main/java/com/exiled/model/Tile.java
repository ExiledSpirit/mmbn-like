package com.exiled.model;

public class Tile {
  private final int x, y;
  private Player occupant;

  public Tile(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public boolean isOccupied() {
    return occupant != null;
  }

  public void setOccupant(Player p) {
    this.occupant = p;
  }

  public Player getOccupant() {
    return occupant;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }
}
