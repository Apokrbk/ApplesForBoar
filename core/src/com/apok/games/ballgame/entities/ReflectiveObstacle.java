package com.apok.games.ballgame.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by Apok on 08.03.2017.
 */

public class ReflectiveObstacle extends Obstacle{
    private static final int WIDTH = 20;
    public ReflectiveObstacle(int x, int y, int height, int velX, int velY) {
        super(new Texture("reflectiveobstacle.png"));
        this.setOrigin(WIDTH/2, height/2);
        this.setSize(WIDTH,height);
        this.setPosition(x,y);
        bounds = new Rectangle(x,y,WIDTH, height);
        this.velY = velY;
        this.velX = velX;
    }

    public boolean collidesWithBall(Ball ball)
    {
        Rectangle ballRectangle = new Rectangle(ball.getX(), ball.getY(), ball.getWidth(), ball.getHeight());
        if(bounds.overlaps(ballRectangle))
        {
            if(ball.getY()+ball.getHeight()/2 > this.getY() && ball.getX() < this.getY()+this.getHeight()-ball.getHeight()/2)
            {
                ball.reverseDirection();
                return false;
            }
            else
                return true;
        }
        return false;
    }
}
