package io.chakragames.rotp.gameplay;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import io.chakragames.rotp.models.Enemy;
import io.chakragames.rotp.models.Player;

public class GameRenderer {

    private final GameWorld world;
    private final OrthographicCamera cam;
    private final SpriteBatch batch;

    public GameRenderer(GameWorld world) {
        this.world = world;
        cam = new OrthographicCamera();
        cam.setToOrtho(true, world.getWidth(), world.getHeight());
        batch = new SpriteBatch();
        batch.setProjectionMatrix(cam.combined);
    }

    public void render() {
        batch.begin();
        // Draw enemy
        final Enemy e = world.getEnemy();
        if (e.isWithinBounds()) batch.draw(e.getTexture(), e.getX(), e.getY());

        // Draw player
        final Player p = world.getPlayer();
        batch.draw(p.getTexture(), p.getX(), p.getY());
        batch.end();
    }
}
