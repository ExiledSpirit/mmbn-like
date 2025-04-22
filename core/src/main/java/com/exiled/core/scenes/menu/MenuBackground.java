package com.exiled.core.scenes.menu;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class MenuBackground extends TextureRegionDrawable {
  public MenuBackground(Color color) {
    super(new TextureRegion(new Texture(createPixmap(color))));
  }

  private static Pixmap createPixmap(Color color) {
    Pixmap pixmap = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
    pixmap.setColor(color);
    pixmap.fill();
    return pixmap;
  }
}
