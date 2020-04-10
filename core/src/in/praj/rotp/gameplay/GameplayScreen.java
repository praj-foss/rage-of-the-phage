package in.praj.rotp.gameplay;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import in.praj.rotp.core.AbstractScreen;
import in.praj.rotp.core.Assets;
import in.praj.rotp.core.Screens;

public final class GameplayScreen extends AbstractScreen {
    private final Level level;

    public GameplayScreen(Screens screens, Assets assets) {
        super(screens, assets);
        level = new Level(assets, batch);
    }

    @Override
    protected Stage createStage() {
        final Stage stage = new Stage(screens.getViewport(), batch);

        // Root container
        final Table root = new Table(skin);
        root.setFillParent(true);
        root.debug();
        stage.addActor(root);

        // Upper bar
        root.add("Score").colspan(2).left();
        root.add(createButton("Back", screens::goBack));
        root.row();
        root.add().colspan(3).expand();
        root.row();

        // Buffs
        root.add("Buffs").colspan(3);
        root.row();

        // Left button
        final Button leftButton = new TextButton("<=", skin);
        leftButton.addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                level.leftButtonDown();
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                level.leftButtonUp();
            }
        });
        root.add(leftButton);

        // Health
        root.add("Health").expandX();

        // Right button
        final Button rightButton = new TextButton("=>", skin);
        rightButton.addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                level.rightButtonDown();
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                level.rightButtonUp();
            }
        });
        root.add(rightButton);

        return stage;
    }

    @Override
    public void show() {
        super.show();
        level.start();
    }

    @Override
    public void render(float delta) {
        screens.clear();
        level.update(delta);
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void hide() {
        level.stop();
    }
}
