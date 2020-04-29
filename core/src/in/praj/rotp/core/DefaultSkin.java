package in.praj.rotp.core;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.DistanceFieldFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

final class DefaultSkin extends Skin {
    private static final String DEFAULT = "default";
    private static final String COLOR_LIGHT_0 = "light-0";
    private static final String COLOR_DARK_1  = "dark-1";

    DefaultSkin(TextureAtlas atlas, BitmapFont font) {
        super(atlas);

        setupFonts(font);
        setupColors();
        setupButtonStyles();
    }

    private void setupFonts(BitmapFont font) {
        final DistanceFieldFont dff =
                new DistanceFieldFont(font.getData(), font.getRegion(), false);
        dff.setDistanceFieldSmoothing(4f);
        add(DEFAULT, dff, BitmapFont.class);
    }

    private void setupColors() {
        add(COLOR_LIGHT_0, new Color(
                0.9647059f, 0.85882354f, 0.7294118f, 1f
        ));
        add(COLOR_DARK_1, new Color(
                0.1921569f, 0.4862745f, 0.5294118f, 1f
        ));
    }

    private void setupButtonStyles() {
        // for Button
        final Button.ButtonStyle btn = new Button.ButtonStyle();
        btn.up = fromPatch("button-up");
        btn.down = fromPatch("button-down");
        btn.disabled = btn.up;
        add(DEFAULT, btn);

        // for ImageButtons
        final ImageButton.ImageButtonStyle imgBtn = new ImageButton.ImageButtonStyle(btn);
        imgBtn.imageDisabled = fromRegion("buff-disabled");
        add(DEFAULT, imgBtn);

        // for TextButtons
        final TextButton.TextButtonStyle textBtn = new TextButton.TextButtonStyle();
        textBtn.up = btn.up;
        textBtn.down = btn.down;
        textBtn.disabled = btn.disabled;
        textBtn.font = getFont(DEFAULT);
        textBtn.fontColor = getColor(COLOR_LIGHT_0);
        add(DEFAULT, textBtn);
    }

    private Drawable fromPatch(String name) {
        return new NinePatchDrawable(getPatch(name));
    }

    private Drawable fromRegion(String name) {
        return new TextureRegionDrawable(getRegion(name));
    }
}
