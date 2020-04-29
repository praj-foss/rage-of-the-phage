package in.praj.rotp.core;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Disposable;

public final class Assets implements Disposable {
    private final AssetManager manager;
    private final TextureAtlas atlas;
    private final Skin skin;
    private final Skin defaultSkin;
    private final TextureRegion playerTexture;
    private final TextureRegion bulletTexture;
    private final TextureRegion virusTexture;

    public Assets() {
        manager = new AssetManager();
        manager.load("skins/shade/uiskin.json", Skin.class);
        manager.load("default.atlas", TextureAtlas.class);
        manager.load("fonts/fatpixel-24.fnt", BitmapFont.class);
        manager.finishLoading();

        skin = manager.get("skins/shade/uiskin.json", Skin.class);
        atlas = manager.get("default.atlas", TextureAtlas.class);
        BitmapFont font = manager.get("fonts/fatpixel-24.fnt");

        defaultSkin = new DefaultSkin(atlas, font);

        playerTexture = atlas.findRegion("phage-idle");
        bulletTexture = atlas.findRegion("bullet-2");
        virusTexture = atlas.findRegion("virus-zika");
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

    public Skin getDefaultSkin() {
        return defaultSkin;
    }

    public TextureRegion getRegion(String name) {
        return atlas.findRegion(name);
    }

    @Override
    public void dispose() {
        defaultSkin.dispose();
        manager.dispose();
    }
}
