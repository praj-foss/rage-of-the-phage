package io.chakragames.rotp.models;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import io.chakragames.rotp.Assets;

public class Player {
    private final Texture texture;
    private final float speed;
    private final Vector2 position;
    private final Vector2 velocity;

    public Player(Assets assets) {
        texture = assets.getPhageTexture();
        speed = 200;
        position = new Vector2(0, 0);
        velocity = new Vector2(0, 0);
    }

    public void moveRight() {
        velocity.x += speed;
    }

    public void moveLeft() {
        velocity.x -= speed;
    }

    public void stopRight() {
        moveLeft();
    }

    public void stopLeft() {
        moveRight();
    }

    public void update(float delta) {
        position.add(velocity.cpy().scl(delta));
    }

    public Texture getTexture() {
        return texture;
    }

    public float getX() {
        return position.x;
    }

    public float getY() {
        return position.y;
    }
}
