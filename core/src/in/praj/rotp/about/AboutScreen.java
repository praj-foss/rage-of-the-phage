package in.praj.rotp.about;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import in.praj.rotp.core.Assets;
import in.praj.rotp.core.Screens;
import in.praj.rotp.util.Tab;
import in.praj.rotp.util.TabPane;

public final class AboutScreen extends ScreenAdapter {
    private final Screens screens;
    private final SpriteBatch batch;
    private final Skin skin;
    private final Stage stage;

    public AboutScreen(Screens screens, Assets assets) {
        this.screens = screens;
        batch = screens.getSpriteBatch();
        skin = assets.getSkin();
        stage = createStage();
    }

    private Stage createStage() {
        final Stage stage = new Stage(screens.getViewport(), batch);

        // Root container
        final Table root = new Table(skin);
        root.setFillParent(true);
        root.defaults().expandX();
        root.pad(50);
        root.debug();
        stage.addActor(root);

        // Tabs and contents
        TabPane.builder()
                .skin(skin)
                .tab(Tab.builder()
                        .skin(skin)
                        .head("Team")
                        .body(new Label("Team texts go here", skin))
                        .build())
                .tab(Tab.builder()
                        .skin(skin)
                        .head("Licenses")
                        .body(new Label("License texts go here", skin))
                        .build())
                .build().on(root);

        root.row();
        root.add(createButton("Back", screens::goBack)).colspan(2);

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
        stage.dispose();
    }
}
