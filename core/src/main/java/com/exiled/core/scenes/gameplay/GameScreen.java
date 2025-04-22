package com.exiled.core.scenes.gameplay;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen extends ScreenAdapter {
    private final SpriteBatch batch;

    public GameScreen(SpriteBatch batch) {
        this.batch = batch;
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1); // Dark blue background
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        // TODO: Draw your game stuff here
        batch.end();
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void dispose() {
    }
}
