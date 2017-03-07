package com.apok.games.ballgame.entities.levels;


import com.apok.games.ballgame.entities.Ball;
import com.apok.games.ballgame.entities.Obstacle;
import com.apok.games.ballgame.entities.SetOfObstacles;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

class Level6 extends SetOfObstacles {

    private static final int STARTING_X = 41;
    private static final int STARTING_Y = 320;
    private static final int WIDTH = 350;

    Level6() {
        super();
    }

    @Override
    protected void initObstacles() {
        obstacles.add(new Obstacle(STARTING_X, STARTING_Y, WIDTH){
            public void update()
            {
                super.update();
                rotateBy(2);
            }
            protected boolean collidesWithBall(Ball ball)
            {
                Polygon obstaclePolygon = new Polygon(new float[]{0, 0,
                                                            WIDTH+ball.getWidth(), 0,
                                                            WIDTH+ball.getWidth(), Obstacle.HEIGHT+ball.getHeight(),
                                                            0, Obstacle.HEIGHT+ball.getHeight()});
                obstaclePolygon.setOrigin((WIDTH+ball.getWidth())/2, (Obstacle.HEIGHT+ball.getHeight())/2);
                obstaclePolygon.setRotation(this.getRotation());
                obstaclePolygon.setPosition(STARTING_X-ball.getWidth()/2, STARTING_Y-ball.getHeight()/2);
                return obstaclePolygon.contains(ball.getX()+ball.getWidth()/2, ball.getY()+ball.getHeight()/2);
            }
        });
    }

    @Override
    public SetOfObstacles nextLevel() {
        return new Level6();
    }
}
