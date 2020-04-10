package in.praj.rotp.gameplay.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.utils.Pool;

public final class MovementInputComponent implements Component, Pool.Poolable {
    public float xSpeed;

    @Override
    public void reset() {
        xSpeed = 0f;
    }
}
