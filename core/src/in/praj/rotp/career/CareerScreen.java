package in.praj.rotp.career;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

import in.praj.rotp.core.AbstractScreen;
import in.praj.rotp.core.Assets;
import in.praj.rotp.core.Screens;
import in.praj.rotp.util.Tab;
import in.praj.rotp.util.TabPane;

public final class CareerScreen extends AbstractScreen {
    public CareerScreen(Screens screens, Assets assets) {
        super(screens, assets);
    }

    @Override
    protected Stage createStage() {
        final Stage stage = new Stage(screens.getViewport(), batch);

        // Root container
        final Table root = new Table(skin);
        root.setFillParent(true);
        root.pad(50).debug();
        root.defaults().expandX();
        stage.addActor(root);

        // Tabs and contents
        TabPane.builder()
                .skin(skin)
                .tab(Tab.builder()
                        .skin(skin)
                        .head("Score")
                        .body(new Label("Overview and scores", skin))
                        .build())
                .tab(Tab.builder()
                        .skin(skin)
                        .head("Medal")
                        .body(new Label("Achievements and stuff", skin))
                        .build())
                .tab(Tab.builder()
                        .skin(skin)
                        .head("Journal")
                        .body(new Label("Info about the germs", skin))
                        .build())
                .build().on(root);

        root.row();
        root.add(createButton("Back", screens::goBack)).colspan(3);

        return stage;
    }
}
