package in.praj.rotp.menu;

import com.badlogic.gdx.scenes.scene2d.Stage;

import in.praj.rotp.core.AbstractScreen;
import in.praj.rotp.core.Assets;
import in.praj.rotp.core.Screens;

/**
 * First screen that appears. Contains a splash image.
 */
public final class SplashScreen extends AbstractScreen {
    public SplashScreen(Screens screens, Assets assets) {
        super(screens, assets);
    }

    @Override
    protected Stage createStage() {
        // TODO: Add splash image here
        return new Stage(screens.getViewport(), batch);
    }
}
