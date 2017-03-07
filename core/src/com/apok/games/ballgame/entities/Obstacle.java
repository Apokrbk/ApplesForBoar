package com.apok.games.ballgame.entities;

import com.apok.games.ballgame.BallGame;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Obstacle extends Image{

    protected static final int HEIGHT = 20;

    private Rectangle bounds;
    protected int velX;
    protected int velY;

    public Obstacle(int x, int y, int width, int velX, int velY)
    {
        super(new Texture("obstacle.png"));
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
        bounds.setPosition(this.getX(), this.getY());
        if(getX()<0 || getX()> BallGame.WIDTH - getWidth())
            velX*=-1;
    }

    protected boolean collidesWithBall(Ball ball)
    {
        Rectangle ballRectangle = new Rectangle(ball.getX(), ball.getY(), ball.getWidth(), ball.getHeight());
        return bounds.overlaps(ballRectangle);
    }

}
