package com.apok.games.ballgame.entities;

import com.apok.games.ballgame.BallGame;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * Created by Apok on 03.03.2017.
 */

public class Boar extends Image {
    public static final int WIDTH = 150;
    public static final int HEIGHT = 90;

    private static final int STARTING_X = 126;
    private static final int STARTING_Y = 544;
    private int velX = -2;

    public Boar()
    {
        super(new Texture("boar.png"));
        this.setOrigin(WIDTH/2, HEIGHT/2);
        this.setSize(WIDTH,HEIGHT);
        this.setPosition(STARTING_X, STARTING_Y);
    }

    public void update()
    {
        moveBy(velX, 0);
        if(getX() > BallGame.WIDTH - WIDTH || getX() < 0)
        {
            velX *= -1;
        }

    }
}
