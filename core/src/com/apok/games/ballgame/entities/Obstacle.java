package com.apok.games.ballgame.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Obstacle extends Image{

    protected static final int HEIGHT = 20;

    private Rectangle bounds;

    public Obstacle(int x, int y, int width)
    {
        super(new Texture("obstacle.png"));
        this.setOrigin(width/2, HEIGHT/2);
        this.setSize(width,HEIGHT);
        this.setPosition(x, y);
        bounds = new Rectangle(x, y, width, HEIGHT);
    }

    public void update()
    {
        bounds.setPosition(this.getX(), this.getY());
    }

    protected boolean collidesWithBall(Ball ball)
    {
        Rectangle ballRectangle = new Rectangle(ball.getX(), ball.getY(), ball.getWidth(), ball.getHeight());
        return bounds.overlaps(ballRectangle);
    }

}
