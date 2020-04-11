package in.praj.rotp.gameplay.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;
import com.badlogic.gdx.math.Circle;

import in.praj.rotp.gameplay.components.HealthComponent;
import in.praj.rotp.gameplay.components.MovementInputComponent;
import in.praj.rotp.gameplay.components.PhysicsComponent;
import in.praj.rotp.gameplay.components.PositionComponent;

public final class PhysicsSystem extends EntitySystem {
    private final Family mobs;
    private final Family bullets;
    private final ComponentMapper<PhysicsComponent> phcm;
    private final ComponentMapper<PositionComponent> pcm;
    private Engine engine;

    public PhysicsSystem() {
        super(3);
        mobs = Family.all(PhysicsComponent.class, PositionComponent.class, HealthComponent.class)
                .exclude(MovementInputComponent.class).get();
        bullets = Family.all(PhysicsComponent.class, PositionComponent.class)
                .exclude(HealthComponent.class).get();

        phcm = ComponentMapper.getFor(PhysicsComponent.class);
        pcm = ComponentMapper.getFor(PositionComponent.class);
    }

    @Override
    public void addedToEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void update(float deltaTime) {
        for (Entity bullet : engine.getEntitiesFor(bullets)) {
            PositionComponent posB = pcm.get(bullet);
            Circle circleB = phcm.get(bullet).circle;

            for (Entity mob : engine.getEntitiesFor(mobs)) {
                PositionComponent posM = pcm.get(mob);
                Circle circleM = phcm.get(mob).circle;

                float d = posM.x - posB.x;
                if (d <= 2*circleB.radius && d >= -2*circleM.radius) {
                    float dx = (posM.x + circleM.x) - (posB.x + circleB.x);
                    float dy = (posM.y + circleM.y) - (posB.y + circleB.y);
                    float dr = circleM.radius + circleB.radius;

                    if (dx*dx + dy*dy < dr*dr) {
                        // Collision happened
                        engine.removeEntity(bullet);
                        engine.removeEntity(mob);
                    }
                }
            }
        }
    }
}
