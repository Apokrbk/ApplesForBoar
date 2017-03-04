package com.apok.games.ballgame.ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;


public class PlayButton extends ImageButton {
    
    public PlayButton(final IClickCallback callback) {
        super(new SpriteDrawable(new Sprite(new Texture("playbutton.png"))));
        init(callback);
    }

    private void init(final IClickCallback callback) {
        this.setWidth(350);
        this.setHeight(200);
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
