package io.chakragames.rotp.components;

import com.badlogic.ashley.core.Component;

public final class VelocityComponent implements Component {
    public float x;
    public float y;

    public VelocityComponent() {
        this(0, 0);
    }

    public VelocityComponent(float x, float y) {
        this.x = x;
        this.y = y;
    }
}
