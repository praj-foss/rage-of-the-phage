package io.chakragames.rotp.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

import io.chakragames.rotp.MainGame;

public class MenuScreen extends ScreenAdapter {
    private final MainGame game;
    private Stage stage;

    public MenuScreen(MainGame game) {
        this.game = game;
        stage = new Stage();
        createUI();
    }

    private void createUI() {
        // Font and style
        final Skin skin = game.getAssets().getSkin();

        // Play button
        final TextButton btnPlay = new TextButton("Play", skin);
        btnPlay.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.openGameplayScreen();
            }
        });

        // Settings button
        final TextButton btnSettings = new TextButton("Settings", skin);
        btnSettings.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.openSettingsScreen();
            }
        });

        // Exit button
        final TextButton btnExit = new TextButton("Exit", skin);
        btnExit.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.exit();
            }
        });

        // Root container
        final VerticalGroup root = new VerticalGroup();
        root.setFillParent(true);
        root.center();
        root.space(10);
        root.addActor(btnPlay);
        root.addActor(btnSettings);
        root.addActor(btnExit);

        stage.addActor(root);
//        stage.setDebugAll(true);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        Gdx.gl20.glClearColor(0, 0, 0, 1);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
