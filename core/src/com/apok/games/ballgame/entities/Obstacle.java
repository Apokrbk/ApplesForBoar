package com.apok.games.ballgame.entities;

import com.apok.games.ballgame.BallGame;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Obstacle extends Image{

    protected static final int HEIGHT = 10;

    protected Rectangle bounds;
    protected int velX;
    protected int velY;

    protected Obstacle(Texture texture)
    {
        super(texture);
    }

    public Obstacle(int x, int y, int width, int velX, int velY)
    {
        super(new Texture("obstacle.png"));
        initObstacle(x, y, width, velX, velY);
    }

    protected void initObstacle(int x, int y, int width, int velX, int velY) {
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
        changeVelX();
        changeVelY();
    }

    protected void changeVelY() {
        if(getY() < 140 || getY() > 540)
            velY*=-1;
    }

    protected void changeVelX() {
        if(getX()<0 || getX()> BallGame.WIDTH - getWidth())
            velX*=-1;
    }

    protected boolean collidesWithBall(Ball ball)
    {
        Rectangle ballRectangle = new Rectangle(ball.getX(), ball.getY(), ball.getWidth(), ball.getHeight());
        return bounds.overlaps(ballRectangle);
    }

}
