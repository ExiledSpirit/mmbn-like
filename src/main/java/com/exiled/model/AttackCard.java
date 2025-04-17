package com.exiled.model;

public class AttackCard extends Card {
  private int damage;
  private Area area; // could be an enum or a relative position list

  @Override
  public CardType getType() {
    return CardType.ATTACK;
  }

  @Override
  public void play(Player self, Player opponent, Grid grid) {
    // Logic to apply damage if opponent is in area
  }
}