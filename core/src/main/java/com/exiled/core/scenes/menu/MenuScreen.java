package com.exiled.core.scenes.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.exiled.core.App;
import com.exiled.core.constants.Colors;
import com.exiled.core.helper.FontHelper;
import com.exiled.core.scenes.gameplay.GameScreen;
import com.exiled.core.scenes.menu.components.LabelActor;
import com.exiled.core.scenes.menu.views.DeckView;
import com.exiled.core.scenes.menu.views.SettingsView;

public class MenuScreen extends ScreenAdapter {
  private final Stage stage;
  private final Table root;
  private final Table contentArea;
  private final MenuStateManager stateManager;
  private final App app;
  private final Batch batch;

  public MenuScreen(App app) {
    this.app = app;
    this.batch = app.batch;
    this.stage = new Stage(new ScreenViewport(), batch);
    Gdx.input.setInputProcessor(stage);

    root = new Table();
    root.setFillParent(true);
    stage.addActor(root);

    this.stateManager = new MenuStateManager(MenuState.HOME);

    Navbar navBar = new Navbar(stateManager);
    root.top().add(navBar).expandX().fillX().row();

    contentArea = new Table();
    contentArea.setBackground(new MenuBackground(Colors.PRIMARY));
    root.add(contentArea).expand().fill();

    // Listen to state changes
    stateManager.addListener(this::onStateChanged);

    // Start
    onStateChanged(stateManager.getState());
  }

  private void onStateChanged(MenuState state) {
    contentArea.clear();
    switch (state) {
      case PLAY ->
        // fade out menu stage
        stage.addAction(Actions.sequence(
            Actions.fadeOut(0.5f),
            Actions.run(() -> app.setScreen(new GameScreen(app)))));
      case SETTINGS -> contentArea.add(new SettingsView());
      case DECK -> contentArea.add(new DeckView());
      case EXIT -> Gdx.app.exit();
    }
  }

  @Override
  public void render(float delta) {
    stage.act(delta);
    stage.draw();
  }

  @Override
  public void resize(int width, int height) {
    stage.getViewport().update(width, height, true);
  }

  @Override
  public void dispose() {
    stage.dispose();
  }
}