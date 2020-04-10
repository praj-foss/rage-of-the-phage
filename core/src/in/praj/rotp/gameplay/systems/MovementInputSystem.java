package in.praj.rotp.gameplay.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntityListener;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;

import in.praj.rotp.gameplay.components.MovementInputComponent;
import in.praj.rotp.gameplay.components.VelocityComponent;

public final class MovementInputSystem extends EntitySystem {
    private final Family family;
    private final ComponentMapper<VelocityComponent> vcm;
    private final ComponentMapper<MovementInputComponent> micm;
    private Entity entity;

    private boolean moveLeft;
    private boolean moveRight;

    public MovementInputSystem() {
        family = Family.all(MovementInputComponent.class, VelocityComponent.class).get();
        vcm = ComponentMapper.getFor(VelocityComponent.class);
        micm = ComponentMapper.getFor(MovementInputComponent.class);

        moveLeft = false;
        moveRight = false;
    }

    @Override
    public void addedToEngine(Engine engine) {
        engine.addEntityListener(family, new EntityListener() {
            @Override
            public void entityAdded(Entity entity) {
                setEntity(entity);
            }

            @Override
            public void entityRemoved(Entity entity) {
            }
        });
    }

    @Override
    public void update(float deltaTime) {
        float speed = micm.get(entity).xSpeed;
        vcm.get(entity).x = (moveLeft ? -speed : 0f) + (moveRight ? speed : 0f);
    }

    private void setEntity(Entity entity) {
        this.entity = entity;
    }

    public void setMoveLeft(boolean moveLeft) {
        this.moveLeft = moveLeft;
    }

    public void setMoveRight(boolean moveRight) {
        this.moveRight = moveRight;
    }
}
