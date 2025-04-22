package com.exiled.core.scenes.menu.views;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.exiled.core.helper.FontHelper;

public class SettingsView extends Table {
  public SettingsView() {
    BitmapFont font = FontHelper.getAxialFont(32, Color.BLACK);
    TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
    style.font = font;
    style.fontColor = Color.BLACK;
    this.defaults().pad(10);
    this.add(new TextButton("Audio", style)).row();
    this.add(new TextButton("Brightness", style)).row();
    // Add more settings as needed
  }
}