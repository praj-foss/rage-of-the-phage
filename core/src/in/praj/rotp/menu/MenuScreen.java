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
        final Table table = new Table(skin);
        table.setFillParent(true);
        table.pad(100).debug();
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
}
