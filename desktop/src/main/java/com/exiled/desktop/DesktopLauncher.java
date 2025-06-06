package com.exiled.desktop;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.exiled.core.App;

public class DesktopLauncher {
    public static void main(String[] args) {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setTitle("MMBN Game");
        config.setWindowedMode(1280, 720);
        config.useVsync(true);
        new Lwjgl3Application(new App(), config);
    }
}