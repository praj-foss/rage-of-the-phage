package in.praj.rotp.gameplay.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.PooledEngine;

import in.praj.rotp.core.Assets;
import in.praj.rotp.gameplay.components.AnimationComponent;
import in.praj.rotp.gameplay.components.MovementInputComponent;
import in.praj.rotp.gameplay.components.VelocityComponent;

public final class MovementInputSystem extends EntitySystem {
    private final Assets assets;
    private final Entity player;
    private final ComponentMapper<VelocityComponent> vcm;
    private final ComponentMapper<MovementInputComponent> micm;
    private final ComponentMapper<AnimationComponent> acm;
    private PooledEngine engine;

    private boolean moveLeft;
    private boolean moveRight;

    public MovementInputSystem(Entity player, Assets assets) {
        super(1);
        this.player = player;
        this.assets = assets;
        vcm = ComponentMapper.getFor(VelocityComponent.class);
        micm = ComponentMapper.getFor(MovementInputComponent.class);
        acm = ComponentMapper.getFor(AnimationComponent.class);

        moveLeft = false;
        moveRight = false;
    }

    @Override
    public void addedToEngine(Engine engine) {
        this.engine = (PooledEngine) engine;
    }

    @Override
    public void update(float deltaTime) {
        float speed = micm.get(player).xSpeed;
        float v = (moveLeft ? -speed : 0f) + (moveRight ? speed : 0f);
        vcm.get(player).x = v;

        if (v > 0) {
            if (!acm.has(player)) {
                AnimationComponent ac = engine.createComponent(AnimationComponent.class);
                ac.animation = assets.getPlayerRunRightAnimation();
                player.add(ac);
            }
        } else if (v < 0) {
            if (!acm.has(player)) {
                AnimationComponent ac = engine.createComponent(AnimationComponent.class);
                ac.animation = assets.getPlayerRunLeftAnimation();
                player.add(ac);
            }
        }
        else {
            if (acm.has(player))
                player.remove(AnimationComponent.class);
        }

    }

    public void setMoveLeft(boolean moveLeft) {
        this.moveLeft = moveLeft;
    }

    public void setMoveRight(boolean moveRight) {
        this.moveRight = moveRight;
    }
}
