package io.chakragames.rotp.models;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import io.chakragames.rotp.Assets;

public class Player {
    private final TextureRegion texture;
    private final float speed;
    private final Vector2 position;
    private final Vector2 direction;
    private final Vector2 velocity;

    public Player(Assets assets, float worldWidth, float worldHeight) {
        texture = assets.getPhageTexture();
        texture.flip(false, true);

        speed = 300;
        position = new Vector2(0, worldHeight - texture.getRegionHeight());
        direction = new Vector2(0, 0);
        velocity = new Vector2(0, 0);
    }

    public void moveRight() {
        direction.x++;
    }

    public void moveLeft() {
        direction.x--;
    }

    public void stopRight() {
        moveLeft();
    }

    public void stopLeft() {
        moveRight();
    }

    public void update(float delta) {
        velocity.set(direction).scl(delta * speed);
        position.add(velocity);
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
