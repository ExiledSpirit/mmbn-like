package com.exiled.core.scenes.menu;

import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.exiled.core.helper.FontHelper;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.Color;
import java.util.ArrayList;
import java.util.List;

public class Navbar extends Table {
    private final List<TextButton> buttons = new ArrayList<>();
    private final MenuStateManager stateManager;

    private final Color normalColor = Color.valueOf("909c9c"); // normal text color
    private final Color hoverColor = Color.WHITE; // hover text color
    private final Color backgroundColor = Color.valueOf("758384"); // navbar background

    public Navbar(MenuStateManager stateManager) {
        this.stateManager = stateManager;
        this.left();
        this.pad(10);
        this.setBackground(new MenuBackground(backgroundColor)); // Background set

        for (MenuState state : MenuState.values()) {
            TextButton button = createNavButton(state);
            addHoverEffect(button, state);
            buttons.add(button);
            add(button).pad(10);
        }

        // Listen to state changes and highlight active
        stateManager.addListener(this::refreshHighlight);
        refreshHighlight(stateManager.getState());
    }

    private TextButton createNavButton(MenuState state) {
        BitmapFont font = FontHelper.getAxialFont(32, normalColor);

        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        style.font = font;
        style.fontColor = normalColor;

        return new TextButton(state.name(), style);
    }

    private void addHoverEffect(TextButton button, MenuState buttonState) {
        button.addListener(new ClickListener() {
            @Override
            public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
                button.getLabel().setColor(hoverColor);
            }

            @Override
            public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
                if (stateManager.getState() != buttonState) {
                    button.getLabel().setColor(normalColor);
                }
            }

            @Override
            public void clicked(InputEvent event, float x, float y) {
                stateManager.setState(buttonState);
            }
        });
    }

    private void refreshHighlight(MenuState activeState) {
        for (TextButton button : buttons) {
            MenuState buttonState = MenuState.valueOf(button.getText().toString());
            if (buttonState == activeState) {
                button.getLabel().setColor(hoverColor); // Active stays white
            } else {
                button.getLabel().setColor(normalColor);
            }
        }
    }
}
