package com.exiled.core;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.exiled.core.scenes.menu.MenuScreen;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class App extends Game {
    public final static float WIDTH = 1600;
    public final static float HEIGHT = 900;
    public FitViewport viewport;
	public OrthographicCamera camera;
    public SpriteBatch batch;

    @Override
    public void create() {
        batch = new SpriteBatch();
		camera = new OrthographicCamera();
		viewport = new FitViewport(WIDTH, HEIGHT, camera);

        setScreen(new MenuScreen(this)); // pass App reference
    }

    @Override
	public void resize(int width, int height) {
		viewport.update(width, height);
	}

    @Override
    public void dispose() {
        batch.dispose();
        super.dispose();
    }
}