package io.chakragames.rotp.gameplay;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;

import io.chakragames.rotp.Assets;
import io.chakragames.rotp.models.Player;

public class GameWorld {
    private final Player player;

    public GameWorld(Assets assets) {
        player = new Player(assets);
    }

    public void update(float delta) {
        player.update(delta);
    }

    Player getPlayer() {
        return player;
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

    public InputProcessor getInputProcessor() {
        return inputProcessor;
    }
}
