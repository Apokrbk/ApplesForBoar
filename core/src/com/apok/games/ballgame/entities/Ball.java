package com.apok.games.ballgame.entities;

import com.apok.games.ballgame.BallGame;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import java.awt.Rectangle;

public class Ball extends Image {
    public static final int WIDTH = 40;
    public static final int HEIGHT = 40;
    private static final int BASIC_VELOCITY = 20;

    private float velX;
    private float velY;

    public Ball(int x, int y, Vector3 input)
    {
        super(new Texture("apple.png"));
        this.setOrigin(WIDTH/2, HEIGHT/2);
        this.setSize(WIDTH,HEIGHT);
        this.setPosition(x, y);
        velX = velY = 0;
        setVelocitiesBasedOnInput(input);
    }

    private void setVelocitiesBasedOnInput(Vector3 input)
    {
        float xSide = input.x - getX();
        float ySide = input.y - getY();
        float ratio = ySide / xSide;
        velY = (float)(BASIC_VELOCITY/ Math.sqrt(1+ (1/Math.pow(ratio,2))));
        velX = velY / ratio;
    }

    public boolean update(Boar boar, BallGame game)
    {
        this.moveBy(velX, velY);
        if(this.getX() < 0 || this.getX() > BallGame.WIDTH - WIDTH)
            velX *= -1;
        Rectangle ballRectangle = new Rectangle((int)getX(), (int)getY(), WIDTH, HEIGHT);
        Rectangle boarRectangle = new Rectangle((int)boar.getX(), (int)boar.getY(), boar.WIDTH, boar.HEIGHT);
        if(ballRectangle.intersects(boarRectangle))
        {
            game.addPoint();
            this.remove();
            return false;
        }
        else if(this.getY()> BallGame.HEIGHT)
        {
            this.remove();
            return false;
        }
        return true;
    }
}
