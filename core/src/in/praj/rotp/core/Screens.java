package in.praj.rotp.core;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import in.praj.rotp.menu.MenuScreen;
import in.praj.rotp.menu.SplashScreen;

/**
 * Provides functionality to switch between screens.
 */
public final class Screens implements Disposable {
    private static final String TAG = Screens.class.getName();

    private final Game game;
    private final Assets assets;
    private final SpriteBatch spriteBatch;
    private final Viewport viewport;

    // Available screens
    private final Screen splashScreen;
    private final Screen menuScreen;

    public Screens(Game game, Assets assets) {
        this.game = game;
        this.assets = assets;
        spriteBatch = new SpriteBatch();
        viewport = new FitViewport(288, 512);

        splashScreen = new SplashScreen(this, assets);
        menuScreen = new MenuScreen(this, assets);
    }

    public void showSplash() {
        Gdx.app.log(TAG, "Opening Splash screen");
        game.setScreen(splashScreen);
    }

    public void showMenu() {
        Gdx.app.log(TAG, "Opening Menu screen");
        game.setScreen(menuScreen);
    }

    public void showGameplay() {
        Gdx.app.log(TAG, "Opening Gameplay screen");
    }

    public void showStore() {
        Gdx.app.log(TAG, "Opening Store screen");
    }

    public void showCareer() {
        Gdx.app.log(TAG, "Opening Career screen");
    }

    public void showSettings() {
        Gdx.app.log(TAG, "Opening Settings screen");
    }

    public void showAbout() {
        Gdx.app.log(TAG, "Opening About screen");
    }

    public void exit() {
        Gdx.app.log(TAG, "Exiting app");
        Gdx.app.exit();
    }

    public SpriteBatch getSpriteBatch() {
        return spriteBatch;
    }

    public Viewport getViewport() {
        return viewport;
    }

    @Override
    public void dispose() {
        splashScreen.dispose();
        spriteBatch.dispose();
    }
}
