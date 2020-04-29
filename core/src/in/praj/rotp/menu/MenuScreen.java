package in.praj.rotp.menu;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

import in.praj.rotp.core.AbstractScreen;
import in.praj.rotp.core.Assets;
import in.praj.rotp.core.Screens;

public final class MenuScreen extends AbstractScreen {
    public MenuScreen(Screens screens, Assets assets) {
        super(screens, assets);
    }

    @Override
    protected Stage createStage() {
        final Stage stage = new Stage(screens.getViewport(), batch);

        // Root container
        final Table root = new Table(skin);
        root.setFillParent(true);
        root.pad(48);
        root.defaults()
                .expandX()
                .fillX()
                .spaceBottom(10);
        stage.addActor(root);

        // Menu items
        root.add(createButton("Play", screens::showGameplay)).row();
        root.add(createButton("Store", screens::showStore)).row();
        root.add(createButton("Career", screens::showCareer)).row();
        root.add(createButton("Settings", screens::showSettings)).row();
        root.add(createButton("About", screens::showAbout)).row();
        root.add(createButton("Exit", screens::goBack)).row();

        return stage;
    }
}
