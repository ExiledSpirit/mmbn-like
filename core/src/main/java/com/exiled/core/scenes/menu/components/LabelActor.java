package com.exiled.core.scenes.menu.components;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

/**
 * A very simple actor that displays a centered label text, styled manually with
 * a BitmapFont.
 */
public class LabelActor extends Table {

  public LabelActor(String text, BitmapFont font) {
    this.defaults().center();
    this.setFillParent(true);

    LabelStyle style = new LabelStyle();
    style.font = font;
    style.fontColor = Color.WHITE; // or whatever color you want

    Label label = new Label(text, style);
    this.add(label);
  }
}