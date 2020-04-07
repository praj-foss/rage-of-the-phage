package in.praj.rotp.about;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import in.praj.rotp.core.Assets;
import in.praj.rotp.core.Screens;

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
        root.defaults()
                .expandX()
                .fillX();
        root.pad(50);
        root.debug();
        stage.addActor(root);

        final ScrollPane content = new ScrollPane(null, skin);
        content.setScrollingDisabled(true, false);
        content.setHeight(200);

        // Tabs and contents
        final Label textTeam = new Label("Team text goes here", skin);
        final Label textCredits = new Label("Credits text goes here", skin);

        root.add(
                createButton("Team", () -> content.setActor(textTeam)),
                createButton("Credits", () -> content.setActor(textCredits)));
        root.row();
        root.add(content).colspan(2);
        content.setActor(textTeam);

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
