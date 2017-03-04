package com.apok.games.ballgame.entities;

import com.apok.games.ballgame.BallGame;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Obstacle extends Image{
    private static final int WIDTH = 150;
    private static final int HEIGHT = 30;
    
    private Rectangle bounds;
    private int velX;

    public Obstacle()
    {
        super(new Texture("obstacle.png"));
        int starting_x = MathUtils.random(0, BallGame.WIDTH - WIDTH);
        int starting_y = MathUtils.random(200, 500);
        this.setOrigin(WIDTH/2, HEIGHT/2);
        this.setSize(WIDTH,HEIGHT);
        this.setPosition(starting_x, starting_y);
        bounds = new Rectangle(starting_x, starting_y, WIDTH, HEIGHT);
        velX = MathUtils.random(1,4);
    }

    public void update()
    {
        this.moveBy(velX, 0);
        bounds.setPosition(bounds.getX() + velX, bounds.getY());
        if(getX() < 0 || getX() > BallGame.WIDTH - WIDTH)
            velX*=-1;
    }

    public boolean collidesWithBall(Ball ball)
    {
        Rectangle ballRectangle = new Rectangle(ball.getX(), ball.getY(), ball.getWidth(), ball.getHeight());
        return bounds.overlaps(ballRectangle);
    }

}
