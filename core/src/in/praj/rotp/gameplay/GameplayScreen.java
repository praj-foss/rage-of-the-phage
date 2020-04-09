package in.praj.rotp.gameplay;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

import in.praj.rotp.core.AbstractScreen;
import in.praj.rotp.core.Assets;
import in.praj.rotp.core.Screens;

public final class GameplayScreen extends AbstractScreen {
    public GameplayScreen(Screens screens, Assets assets) {
        super(screens, assets);
    }

    @Override
    protected Stage createStage() {
        final Stage stage = new Stage(screens.getViewport(), batch);

        // Root container
        final Table root = new Table(skin);
        root.setFillParent(true);
        root.debug();
        stage.addActor(root);

        root.add("Score").colspan(2).left();
        root.add(createButton("Back", screens::goBack));
        root.row();
        root.add().colspan(3).expand();
        root.row();
        root.add("Buffs").colspan(3);
        root.row();
        root.add(createButton("<=", () -> {}));
        root.add("Health").expandX();
        root.add(createButton("=>", () -> {}));

        return stage;
    }
}
