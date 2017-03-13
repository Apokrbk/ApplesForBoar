package com.apok.games.ballgame.entities;

import com.badlogic.gdx.math.Polygon;

public class RotaryObstacle extends Obstacle{
    protected int rotation;
    public RotaryObstacle(int x, int y, int width, int velX, int velY, int rotation) {
        super(x, y, width, velX, velY);
        this.rotation = rotation;
    }
    public void update()
    {
        super.update();
        this.rotateBy(rotation);
        changeRotation();
    }
    protected boolean collidesWithBall(Ball ball)
    {
        Polygon obstaclePolygon = new Polygon(new float[]{0, 0,
                getWidth()+ball.getWidth(), 0,
                getWidth()+ball.getWidth(), Obstacle.HEIGHT+ball.getHeight(),
                0, Obstacle.HEIGHT+ball.getHeight()});
        obstaclePolygon.setOrigin((getWidth()+ball.getWidth())/2, (Obstacle.HEIGHT+ball.getHeight())/2);
        obstaclePolygon.setRotation(this.getRotation());
        obstaclePolygon.setPosition(getX()-ball.getWidth()/2, getY()-ball.getHeight()/2);
        return obstaclePolygon.contains(ball.getX()+ball.getWidth()/2, ball.getY()+ball.getHeight()/2);
    }

    protected void changeRotation()
    {

    }

}
