package in.praj.rotp.util;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import java.util.ArrayList;
import java.util.List;

public final class TabPane {
    private final Skin skin;
    private final List<Tab> tabs;
    private final ScrollPane content;

    private TabPane(Builder builder) {
        skin = builder.skin;
        tabs = builder.tabs;
        content = new ScrollPane(null, skin);
        for (Tab tab: tabs) {
            tab.getHead().addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    content.setActor(tab.getBody());
                }
            });
        }
    }

    public void on(Table table) {
        for (Tab tab : tabs)
            table.add(tab.getHead()).fillX();
        table.row();
        table.add(content).colspan(tabs.size()).expandY().fill();
        content.setActor(tabs.get(0).getBody());
    }

    public Skin getSkin() {
        return skin;
    }

    public List<Tab> getTabs() {
        return tabs;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private Skin skin;
        private List<Tab> tabs;

        private Builder() {
            tabs = new ArrayList<>();
        }

        public Builder skin(Skin skin) {
            this.skin = skin;
            return this;
        }

        public Builder tab(Tab tab) {
            tabs.add(tab);
            return this;
        }

        public TabPane build() {
            return new TabPane(this);
        }
    }
}
