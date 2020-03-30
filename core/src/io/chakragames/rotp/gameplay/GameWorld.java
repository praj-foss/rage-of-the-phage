package io.chakragames.rotp.gameplay;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;

import io.chakragames.rotp.Assets;
import io.chakragames.rotp.models.Enemy;
import io.chakragames.rotp.models.Player;

public class GameWorld {
    private final float width;
    private final float height;
    private final Player player;
    private final Enemy enemy;

    public GameWorld(Assets assets) {
        width = 360;
        height = 640;
        player = new Player(assets, width, height);
        enemy = new Enemy(assets, width, height);
    }

    public void update(float delta) {
        player.update(delta);
        enemy.update(delta);
    }

    private final InputProcessor inputProcessor = new InputAdapter() {
        @Override
        public boolean keyDown(int keycode) {
            switch (keycode) {
                case Input.Keys.RIGHT:
                    player.moveRight();
                    break;
                case Input.Keys.LEFT:
                    player.moveLeft();
                    break;
            }
            return true;
        }

        @Override
        public boolean keyUp(int keycode) {
            switch (keycode) {
                case Input.Keys.RIGHT:
                    player.stopRight();
                    break;
                case Input.Keys.LEFT:
                    player.stopLeft();
                    break;
            }
            return true;
        }
    };

    Player getPlayer() {
        return player;
    }

    Enemy getEnemy() {
        return enemy;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public InputProcessor getInputProcessor() {
        return inputProcessor;
    }
}
