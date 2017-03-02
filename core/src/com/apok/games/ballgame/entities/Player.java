package com.apok.games.ballgame.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * Created by Apok on 02.03.2017.
 */

public class Player extends Image {
    private static final int WIDTH = 50;
    private static final int HEIGHT = 50;

    private static final int STARTING_X = 200;
    private static final int STARTING_Y = 50;

    public Player()
    {
        super(new Texture("player.png"));
        this.setOrigin(WIDTH/2, HEIGHT/2);
        this.setSize(WIDTH,HEIGHT);
        this.setPosition(STARTING_X, STARTING_Y);
    }

    public float countAngleToInput(Vector3 input) {
        float x = input.x - getX();
        float y = input.y - getY();
        double angle = MathUtils.atan2(y,x) * 180.0d / Math.PI;
        return (float)angle;
    }
}
