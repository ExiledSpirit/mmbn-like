package com.exiled.model;

public abstract class Card {
  protected String name;

  public abstract CardType getType();

  public abstract void play(Player self, Player opponent, Grid grid);
}
