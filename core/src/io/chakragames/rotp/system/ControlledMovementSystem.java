package io.chakragames.rotp.system;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;

import io.chakragames.rotp.components.ControlledMovementComponent;
import io.chakragames.rotp.components.PositionComponent;
import io.chakragames.rotp.components.VelocityComponent;

public final class ControlledMovementSystem extends EntitySystem {
    private boolean leftMovement;
    private boolean rightMovement;

    private final Family family;
    private final ComponentMapper<PositionComponent> pcm;
    private final ComponentMapper<VelocityComponent> vcm;
    private final ComponentMapper<ControlledMovementComponent> cmcm;

    private Engine engine;

    public ControlledMovementSystem() {
        family = Family.all(PositionComponent.class, ControlledMovementComponent.class).get();
        pcm = ComponentMapper.getFor(PositionComponent.class);
        vcm = ComponentMapper.getFor(VelocityComponent.class);
        cmcm = ComponentMapper.getFor(ControlledMovementComponent.class);
    }

    public void setLeftMovement(boolean leftMovement) {
        this.leftMovement = leftMovement;
    }

    public void setRightMovement(boolean rightMovement) {
        this.rightMovement = rightMovement;
    }

    @Override
    public void addedToEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void update(float deltaTime) {
        for (Entity entity : engine.getEntitiesFor(family)) {
            PositionComponent pc = pcm.get(entity);
            VelocityComponent vc = vcm.get(entity);
            float speed = cmcm.get(entity).speed;

            // Update velocity
            vc.x = (leftMovement ? -speed : 0) + (rightMovement ? speed : 0);

            // Update position
            pc.x += vc.x * deltaTime;
        }
    }
}
