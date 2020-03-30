package io.chakragames.rotp;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Disposable;

public final class Assets implements Disposable {

    private TextureRegion phageTexture;
    private TextureRegion virusTexture;

    Assets() {
    }

    void load() {
        Texture t1 = new Texture(Gdx.files.internal("Phage.png"));
        t1.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        phageTexture = new TextureRegion(t1);

        Texture t2 = new Texture(Gdx.files.internal("Virus-1.png"));
        t2.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        virusTexture = new TextureRegion(t2);
    }

    public TextureRegion getPhageTexture() {
        return phageTexture;
    }

    public TextureRegion getVirusTexture() {
        return virusTexture;
    }

    @Override
    public void dispose() {

    }
}
