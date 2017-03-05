package com.apok.games.ballgame.entities;

import com.apok.games.ballgame.BallGame;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Obstacle extends Image{

    private static final int HEIGHT = 20;

    private Rectangle bounds;
    private int velX;
    private int velY;
    private int width;

    public Obstacle(int x, int y, int width, int velX, int velY)
    {
        super(new Texture("obstacle.png"));
        this.width = width;
        this.setOrigin(width/2, HEIGHT/2);
        this.setSize(width,HEIGHT);
        this.setPosition(x, y);
        bounds = new Rectangle(x, y, width, HEIGHT);
        this.velX = velX;
        this.velY = velY;
    }

    public void update()
    {
        this.moveBy(velX, velY);
        bounds.setPosition(bounds.getX() + velX, bounds.getY() + velY);
        if(getX() < 0 || getX() > BallGame.WIDTH - width)
            velX*=-1;
    }

    public boolean collidesWithBall(Ball ball)
    {
        Rectangle ballRectangle = new Rectangle(ball.getX(), ball.getY(), ball.getWidth(), ball.getHeight());
        return bounds.overlaps(ballRectangle);
    }

}
