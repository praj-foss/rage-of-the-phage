package io.chakragames.rotp;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Disposable;

public final class Assets implements Disposable {

    private Texture phageTexture;
    private Texture virus1Texture;
    private Texture virus2Texture;
    private Texture virus3Texture;

    Assets() {
    }

    void load() {
        phageTexture = new Texture(Gdx.files.internal("Phage.png"));
        virus1Texture = new Texture(Gdx.files.internal("Virus-1.png"));
        virus2Texture = new Texture(Gdx.files.internal("Virus-2.png"));
        virus3Texture = new Texture(Gdx.files.internal("Virus-3.png"));
    }

    public Texture getPhageTexture() {
        return phageTexture;
    }

    public Texture getVirus1Texture() {
        return virus1Texture;
    }

    public Texture getVirus2Texture() {
        return virus2Texture;
    }

    public Texture getVirus3Texture() {
        return virus3Texture;
    }

    @Override
    public void dispose() {

    }
}
