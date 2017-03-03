package com.apok.games.ballgame.entities;

import com.apok.games.ballgame.BallGame;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * Created by Apok on 03.03.2017.
 */

public class Ball extends Image {
    public static final int RADIUS = 10;
    public static final int WIDTH = 2*RADIUS;
    public static final int HEIGHT = 2*RADIUS;
    private static final int BASIC_VELOCITY = 8;

    private float velX;
    private float velY;

    public Ball(int x, int y, Vector3 input)
    {
        super(new Texture("ball.png"));
        this.setOrigin(WIDTH/2, HEIGHT/2);
        this.setSize(WIDTH,HEIGHT);
        this.setPosition(x, y);
        velX = velY = 0;
        setVelocitiesBasedOnInput(input);
    }

    public void setVelocitiesBasedOnInput(Vector3 input)
    {
        float xSide = input.x - getX();
        float ySide = input.y - getY();
        float ratio = ySide / xSide;
        velY = (float)(BASIC_VELOCITY/ Math.sqrt(1+ (1/Math.pow(ratio,2))));
        velX = velY / ratio;
    }

    public void update()
    {
        this.moveBy(velX, velY);
        if(this.getX() < 0 || this.getX() > BallGame.WIDTH - 2*RADIUS)
            velX *= -1;
    }
}
