package io.chakragames.rotp.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Stores a {@link TextureRegion} than can be drawn.
 */
public final class TextureComponent implements Component {
    public TextureRegion region;

    public TextureComponent(TextureRegion region) {
        this.region = region;
    }
}
