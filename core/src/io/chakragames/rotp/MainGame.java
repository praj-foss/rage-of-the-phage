package io.chakragames.rotp;

import com.badlogic.gdx.Game;
import io.chakragames.rotp.screens.GameplayScreen;

public class MainGame extends Game {
    private static final String TAG = MainGame.class.getName();
    private static final Assets assets = new Assets();

    @Override
    public void create() {
        assets.load();
        setScreen(new GameplayScreen(assets));
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        assets.dispose();
    }
}
