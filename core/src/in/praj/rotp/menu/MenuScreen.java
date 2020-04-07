package in.praj.rotp.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import in.praj.rotp.core.Assets;
import in.praj.rotp.core.Screens;

public final class MenuScreen extends ScreenAdapter {
    private final Screens screens;
    private final SpriteBatch batch;
    private final Skin skin;
    private final Stage stage;

    public MenuScreen(Screens screens, Assets assets) {
        this.screens = screens;
        batch = screens.getSpriteBatch();
        skin = assets.getSkin();
        stage = createStage();
    }

    private Stage createStage() {
        final Stage stage = new Stage(screens.getViewport(), batch);

        // Root container
        final Table table = new Table(skin);
        table.setFillParent(true);
        table.pad(100);
        table.defaults()
                .expandX()
                .fillX()
                .spaceBottom(10);
        stage.addActor(table);

        // Menu items
        table.add(createButton("Play", screens::showGameplay)).row();
        table.add(createButton("Store", screens::showStore)).row();
        table.add(createButton("Career", screens::showCareer)).row();
        table.add(createButton("Settings", screens::showSettings)).row();
        table.add(createButton("About", screens::showAbout)).row();
        table.add(createButton("Exit", screens::goBack)).row();

        return stage;
    }

    private TextButton createButton(String text, Runnable onClick) {
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
        super.dispose();
    }
}
