package in.praj.rotp.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public abstract class AbstractScreen extends ScreenAdapter {
    protected final Screens screens;
    protected final SpriteBatch batch;
    protected final Skin skin;
    private final Stage stage;

    public AbstractScreen(Screens screens, Assets assets) {
        this.screens = screens;
        batch = screens.getSpriteBatch();
        skin = assets.getSkin();
        stage = createStage();
    }

    protected abstract Stage createStage();

    protected TextButton createButton(String text, Runnable onClick) {
        final TextButton btn = new TextButton(text, skin);
        btn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                onClick.run();
            }
        });
        return btn;
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        screens.clear();
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}