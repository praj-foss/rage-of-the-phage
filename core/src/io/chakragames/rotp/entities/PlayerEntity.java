package io.chakragames.rotp.entities;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import io.chakragames.rotp.Assets;
import io.chakragames.rotp.components.ControlledMovementComponent;
import io.chakragames.rotp.components.PositionComponent;
import io.chakragames.rotp.components.TextureComponent;
import io.chakragames.rotp.components.VelocityComponent;

public final class PlayerEntity extends Entity {
    public PlayerEntity(Assets assets, float worldWidth, float worldHeight) {
        TextureRegion region = assets.getPhageTexture();

        add(new TextureComponent(region));
        add(new PositionComponent(0, 0));
        add(new VelocityComponent(0, 0));
        add(new ControlledMovementComponent(200));
    }
}
