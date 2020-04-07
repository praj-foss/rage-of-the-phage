package in.praj.rotp.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Disposable;

public final class Assets implements Disposable {
    private final Skin skin;

    public Assets() {
        skin = new Skin(Gdx.files.internal("skins/shade/uiskin.json"));
    }

    public TextureRegion getSplashImage() {
        // TODO: Implement this
        return null;
    }

    public Skin getSkin() {
        return skin;
    }

    @Override
    public void dispose() {
        skin.dispose();
    }
}
