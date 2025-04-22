package com.exiled.core;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.exiled.core.scenes.menu.MenuScreen;

import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class App extends Game {
    public SpriteBatch batch;

    @Override
    public void create() {
        batch = new SpriteBatch();

        setScreen(new MenuScreen(this)); // pass App reference
    }

    @Override
    public void dispose() {
        batch.dispose();
        super.dispose();
    }
}