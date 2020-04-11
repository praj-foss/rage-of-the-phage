package in.praj.rotp.gameplay.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;

import in.praj.rotp.gameplay.components.PositionComponent;
import in.praj.rotp.gameplay.components.VelocityComponent;

public final class MovementSystem extends EntitySystem {
    private final Family family;
    private final ComponentMapper<PositionComponent> pcm;
    private final ComponentMapper<VelocityComponent> vcm;
    private Engine engine;

    public MovementSystem() {
        super(2);
        family = Family.all(PositionComponent.class, VelocityComponent.class).get();
        pcm = ComponentMapper.getFor(PositionComponent.class);
        vcm = ComponentMapper.getFor(VelocityComponent.class);
    }

    @Override
    public void addedToEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void update(float deltaTime) {
        for (Entity e : engine.getEntitiesFor(family)) {
            PositionComponent pc = pcm.get(e);
            VelocityComponent vc = vcm.get(e);

            pc.x += vc.x * deltaTime;
            pc.y += vc.y * deltaTime;
        }
    }
}
