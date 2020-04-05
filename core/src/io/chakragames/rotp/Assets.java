package io.chakragames.rotp;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public final class Assets {
    private final Skin skin;
    private final TextureRegion phageTexture;
    private final Animation<TextureRegion> phageMoveRightAnimation;
    private final Animation<TextureRegion> phageMoveLeftAnimation;
    private final TextureRegion virusTexture;
    private final FreeTypeFontGenerator fontGenerator;

    Assets() {
        skin = new Skin(Gdx.files.internal("skins/shade/uiskin.json"));

        Texture t1 = new Texture(Gdx.files.internal("Phage-idle.png"));
        t1.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        phageTexture = new TextureRegion(t1);

        Texture t2 = new Texture(Gdx.files.internal("Phage-run.png"));
        t2.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        TextureRegion[][] split = TextureRegion.split(t2, 48, 96);
        TextureRegion[] regRight = new TextureRegion[6];
        TextureRegion[] regLeft = new TextureRegion[6];
        System.arraycopy(split[0], 0, regRight, 0, 6);
        for (int i = 0; i < 6; i++)
            regLeft[i] = regRight[5 - i];

        float frameDuration = 0.06f;
        phageMoveRightAnimation = new Animation<>(frameDuration, regRight);
        phageMoveLeftAnimation = new Animation<>(frameDuration, regLeft);

        Texture t3 = new Texture(Gdx.files.internal("Zika.png"));
        t3.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        virusTexture = new TextureRegion(t3);

        fontGenerator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/entsani.ttf"));
    }

    public Skin getSkin() {
        return skin;
    }

    public TextureRegion getPhageTexture() {
        return phageTexture;
    }

    public TextureRegion getVirusTexture() {
        return virusTexture;
    }

    public Animation<TextureRegion> getPhageMoveRightAnimation() {
        return phageMoveRightAnimation;
    }

    public Animation<TextureRegion> getPhageMoveLeftAnimation() {
        return phageMoveLeftAnimation;
    }

    public FreeTypeFontGenerator getFontGenerator() {
        return fontGenerator;
    }

    void dispose() {
        fontGenerator.dispose();
    }
}
