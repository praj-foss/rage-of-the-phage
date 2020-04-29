package in.praj.rotp.core;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.DistanceFieldFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.Stack;

import in.praj.rotp.about.AboutScreen;
import in.praj.rotp.career.CareerScreen;
import in.praj.rotp.gameplay.GameplayScreen;
import in.praj.rotp.menu.MenuScreen;
import in.praj.rotp.menu.SplashScreen;
import in.praj.rotp.settings.SettingsScreen;
import in.praj.rotp.store.StoreScreen;

/**
 * Provides functionality to switch between screens.
 */
public final class Screens implements Disposable {
    private static final String TAG = Screens.class.getName();

    private final Game game;
    private final SpriteBatch spriteBatch;
    private final Viewport viewport;

    // Available screens
    private final Stack<Screen> history;
    private final Screen splashScreen;
    private final Screen menuScreen;
    private final Screen gameplayScreen;
    private final Screen storeScreen;
    private final Screen careerScreen;
    private final Screen settingsScreen;
    private final Screen aboutScreen;

    public Screens(Game game, Assets assets) {
        this.game = game;
        spriteBatch = new SpriteBatch(1000, DistanceFieldFont.createDistanceFieldShader());
//        spriteBatch = new SpriteBatch();
        viewport = new FitViewport(288, 512);

        history = new Stack<>();
        splashScreen = new SplashScreen(this, assets);
        menuScreen = new MenuScreen(this, assets);
        gameplayScreen = new GameplayScreen(this, assets);
        storeScreen = new StoreScreen(this, assets);
        careerScreen = new CareerScreen(this, assets);
        settingsScreen = new SettingsScreen(this, assets);
        aboutScreen = new AboutScreen(this, assets);
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
        showScreen(gameplayScreen);
    }

    public void showStore() {
        Gdx.app.log(TAG, "Opening Store screen");
        showScreen(storeScreen);
    }

    public void showCareer() {
        Gdx.app.log(TAG, "Opening Career screen");
        showScreen(careerScreen);
    }

    public void showSettings() {
        Gdx.app.log(TAG, "Opening Settings screen");
        showScreen(settingsScreen);
    }

    public void showAbout() {
        Gdx.app.log(TAG, "Opening About screen");
        showScreen(aboutScreen);
    }

    private void showScreen(Screen screen) {
        history.push(game.getScreen());
        game.setScreen(screen);
    }

    public void goBack() {
        if (!history.empty())
            game.setScreen(history.pop());
        else {
            Gdx.app.log(TAG, "Exiting app");
            Gdx.app.exit();
        }
    }

    public void clear() {
        Gdx.gl20.glClearColor(49/255f, 124/255f, 135/255f, 1f);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
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
        menuScreen.dispose();
        gameplayScreen.dispose();
        storeScreen.dispose();
        careerScreen.dispose();
        settingsScreen.dispose();
        aboutScreen.dispose();
        spriteBatch.dispose();
    }
}
