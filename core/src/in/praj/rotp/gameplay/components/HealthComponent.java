package in.praj.rotp.gameplay.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.utils.Pool;

public final class HealthComponent implements Component, Pool.Poolable {
    public int value;

    @Override
    public void reset() {
        value = 0;
    }
}
