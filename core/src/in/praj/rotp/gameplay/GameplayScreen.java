package in.praj.rotp.gameplay;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.HorizontalGroup;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import in.praj.rotp.core.AbstractScreen;
import in.praj.rotp.core.Assets;
import in.praj.rotp.core.Screens;

public final class GameplayScreen extends AbstractScreen {
    private final Level level;
    private Label scoreLabel;
    private Label healthLabel;

    public GameplayScreen(Screens screens, Assets assets) {
        super(screens, assets);
        level = new Level(this, assets, batch, screens.getViewport());
    }

    @Override
    protected Stage createStage() {
        final Stage stage = new Stage(screens.getViewport(), batch);

        // Root container
        final Table root = new Table(skin);
        root.setFillParent(true);
//        root.debug();
        stage.addActor(root);

        // Upper bar
        scoreLabel = new Label(null, skin);
        root.add(scoreLabel).colspan(2).left().padLeft(10);
        root.add(createButton("<<", screens::goBack));
        root.row();
        root.add().colspan(3).expand();
        root.row();

        // Buffs
        final HorizontalGroup hg = new HorizontalGroup();
        hg.space(8);
        hg.pad(4);
        hg.addActor(newBuffButton(skin2, "buff-thunder"));
        hg.addActor(newBuffButton(skin2, "buff-2x"));
        hg.addActor(newBuffButton(skin2, "buff-split"));
        hg.addActor(newBuffButton(skin2, "buff-shield"));
        hg.addActor(newBuffButton(skin2, null));
        hg.addActor(newBuffButton(skin2, null));
        root.add(hg).colspan(3);
        root.row();

        // Left button
        final Button leftButton = newBuffButton(skin2, "move-left");
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
        root.padBottom(4).add(leftButton).padLeft(4);

        // Health
        healthLabel = new Label(null, skin);
        root.add(healthLabel).expandX().height(32);

        // Right button
        final Button rightButton = newBuffButton(skin2, "move-right");
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
        root.add(rightButton).padRight(4);

        return stage;
    }

    private ImageButton newBuffButton(Skin skin, String icon) {
        final ImageButton btn = new ImageButton(
                new ImageButton.ImageButtonStyle(
                        skin.get(ImageButton.ImageButtonStyle.class)));
        if (icon != null)
            btn.getStyle().imageUp = new TextureRegionDrawable(assets.getRegion(icon));
        else
            btn.setDisabled(true);

        return btn;
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

    void updateScore(String score) {
        this.scoreLabel.setText(score);
    }

    void updateHealth(int health) {
        this.healthLabel.setText("Health: " + health);
    }
}
