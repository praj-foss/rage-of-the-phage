package io.chakragames.rotp;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public final class Assets {
    private final TextureRegion phageTexture;
    private final TextureRegion virusTexture;
    private final FreeTypeFontGenerator fontGenerator;

    Assets() {
        Texture t1 = new Texture(Gdx.files.internal("Phage.png"));
        t1.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        phageTexture = new TextureRegion(t1);

        Texture t2 = new Texture(Gdx.files.internal("Virus-1.png"));
        t2.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        virusTexture = new TextureRegion(t2);

        fontGenerator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/entsani.ttf"));
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
