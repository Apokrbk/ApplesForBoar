package com.apok.games.ballgame.ui;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

public class ScoreLabel extends Label {

    public ScoreLabel() {
        super("", prepareLabelStyle());
        init();
    }

    private void init() {
        this.setX(20);
        this.setY(30);
    }

    private static LabelStyle prepareLabelStyle() {
        LabelStyle labelStyle = new LabelStyle();
        BitmapFont font = new BitmapFont();
        font.getData().setScale(1.5f, 1.5f);
        labelStyle.font = font;
        return labelStyle;
    }
}
