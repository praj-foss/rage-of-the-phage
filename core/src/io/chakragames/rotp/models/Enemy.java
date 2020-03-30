package io.chakragames.rotp.models;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import io.chakragames.rotp.Assets;

public class Enemy {
    private final TextureRegion texture;
    private final float speed;
    private final Vector2 position;
    private final Vector2 direction;
    private final Vector2 velocity;

    private final float worldHeight;
    private boolean withinBounds;
    private float time;

    public Enemy(Assets assets, float worldWidth, float worldHeight) {
        texture = assets.getVirusTexture();
        speed = 100;
        position = new Vector2((worldWidth - texture.getRegionWidth()) / 2, 0);
        direction = new Vector2(0, 1);
        velocity = new Vector2(0, 0);

        this.worldHeight = worldHeight;
        withinBounds = true;
    }

    public void update(float delta) {
        if (withinBounds) {
            position.add(updateVelocity(delta));
            if (position.y >= worldHeight)
                withinBounds = false;
        }
    }

    private Vector2 updateVelocity(float delta) {
        float amp = 5;
        float omega = 8;
        time += delta;
        float valX = (float) Math.cos(time * omega) * amp;
        float valY = (float) Math.sin(time * omega) * amp;
        direction.set(valX, valY).add(Vector2.Y);

        return velocity.set(direction).scl(delta * speed);
    }

    public boolean isWithinBounds() {
        return withinBounds;
    }

    public TextureRegion getTexture() {
        return texture;
    }

    public float getX() {
        return position.x;
    }

    public float getY() {
        return position.y;
    }
}
