package in.praj.rotp.menu;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import in.praj.rotp.core.Assets;
import in.praj.rotp.core.Screens;

public final class MenuScreen extends ScreenAdapter {
    private final Screens screens;
    private final SpriteBatch batch;

    public MenuScreen(Screens screens, Assets assets) {
        this.screens = screens;
        batch = screens.getSpriteBatch();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
