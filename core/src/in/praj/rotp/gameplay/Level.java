package in.praj.rotp.gameplay;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.ArrayList;
import java.util.List;

import in.praj.rotp.core.Assets;
import in.praj.rotp.gameplay.components.MovementInputComponent;
import in.praj.rotp.gameplay.components.PositionComponent;
import in.praj.rotp.gameplay.components.TextureComponent;
import in.praj.rotp.gameplay.components.VelocityComponent;
import in.praj.rotp.gameplay.systems.BulletSystem;
import in.praj.rotp.gameplay.systems.MobSystem;
import in.praj.rotp.gameplay.systems.MovementInputSystem;
import in.praj.rotp.gameplay.systems.MovementSystem;
import in.praj.rotp.gameplay.systems.RenderingSystem;

final class Level {
    private final Assets assets;
    private final PooledEngine engine;

    // Entities
    private final Entity player;

    // Systems
    private final MovementInputSystem movementInput;
    private final BulletSystem bulletSystem;
    private final MobSystem mobSystem;
    private final List<EntitySystem> systems;

    Level(Assets assets, SpriteBatch batch, Viewport viewport) {
        this.assets = assets;
        engine = new PooledEngine();

        // Entities
        player = engine.createEntity();

        // Systems
        movementInput = new MovementInputSystem(player);
        bulletSystem = new BulletSystem(assets.getBulletTexture(), player);
        mobSystem = new MobSystem(assets.getVirusTexture(), viewport);

        systems = new ArrayList<>(3);
        systems.add(movementInput);
        systems.add(bulletSystem);
        systems.add(mobSystem);
        systems.add(new MovementSystem());
        systems.add(new RenderingSystem(batch, viewport));
    }

    void start() {
        // Systems
        for (EntitySystem s : systems)
            engine.addSystem(s);

        // Player components
        final TextureComponent tc = engine.createComponent(TextureComponent.class);
        tc.region = assets.getPlayerTexture();
        player.add(tc);

        final PositionComponent pc = engine.createComponent(PositionComponent.class);
        pc.y = 50;
        player.add(pc);
        player.add(engine.createComponent(VelocityComponent.class));

        final MovementInputComponent mic = engine.createComponent(MovementInputComponent.class);
        mic.xSpeed = 200;
        player.add(mic);

        engine.addEntity(player);
    }

    void leftButtonDown() {
        movementInput.setMoveLeft(true);
    }

    void leftButtonUp() {
        movementInput.setMoveLeft(false);
    }

    void rightButtonDown() {
        movementInput.setMoveRight(true);
    }

    void rightButtonUp() {
        movementInput.setMoveRight(false);
    }

    void update(float delta) {
        engine.update(delta);
    }

    void stop() {
        for (EntitySystem s : systems)
            engine.removeSystem(s);
        engine.removeAllEntities();
        engine.clearPools();
    }
}
