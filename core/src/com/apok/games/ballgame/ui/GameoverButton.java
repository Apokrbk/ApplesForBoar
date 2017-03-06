package com.apok.games.ballgame.ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;

/**
 * Created by Apok on 06.03.2017.
 */

public class GameoverButton  extends ImageButton {

    public GameoverButton(final IClickCallback callback) {
        super(new SpriteDrawable(new Sprite(new Texture("gameover.png"))));
        init(callback);
    }

    private void init(final IClickCallback callback) {
        this.setWidth(350);
        this.setHeight(150);
        this.setX(40);
        this.setY(270);
        this.addListener(new ClickListener()
        {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                callback.onClick();
                return super.touchDown(event, x, y, pointer, button);
            }
        });
    }
}