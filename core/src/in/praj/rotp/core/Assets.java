package in.praj.rotp.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Disposable;

public final class Assets implements Disposable {
    private final Skin skin;
    private final TextureRegion playerTexture;
    private final TextureRegion bulletTexture;
    private final TextureRegion virusTexture;

    public Assets() {
        skin = new Skin(Gdx.files.internal("skins/shade/uiskin.json"));

        playerTexture = new TextureRegion(new Texture(Gdx.files.internal("Phage-idle.png")));
        bulletTexture = new TextureRegion(new Texture(Gdx.files.internal("type-1.png")));
        virusTexture = new TextureRegion(new Texture(Gdx.files.internal("Zika.png")));
    }

    public TextureRegion getSplashImage() {
        // TODO: Implement this
        return null;
    }

    public TextureRegion getPlayerTexture() {
        return playerTexture;
    }

    public TextureRegion getBulletTexture() {
        return bulletTexture;
    }

    public TextureRegion getVirusTexture() {
        return virusTexture;
    }

    public Skin getSkin() {
        return skin;
    }

    @Override
    public void dispose() {
        skin.dispose();
        playerTexture.getTexture().dispose();
        bulletTexture.getTexture().dispose();
        virusTexture.getTexture().dispose();
    }
}
