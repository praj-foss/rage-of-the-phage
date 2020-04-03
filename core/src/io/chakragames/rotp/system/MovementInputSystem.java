package io.chakragames.rotp.system;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;

import io.chakragames.rotp.components.VelocityComponent;
import io.chakragames.rotp.components.VelocityInputComponent;

public final class MovementInputSystem extends EntitySystem {
    private boolean leftMovement;
    private boolean rightMovement;

    private final Family family;
    private final ComponentMapper<VelocityInputComponent> vicm;
    private final ComponentMapper<VelocityComponent> vcm;

    private Engine engine;

    public MovementInputSystem() {
        family = Family.all(VelocityComponent.class, VelocityInputComponent.class).get();
        vicm = ComponentMapper.getFor(VelocityInputComponent.class);
        vcm = ComponentMapper.getFor(VelocityComponent.class);
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
            float speed = vicm.get(entity).xSpeed;
            VelocityComponent vc = vcm.get(entity);
            vc.x = (leftMovement ? -speed : 0) + (rightMovement ? speed : 0);
        }
    }
}
