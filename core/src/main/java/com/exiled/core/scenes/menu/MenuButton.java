package com.exiled.core.scenes.menu;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class MenuButton extends TextButton {
  public MenuButton(String text, BitmapFont font, ClickListener listener) {
    super(text, createStyle(font));
    addListener(listener);
  }

  private static TextButtonStyle createStyle(BitmapFont font) {
    TextButtonStyle style = new TextButtonStyle();
    style.font = font;
    style.fontColor = Color.WHITE;
    style.overFontColor = new Color(1, 1, 1, 0.7f);
    style.downFontColor = new Color(1, 1, 1, 0.5f);
    return style;
  }
}
