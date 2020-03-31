package io.chakragames.rotp.gameplay;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

import io.chakragames.rotp.Assets;

public class StatusDisplay {
    private final Stage stage;
    private final GameWorld world;

    public StatusDisplay(Assets assets, GameWorld world) {
        stage = new Stage();
        this.world = world;
        initialize(assets);
    }

    private void initialize(Assets assets) {
        final Table table = new Table(assets.getSkin());
        table.setFillParent(true);
        table.top();

        // Upper UI
        table.add("H").colspan(2);
        table.add("W").expandX();
        table.add("S").colspan(2);
        table.row();

        // Middle space
        table.add().colspan(5).expandY();
        table.row();

        // Lower UI
        table.add("L").size(30);
        table.add("R").size(30);
        table.add().expandX();
        table.add("F").size(30);
        table.add("M").size(30);

        stage.addActor(table);
        stage.setDebugAll(true);
    }

    public void update(float delta) {
        stage.act(delta);
    }

    public void render() {
        stage.draw();
    }

    public InputProcessor getInputProcessor() {
        return stage;
    }
}
