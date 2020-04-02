package io.chakragames.rotp.components;

import com.badlogic.ashley.core.Component;

/**
 * Notifies that {@link PositionComponent} of the entity can
 * be modified by keyboard or touch input.
 */
public final class ControlledMovementComponent implements Component {
    public float speed;

    public ControlledMovementComponent(float speed) {
        this.speed = speed;
    }
}
