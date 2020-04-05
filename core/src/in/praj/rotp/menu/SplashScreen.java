package in.praj.rotp.menu;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import in.praj.rotp.core.Assets;
import in.praj.rotp.core.Screens;

/**
 * First screen that appears. Contains a splash image.
 */
public final class SplashScreen extends ScreenAdapter {
    private final Screens screens;
    private final TextureRegion splashImage;
    private final SpriteBatch batch;

    public SplashScreen(Screens screens, Assets assets) {
        this.screens = screens;
        splashImage = assets.getSplashImage();
        batch = screens.getSpriteBatch();
    }

    @Override
    public void render(float delta) {
        batch.begin();
        // TODO: Draw here
        batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
