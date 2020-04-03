package io.chakragames.rotp.components;

import com.badlogic.ashley.core.Component;

/**
 * Notifies that {@link PositionComponent} of the entity can
 * be modified by keyboard or touch input.
 */
public final class VelocityInputComponent implements Component {
    public float xSpeed;

    public VelocityInputComponent(float xSpeed) {
        this.xSpeed = xSpeed;
    }
}
