package io.chakragames.rotp;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public final class Assets {
    private final Skin skin;
    private final TextureRegion phageTexture;
    private final TextureRegion virusTexture;
    private final FreeTypeFontGenerator fontGenerator;

    Assets() {
        skin = new Skin(Gdx.files.internal("skins/shade/uiskin.json"));

        Texture t1 = new Texture(Gdx.files.internal("Phage.png"));
        t1.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        phageTexture = new TextureRegion(t1);

        Texture t2 = new Texture(Gdx.files.internal("Zika.png"));
        t2.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        virusTexture = new TextureRegion(t2);

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

    public FreeTypeFontGenerator getFontGenerator() {
        return fontGenerator;
    }

    void dispose() {
        fontGenerator.dispose();
    }
}
