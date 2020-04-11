package in.praj.rotp.gameplay.systems;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.Random;

import in.praj.rotp.gameplay.components.PositionComponent;
import in.praj.rotp.gameplay.components.TextureComponent;
import in.praj.rotp.gameplay.components.VelocityComponent;

public final class MobSystem extends EntitySystem {
    private final TextureRegion region;
    private PooledEngine engine;

    private float xBound;
    private float yBound;
    private float spawnInterval;
    private float timePast;
    private float baseSpeed;
    private final Random random;

    public MobSystem(TextureRegion region, Viewport viewport) {
        super(0);
        this.region = region;

        xBound = viewport.getWorldWidth();
        yBound = viewport.getWorldHeight();
        spawnInterval = 1.5f;
        timePast = 0f;
        baseSpeed = 100f;
        random = new Random();
    }

    @Override
    public void addedToEngine(Engine engine) {
        this.engine = (PooledEngine) engine;
    }

    @Override
    public void update(float deltaTime) {
        timePast += deltaTime;
        if (timePast >= spawnInterval) {
            float x = random.nextFloat() * (xBound - region.getRegionWidth() + 1);
            float y = yBound;
            float speed = baseSpeed + random.nextInt(100);

            engine.addEntity(spawn(x, y, speed));
            timePast = 0f;
        }
    }

    private Entity spawn(float x, float y, float speed) {
        final Entity mob = engine.createEntity();

        final TextureComponent tc = engine.createComponent(TextureComponent.class);
        tc.region = region;
        mob.add(tc);

        final PositionComponent pc = engine.createComponent(PositionComponent.class);
        pc.x = x;
        pc.y = y;
        mob.add(pc);

        final VelocityComponent vc = engine.createComponent(VelocityComponent.class);
        vc.y = -speed;
        mob.add(vc);

        return mob;
    }
}
