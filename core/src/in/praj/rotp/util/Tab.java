package in.praj.rotp.util;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public final class Tab {
    private final Skin skin;
    private final Button head;
    private final Actor body;

    private Tab(Builder builder) {
        skin = builder.skin;
        head = builder.head;
        body = builder.body;
    }

    public Skin getSkin() {
        return skin;
    }

    public Button getHead() {
        return head;
    }

    public Actor getBody() {
        return body;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private Skin skin;
        private Button head;
        private Actor body;

        private Builder() { }

        public Builder skin(Skin skin) {
            this.skin = skin;
            return this;
        }

        public Builder head(TextureRegion region) {
            final ImageButton btn = new ImageButton(skin);
            btn.getStyle().imageUp = new TextureRegionDrawable(region);
            head = btn;
            return this;
        }

        public Builder head(String text) {
            head = new TextButton(text, skin);
            return this;
        }

        public Builder body(Actor body) {
            this.body = body;
            return this;
        }

        public Tab build() {
            return new Tab(this);
        }
    }
}
