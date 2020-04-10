package in.praj.rotp.gameplay.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;

import in.praj.rotp.gameplay.components.MovementInputComponent;
import in.praj.rotp.gameplay.components.VelocityComponent;

public final class MovementInputSystem extends EntitySystem {
    private final Entity player;
    private final ComponentMapper<VelocityComponent> vcm;
    private final ComponentMapper<MovementInputComponent> micm;

    private boolean moveLeft;
    private boolean moveRight;

    public MovementInputSystem(Entity player) {
        this.player = player;
        vcm = ComponentMapper.getFor(VelocityComponent.class);
        micm = ComponentMapper.getFor(MovementInputComponent.class);

        moveLeft = false;
        moveRight = false;
    }

    @Override
    public void update(float deltaTime) {
        float speed = micm.get(player).xSpeed;
        vcm.get(player).x = (moveLeft ? -speed : 0f) + (moveRight ? speed : 0f);
    }

    public void setMoveLeft(boolean moveLeft) {
        this.moveLeft = moveLeft;
    }

    public void setMoveRight(boolean moveRight) {
        this.moveRight = moveRight;
    }
}
