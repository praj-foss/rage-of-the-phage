package in.praj.rotp.core;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.BitmapFontLoader;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Disposable;

public final class Assets implements Disposable {
    private static final String ATLAS = "default.atlas";
    private static final String FONT_LARGE  = "Bonk-36.fnt";
    private static final String FONT_MEDIUM = "Bonk-24.fnt";

    private final AssetManager manager;
    private final TextureAtlas atlas;
    private final Skin skin;
    private final TextureRegion playerTexture;
//    private final TextureRegion playerRunTexture;
    private final Animation<TextureRegion> playerRunRightAnimation;
    private final Animation<TextureRegion> playerRunLeftAnimation;
    private final TextureRegion bulletTexture;
    private final TextureRegion virusTexture;

    public Assets() {
        manager = new AssetManager();
        manager.load(ATLAS, TextureAtlas.class);

        final BitmapFontLoader.BitmapFontParameter param =
                new BitmapFontLoader.BitmapFontParameter();
        param.atlasName = ATLAS;
        manager.load(FONT_LARGE, BitmapFont.class, param);
        manager.load(FONT_MEDIUM, BitmapFont.class, param);
        manager.finishLoading();

        atlas = manager.get(ATLAS, TextureAtlas.class);
        skin = new DefaultSkin(
                atlas, manager.get(FONT_LARGE), manager.get(FONT_MEDIUM)
        );

        playerTexture = atlas.findRegion("phage3-idle");
//        playerRunTexture = atlas.findRegion("phage3-run");
        bulletTexture = atlas.findRegion("bullet-2");
        virusTexture = atlas.findRegion("virus-zika");

        playerRunRightAnimation = new Animation<>(0.04f, atlas.findRegions("run"), Animation.PlayMode.LOOP);
        playerRunLeftAnimation = new Animation<>(0.04f, atlas.findRegions("run"), Animation.PlayMode.REVERSED);
    }

    public TextureRegion getSplashImage() {
        // TODO: Implement this
        return null;
    }

    public Animation<TextureRegion> getPlayerRunRightAnimation() {
        return playerRunRightAnimation;
    }

    public Animation<TextureRegion> getPlayerRunLeftAnimation() {
        return playerRunLeftAnimation;
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

    public TextureRegion getRegion(String name) {
        return atlas.findRegion(name);
    }

    @Override
    public void dispose() {
        skin.dispose();
        manager.dispose();
    }
}
