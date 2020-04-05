package io.chakragames.rotp.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;

import io.chakragames.rotp.MainGame;
import io.chakragames.rotp.gameplay.GameWorld;
import io.chakragames.rotp.gameplay.StatusDisplay;

public class GameplayScreen extends ScreenAdapter {
    private static final String TAG = GameplayScreen.class.getName();

    private final MainGame game;
    private final GameWorld world;
    private final StatusDisplay hud;

    public GameplayScreen(MainGame game) {
        this.game = game;
        world = new GameWorld(game.getAssets());
        hud = new StatusDisplay(game.getAssets(), world);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(world.getInputProcessor());
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(255/255f, 246/255f, 211/255f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        world.update(delta);
    }
}
