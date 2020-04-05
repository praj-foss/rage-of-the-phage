package in.praj.rotp.core;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;

import in.praj.rotp.menu.MenuScreen;
import in.praj.rotp.menu.SplashScreen;

/**
 * Provides functionality to switch between screens.
 */
public final class Screens implements Disposable {
    private final Game game;
    private final Assets assets;
    private final SpriteBatch spriteBatch;

    // Available screens
    private final Screen splashScreen;
    private final Screen menuScreen;

    public Screens(Game game, Assets assets) {
        this.game = game;
        this.assets = assets;
        spriteBatch = new SpriteBatch();

        splashScreen = new SplashScreen(this, assets);
        menuScreen = new MenuScreen(this, assets);
    }

    public void showSplash() {
        game.setScreen(splashScreen);
    }

    public void showMenu() {
        game.setScreen(menuScreen);
    }

    public SpriteBatch getSpriteBatch() {
        return spriteBatch;
    }

    @Override
    public void dispose() {
        splashScreen.dispose();
        spriteBatch.dispose();
    }
}
