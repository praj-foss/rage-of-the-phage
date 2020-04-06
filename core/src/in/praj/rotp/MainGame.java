package in.praj.rotp;

import com.badlogic.gdx.Game;

import in.praj.rotp.core.Assets;
import in.praj.rotp.core.Screens;

public final class MainGame extends Game {
    private Assets assets;
    private Screens screens;

    @Override
    public void create() {
        assets = new Assets();
        screens = new Screens(this, assets);
        screens.showMenu();
    }

    @Override
    public void dispose() {
        screens.dispose();
        assets.dispose();
    }
}
