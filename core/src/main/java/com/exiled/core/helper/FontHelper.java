package com.exiled.core.helper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class FontHelper {
  private static final String AXIAL_TTF = "fonts/axial.ttf";

  public static BitmapFont getAxialFont(int size, Color color) {
    FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal(AXIAL_TTF));
    FreeTypeFontGenerator.FreeTypeFontParameter param = new FreeTypeFontGenerator.FreeTypeFontParameter();
    param.size = size;
    param.color = color;
    param.magFilter = com.badlogic.gdx.graphics.Texture.TextureFilter.Linear;
    param.minFilter = com.badlogic.gdx.graphics.Texture.TextureFilter.Linear;

    BitmapFont font = generator.generateFont(param);
    generator.dispose(); // Dispose immediately after generating
    return font;
  }
}