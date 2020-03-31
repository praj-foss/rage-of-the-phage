package io.chakragames.rotp;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

import io.chakragames.rotp.screens.GameplayScreen;
import io.chakragames.rotp.screens.MenuScreen;

public class MainGame extends Game {
    private static final String TAG = MainGame.class.getName();
    private Assets assets;
    private Screen menuScreen;
    private Screen gameplayScreen;

    @Override
    public void create() {
        assets = new Assets();
        menuScreen = new MenuScreen(this);
        gameplayScreen = new GameplayScreen(this);
        openMenuScreen();
    }

    public void openMenuScreen() {
        setScreen(menuScreen);
    }

    public void openGameplayScreen() {
        setScreen(gameplayScreen);
    }

    public void openSettingsScreen() {
        // Not implemented
    }

    public void exit() {
        Gdx.app.exit();
    }

    public Assets getAssets() {
        return assets;
    }

    @Override
    public void dispose() {
        assets.dispose();
        menuScreen.dispose();
    }
}
