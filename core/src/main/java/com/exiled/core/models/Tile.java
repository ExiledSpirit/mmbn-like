package com.exiled.core.models;

public class Tile {
    private final Position position;
    private Entity occupant;
    private TeamType team;
    private boolean hasPlayer;
    private boolean hasNPC;
    private boolean hasStructure;
  
    public Tile(Position position, TeamType team) {
        this.position = position;
        this.team = team;
        this.hasPlayer = false;
        this.hasNPC = false;
        this.hasStructure = false;
    }
  
    public boolean isOccupied() {
      return occupant != null;
    }
  
    public void setOccupant(Entity o) {
      this.occupant = o;
    }
  
    public Entity getOccupant() {
      return occupant;
    }
  
    public int getX() {
      return position.x();
    }
  
    public int getY() {
      return position.y();
    }

    public Position getPosition() {
        return position;
    }

    public TeamType getTeam() {
        return this.team;
    }

    public boolean canEntityEnter(Entity entity) {
        return this.team == entity.getTeam();
    }

    public void setTeam(TeamType team) {
        this.team = team;
        // É necessário adicionar lógicas adicionais como 'empurrar' entidade para tile mais próximo, mas não sei onde acoplar isso.
    }

    public boolean hasPlayer() { return hasPlayer; }
    
    public boolean hasNPC() { return hasNPC; }
    
    public boolean hasStructure() { return hasStructure; }

    public void setPlayer(boolean player) { this.hasPlayer = player; }
    
    public void setNPC(boolean npc) { this.hasNPC = npc; }
    
    public void setStructure(boolean structure) { this.hasStructure = structure; }
}
