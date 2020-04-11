package in.praj.rotp.gameplay.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.utils.Pool;

public final class PhysicsComponent implements Component, Pool.Poolable {
    public final Circle circle = new Circle();

    @Override
    public void reset() {
        circle.set(0, 0, 0);
    }
}
