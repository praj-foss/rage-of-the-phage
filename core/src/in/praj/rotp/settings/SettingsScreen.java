package in.praj.rotp.settings;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

import in.praj.rotp.core.AbstractScreen;
import in.praj.rotp.core.Assets;
import in.praj.rotp.core.Screens;
import in.praj.rotp.util.Tab;
import in.praj.rotp.util.TabPane;

public final class SettingsScreen extends AbstractScreen {
    public SettingsScreen(Screens screens, Assets assets) {
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
                        .head("Game")
                        .body(new Label("Gameplay settings here", skin))
                        .build())
                .tab(Tab.builder()
                        .skin(skin)
                        .head("Acc")
                        .body(new Label("Account preferences here", skin))
                        .build())
                .build().on(root);

        root.row();
        root.add(createButton("Back", screens::goBack)).colspan(2);

        return stage;
    }
}
