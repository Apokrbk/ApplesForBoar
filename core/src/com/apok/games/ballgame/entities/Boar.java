package com.apok.games.ballgame.entities;

import com.apok.games.ballgame.BallGame;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;

public class Boar extends Image {
    private static final int WIDTH = 150;
    private static final int HEIGHT = 90;

    private static final int STARTING_X = 126;
    private static final int STARTING_Y = 544;
    private int velX = -2;

    private Texture flippedBoar;
    private Texture boar;

    public Boar()
    {
        super(new Texture("boar.png"));
        boar = new Texture("boar.png");
        flippedBoar = new Texture("flippedboar.png");
        this.setOrigin(WIDTH/2, HEIGHT/2);
        this.setSize(WIDTH,HEIGHT);
        this.setPosition(STARTING_X, STARTING_Y);
    }

    public void update()
    {
        moveBy(velX, 0);
        changeDirectionIfBoarHitSide();
    }

    private void changeDirectionIfBoarHitSide() {
        if(getX() > BallGame.WIDTH - WIDTH || getX() < 0)
        {
            velX *= -1;
            flipTexture();
        }
    }

    private void flipTexture()
    {
        if(velX > 0)
            this.setDrawable(new SpriteDrawable(new Sprite(flippedBoar)));
        else
            this.setDrawable(new SpriteDrawable(new Sprite(boar)));
    }
}
