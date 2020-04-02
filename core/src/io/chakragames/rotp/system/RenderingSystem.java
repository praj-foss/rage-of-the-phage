package io.chakragames.rotp.system;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import io.chakragames.rotp.components.PositionComponent;
import io.chakragames.rotp.components.TextureComponent;
import io.chakragames.rotp.gameplay.GameWorld;

public final class RenderingSystem extends EntitySystem {
    private final OrthographicCamera cam;
    private final SpriteBatch batch;

    private final Family family;
    private final ComponentMapper<TextureComponent> tcm;
    private final ComponentMapper<PositionComponent> pcm;
    private Engine engine;

    public RenderingSystem(GameWorld world) {
        super(10);
        cam = new OrthographicCamera();
        cam.setToOrtho(false, world.getWidth(), world.getHeight());
        batch = new SpriteBatch();
        batch.setProjectionMatrix(cam.combined);

        family = Family.all(TextureComponent.class, PositionComponent.class).get();
        tcm = ComponentMapper.getFor(TextureComponent.class);
        pcm = ComponentMapper.getFor(PositionComponent.class);
    }

    @Override
    public void addedToEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void update(float deltaTime) {
        batch.begin();
        for (Entity entity : engine.getEntitiesFor(family)) {
            TextureComponent tc = tcm.get(entity);
            PositionComponent pc = pcm.get(entity);
            batch.draw(tc.region, pc.x, pc.y);
        }
        batch.end();
    }
}
