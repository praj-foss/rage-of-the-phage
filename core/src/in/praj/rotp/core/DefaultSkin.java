package in.praj.rotp.core;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.DistanceFieldFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public final class DefaultSkin extends Skin {
    public static final String STYLE_DEFAULT = "default";
    public static final String STYLE_TABS    = "tabs";

    public static final String COLOR_LIGHT_0 = "light-0";
    public static final String COLOR_DARK_1  = "dark-1";

    DefaultSkin(TextureAtlas atlas, BitmapFont font, BitmapFont sub) {
        super(atlas);

        setupFonts(font, sub);
        setupColors();
        setupButtons();
        setupTabs();
        setupLabels();
    }

    private void setupFonts(BitmapFont font, BitmapFont s) {
        final DistanceFieldFont dff =
                new DistanceFieldFont(font.getData(), font.getRegion(), false);
        dff.setDistanceFieldSmoothing(4f);
        add(STYLE_DEFAULT, dff, BitmapFont.class);
        add(STYLE_TABS, s);
    }

    private void setupColors() {
        add(COLOR_LIGHT_0, new Color(
                0.9647059f, 0.85882354f, 0.7294118f, 1f
        ));
        add(COLOR_DARK_1, new Color(
                0.1921569f, 0.4862745f, 0.5294118f, 1f
        ));
    }

    private void setupButtons() {
        // for Button
        final Button.ButtonStyle btn = new Button.ButtonStyle();
        btn.up = fromPatch("button-up");
        btn.down = fromPatch("button-down");
        btn.disabled = btn.up;
        add(STYLE_DEFAULT, btn);

        // for ImageButtons
        final ImageButton.ImageButtonStyle imgBtn = new ImageButton.ImageButtonStyle(btn);
        imgBtn.imageDisabled = fromRegion("buff-disabled");
        add(STYLE_DEFAULT, imgBtn);

        // for TextButtons
        final TextButton.TextButtonStyle textBtn = new TextButton.TextButtonStyle();
        textBtn.up = btn.up;
        textBtn.down = btn.down;
        textBtn.disabled = btn.disabled;
        textBtn.font = getFont(STYLE_DEFAULT);
        textBtn.fontColor = getColor(COLOR_LIGHT_0);
        add(STYLE_DEFAULT, textBtn);
    }

    private void setupTabs() {
        final Button.ButtonStyle tab = new Button.ButtonStyle();
        tab.up = fromPatch("tab-inactive");
        tab.checked = fromPatch("tab-active");
        add(STYLE_TABS, tab);

        final TextButton.TextButtonStyle textTab = new TextButton.TextButtonStyle();
        textTab.up = tab.up;
        textTab.checked = tab.checked;
        textTab.font = getFont(STYLE_TABS);
        textTab.fontColor = getColor(COLOR_LIGHT_0);
        add(STYLE_TABS, textTab);

        final ScrollPane.ScrollPaneStyle content = new ScrollPane.ScrollPaneStyle();
        content.background = fromPatch("tab-content");
        add(STYLE_TABS, content);
    }

    private void setupLabels() {
        final Label.LabelStyle label = new Label.LabelStyle();
        label.font = getFont(STYLE_TABS);
        label.fontColor = getColor(COLOR_LIGHT_0);
        add(STYLE_DEFAULT, label);
    }

    private Drawable fromPatch(String name) {
        return new NinePatchDrawable(getPatch(name));
    }

    private Drawable fromRegion(String name) {
        return new TextureRegionDrawable(getRegion(name));
    }
}
