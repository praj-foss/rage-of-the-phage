package in.praj.rotp.gameplay.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;

import in.praj.rotp.gameplay.components.AnimationComponent;
import in.praj.rotp.gameplay.components.TextureComponent;

public final class AnimationSystem extends EntitySystem {
    private final Family family;
    private final ComponentMapper<AnimationComponent> acm;
    private final ComponentMapper<TextureComponent> tcm;
    private Engine engine;

    public AnimationSystem() {
        super(8);
        family = Family.all(AnimationComponent.class, TextureComponent.class).get();
        acm = ComponentMapper.getFor(AnimationComponent.class);
        tcm = ComponentMapper.getFor(TextureComponent.class);
    }

    @Override
    public void addedToEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void update(float deltaTime) {
        for (Entity entity : engine.getEntitiesFor(family)) {
            AnimationComponent ac = acm.get(entity);
            TextureComponent tc = tcm.get(entity);

            ac.time += deltaTime;
            tc.region = ac.animation.getKeyFrame(ac.time, true);
        }
    }
}
