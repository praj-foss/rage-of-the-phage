package in.praj.rotp.gameplay.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.Viewport;

import in.praj.rotp.gameplay.components.PositionComponent;
import in.praj.rotp.gameplay.components.TextureComponent;

public final class RenderingSystem extends EntitySystem {
    private final SpriteBatch batch;
    private final Viewport viewport;
    private final Family family;
    private final ComponentMapper<TextureComponent> tcm;
    private final ComponentMapper<PositionComponent> pcm;
    private Engine engine;

    public RenderingSystem(SpriteBatch batch, Viewport viewport) {
        super(10);
        this.batch = batch;
        this.viewport = viewport;
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
        for (Entity e : engine.getEntitiesFor(family)) {
            PositionComponent pc = pcm.get(e);

            if (pc.y >= 0 && pc.y <= viewport.getWorldHeight()) {
                batch.begin();
                batch.draw(tcm.get(e).region, pc.x, pc.y);
                batch.end();
            } else {
                // Out of bounds
                engine.removeEntity(e);
            }
        }
    }
}
