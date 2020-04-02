package io.chakragames.rotp.components;

import com.badlogic.ashley.core.Component;

/**
 * Stores x and y co-ordinates of current position.
 */
public final class PositionComponent implements Component {
    public float x;
    public float y;

    public PositionComponent() {
        this(0, 0);
    }

    public PositionComponent(float x, float y) {
        this.x = x;
        this.y = y;
    }
}
