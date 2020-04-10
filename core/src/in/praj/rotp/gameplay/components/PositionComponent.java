package in.praj.rotp.gameplay.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.utils.Pool;

public final class PositionComponent implements Component, Pool.Poolable {
    public float x;
    public float y;

    @Override
    public void reset() {
        x = 0f;
        y = 0f;
    }
}
