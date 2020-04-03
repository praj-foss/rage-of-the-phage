package io.chakragames.rotp.system;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;

import io.chakragames.rotp.components.PositionComponent;
import io.chakragames.rotp.components.VelocityComponent;

public final class MovementSystem extends EntitySystem {
    private final Family family;
    private final ComponentMapper<VelocityComponent> vcm;
    private final ComponentMapper<PositionComponent> pcm;
    private Engine engine;

    public MovementSystem() {
        super(7);
        family = Family.all(VelocityComponent.class, PositionComponent.class).get();
        vcm = ComponentMapper.getFor(VelocityComponent.class);
        pcm = ComponentMapper.getFor(PositionComponent.class);
    }

    @Override
    public void addedToEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void update(float deltaTime) {
        for (Entity entity : engine.getEntitiesFor(family)) {
            VelocityComponent vc = vcm.get(entity);
            PositionComponent pc = pcm.get(entity);
            pc.x += vc.x * deltaTime;
            pc.y += vc.y * deltaTime;
        }
    }
}
