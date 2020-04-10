package in.praj.rotp.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Disposable;

public final class Assets implements Disposable {
    private final Skin skin;
    private final TextureRegion playerTexture;

    public Assets() {
        skin = new Skin(Gdx.files.internal("skins/shade/uiskin.json"));
        final Texture t = new Texture(Gdx.files.internal("Phage-idle.png"));
        playerTexture = new TextureRegion(t);
    }

    public TextureRegion getSplashImage() {
        // TODO: Implement this
        return null;
    }

    public TextureRegion getPlayerTexture() {
        return playerTexture;
    }

    public Skin getSkin() {
        return skin;
    }

    @Override
    public void dispose() {
        skin.dispose();
    }
}
