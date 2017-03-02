package com.apok.games.ballgame.ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;


public class PlayButton extends ImageButton {
    
    public PlayButton(Texture background) {
        super(new SpriteDrawable(new Sprite(background)));
        init();
    }

    private void init() {
        this.setWidth(300);
        this.setHeight(114);
        this.setX(60);
        this.setY(370);
        this.addListener(new ClickListener()
        {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("hej");
                return super.touchDown(event, x, y, pointer, button);
            }
        });
    }
}
