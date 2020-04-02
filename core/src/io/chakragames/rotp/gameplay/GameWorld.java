package io.chakragames.rotp.gameplay;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;

import io.chakragames.rotp.Assets;
import io.chakragames.rotp.entities.PlayerEntity;
import io.chakragames.rotp.system.ControlledMovementSystem;
import io.chakragames.rotp.system.RenderingSystem;

public class GameWorld {
    private final float width;
    private final float height;
    private final Engine engine;
    private final ControlledMovementSystem movementSystem;

    public GameWorld(Assets assets) {
        width = 360;
        height = 640;

        movementSystem = new ControlledMovementSystem();

        engine = new Engine();
        engine.addSystem(movementSystem);
        engine.addSystem(new RenderingSystem(this));
        engine.addEntity(new PlayerEntity(assets, width, height));
    }

    public void update(float delta) {
        engine.update(delta);
    }

    private final InputProcessor inputProcessor = new InputAdapter() {
        @Override
        public boolean keyDown(int keycode) {
            switch (keycode) {
                case Input.Keys.RIGHT:
                    movementSystem.setRightMovement(true);
                    break;
                case Input.Keys.LEFT:
                    movementSystem.setLeftMovement(true);
                    break;
            }
            return true;
        }

        @Override
        public boolean keyUp(int keycode) {
            switch (keycode) {
                case Input.Keys.RIGHT:
                    movementSystem.setRightMovement(false);
                    break;
                case Input.Keys.LEFT:
                    movementSystem.setLeftMovement(false);
                    break;
            }
            return true;
        }
    };

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
