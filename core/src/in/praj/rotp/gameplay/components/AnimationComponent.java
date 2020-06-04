package in.praj.rotp.gameplay.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Pool;

public final class AnimationComponent implements Component, Pool.Poolable {
    public float time;
    public Animation<TextureRegion> animation;

    @Override
    public void reset() {
        time = 0f;
        animation = null;
    }
}
