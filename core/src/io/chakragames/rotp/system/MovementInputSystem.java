package io.chakragames.rotp.system;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import io.chakragames.rotp.Assets;
import io.chakragames.rotp.components.TextureComponent;
import io.chakragames.rotp.components.VelocityComponent;
import io.chakragames.rotp.components.VelocityInputComponent;

public final class MovementInputSystem extends EntitySystem {
    private boolean leftMovement;
    private boolean rightMovement;
    private final TextureRegion textureIdle;
    private final Animation<TextureRegion> animRight;
    private final Animation<TextureRegion> animLeft;
    private float rTimer;
    private float lTimer;

    private final Family family;
    private final ComponentMapper<VelocityInputComponent> vicm;
    private final ComponentMapper<VelocityComponent> vcm;
    private final ComponentMapper<TextureComponent> tcm;

    private Engine engine;

    public MovementInputSystem(Assets assets) {
        textureIdle = assets.getPhageTexture();
        animRight = assets.getPhageMoveRightAnimation();
        animLeft = assets.getPhageMoveLeftAnimation();

        family = Family.all(VelocityComponent.class,
                VelocityInputComponent.class, TextureComponent.class).get();
        vicm = ComponentMapper.getFor(VelocityInputComponent.class);
        vcm = ComponentMapper.getFor(VelocityComponent.class);
        tcm = ComponentMapper.getFor(TextureComponent.class);
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

            TextureComponent tc = tcm.get(entity);
            if (vc.x > 0) {
                lTimer = 0;
                rTimer += deltaTime;
                tc.region = animRight.getKeyFrame(rTimer, true);
            }
            else if (vc.x < 0) {
                rTimer = 0;
                lTimer += deltaTime;
                tc.region = animLeft.getKeyFrame(lTimer, true);
            } else {
                rTimer = 0;
                lTimer = 0;
                tc.region = textureIdle;
            }
        }
    }
}
