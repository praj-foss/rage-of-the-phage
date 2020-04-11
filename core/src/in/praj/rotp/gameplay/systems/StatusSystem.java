package in.praj.rotp.gameplay.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;

import java.util.Locale;

import in.praj.rotp.gameplay.Level;
import in.praj.rotp.gameplay.components.HealthComponent;

public final class StatusSystem extends EntitySystem {
    private final Level level;
    private final Entity player;
    private final ComponentMapper<HealthComponent> hcm;

    private int hh;
    private int mm;
    private float ss;
    private int health;

    public StatusSystem(Level level, Entity player) {
        super(10);
        this.level = level;
        this.player = player;
        hcm = ComponentMapper.getFor(HealthComponent.class);
    }

    @Override
    public void update(float deltaTime) {
        ss += deltaTime;

        if (ss >= 60) {
            ss -= 60;
            mm += 1;
        }

        if (mm >= 60) {
            mm -= 60;
            hh += 1;
        }

        level.updateScore(String.format(Locale.US,"%02d:%02d:%04.1f", hh, mm, ss));

        int currentHealth = hcm.get(player).value;
        if (health != currentHealth) {
            health = currentHealth;
            level.updateHealth(health);
        }
    }

    @Override
    public void removedFromEngine(Engine engine) {
        hh = 0;
        mm = 0;
        ss = 0;
        health = 0;
    }
}
