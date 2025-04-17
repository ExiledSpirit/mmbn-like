package com.exiled.model;

import java.util.Set;
import java.util.HashSet;

public class Area {
  private final Set<Offset> offsets = new HashSet<>();

  public Area addOffset(int dx, int dy) {
    offsets.add(new Offset(dx, dy));
    return this;
  }

  public Set<Offset> getOffsets() {
    return offsets;
  }

  public static Area singleTile() {
    return new Area().addOffset(0, 0);
  }

  public static Area forwardLine(int length) {
    Area area = new Area();
    for (int i = 1; i <= length; i++) {
      area.addOffset(i, 0); // right direction
    }
    return area;
  }

  public static Area cross() {
    return new Area()
        .addOffset(0, 0)
        .addOffset(0, -1)
        .addOffset(0, 1)
        .addOffset(-1, 0)
        .addOffset(1, 0);
  }

  public static Area square3x3() {
    Area area = new Area();
    for (int dx = -1; dx <= 1; dx++) {
      for (int dy = -1; dy <= 1; dy++) {
        area.addOffset(dx, dy);
      }
    }
    return area;
  }

  public record Offset(int dx, int dy) {
  }
}
