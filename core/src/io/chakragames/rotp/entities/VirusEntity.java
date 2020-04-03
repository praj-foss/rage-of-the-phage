package io.chakragames.rotp.entities;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import io.chakragames.rotp.Assets;
import io.chakragames.rotp.components.PositionComponent;
import io.chakragames.rotp.components.TextureComponent;
import io.chakragames.rotp.components.VelocityComponent;

public final class VirusEntity extends Entity {
    public VirusEntity(Assets assets, float worldWidth, float worldHeight) {
        TextureRegion region = assets.getVirusTexture();

        add(new TextureComponent(region));
        add(new PositionComponent((worldWidth - region.getRegionWidth()) / 2, worldHeight));
        add(new VelocityComponent(0, -100));
    }
}
