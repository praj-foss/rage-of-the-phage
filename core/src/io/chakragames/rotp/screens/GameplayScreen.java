package io.chakragames.rotp.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;

import io.chakragames.rotp.Assets;
import io.chakragames.rotp.gameplay.GameRenderer;
import io.chakragames.rotp.gameplay.GameWorld;

public class GameplayScreen implements Screen {
    private static final String TAG = GameplayScreen.class.getName();

    private final GameWorld world;
    private final GameRenderer renderer;

    public GameplayScreen(Assets assets) {
        world = new GameWorld(assets);
        renderer = new GameRenderer(world);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(world.getInputProcessor());
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        world.update(delta);
        renderer.render();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
