package in.praj.rotp.gameplay.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import in.praj.rotp.gameplay.components.PositionComponent;
import in.praj.rotp.gameplay.components.TextureComponent;
import in.praj.rotp.gameplay.components.VelocityComponent;

public final class BulletSystem extends EntitySystem {
    private final TextureRegion region;
    private final Entity player;
    private final ComponentMapper<PositionComponent> pcm;
    private PooledEngine engine;

    private float spawnInterval;
    private float timePast;
    private float speed;

    public BulletSystem(TextureRegion region, Entity player) {
        this.region = region;
        this.player = player;
        pcm = ComponentMapper.getFor(PositionComponent.class);

        spawnInterval = 0.4f;
        timePast = 0f;
        speed = 900f;
    }

    @Override
    public void addedToEngine(Engine engine) {
        this.engine = (PooledEngine) engine;
    }

    @Override
    public void update(float deltaTime) {
        timePast += deltaTime;
        if (timePast >= spawnInterval) {
            PositionComponent playerPc = pcm.get(player);
            spawnBullet(playerPc.x + 20, playerPc.y + 70);
            timePast = 0f;
        }
    }

    private void spawnBullet(float x, float y) {
        final Entity bullet = engine.createEntity();

        final TextureComponent tc = engine.createComponent(TextureComponent.class);
        tc.region = region;
        bullet.add(tc);

        final PositionComponent pc = engine.createComponent(PositionComponent.class);
        pc.x = x;
        pc.y = y;
        bullet.add(pc);

        final VelocityComponent vc = engine.createComponent(VelocityComponent.class);
        vc.y = speed;
        bullet.add(vc);

        engine.addEntity(bullet);
    }
}
