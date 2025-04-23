package com.exiled.core.scenes.gameplay;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.exiled.core.App;
import com.exiled.core.models.Grid;

public class GameScreen extends ScreenAdapter {
    public final static float WIDTH = 100;
    public final static float HEIGHT = 16 * WIDTH / 9;
    private final SpriteBatch batch;
    private final GridRender gridRender;
    private final App app;

    public GameScreen(App app) {
        this.app = app;
        this.batch = app.batch;
        this.gridRender = new GridRender(app);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(255, 255, 255, 1); // Dark blue background
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        Grid grid = new Grid(6, 3);
        this.gridRender.renderGrid(grid);
        batch.end();
    }

    @Override
    public void dispose() {
    }
}
