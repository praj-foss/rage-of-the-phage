package in.praj.rotp.about;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

import in.praj.rotp.core.AbstractScreen;
import in.praj.rotp.core.Assets;
import in.praj.rotp.core.Screens;
import in.praj.rotp.util.Tab;
import in.praj.rotp.util.TabPane;

public final class AboutScreen extends AbstractScreen {
    public AboutScreen(Screens screens, Assets assets) {
        super(screens, assets);
    }

    @Override
    protected Stage createStage() {
        final Stage stage = new Stage(screens.getViewport(), batch);

        // Root container
        final Table root = new Table(skin);
        root.setFillParent(true);
        root.pad(50);
        root.defaults().expandX();
        stage.addActor(root);

        // Tabs and contents
        TabPane.builder()
                .skin(skin)
                .tab(Tab.builder()
                        .skin(skin)
                        .head("Team")
                        .body(new Label("Priyadarshi Raj\nPulak Das\nSonya Okolelova", skin))
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
}
