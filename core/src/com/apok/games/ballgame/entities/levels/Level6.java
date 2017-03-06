package com.apok.games.ballgame.entities.levels;


import com.apok.games.ballgame.entities.Ball;
import com.apok.games.ballgame.entities.Obstacle;
import com.apok.games.ballgame.entities.SetOfObstacles;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Polygon;

class Level6 extends SetOfObstacles {
    Level6() {
        super();
    }

    @Override
    protected void initObstacles() {
        obstacles.add(new Obstacle(41, 320, 350){
            public void update()
            {
                super.update();
                rotateBy(2);
            }
            protected boolean collidesWithBall(Ball ball)
            {
                Polygon obstaclePolygon = new Polygon(new float[]{41, 320, 41, 340, 41, 491});
                obstaclePolygon.setOrigin(350/2, 20/2);
                obstaclePolygon.setRotation(this.getRotation());
                Polygon ballPolygon = new Polygon(new float[]{ball.getX(), ball.getY(),
                                                    ball.getX()+ball.getWidth(), ball.getY(),
                                                    ball.getX(), ball.getY()+ball.getHeight()});
                ballPolygon.setRotation(ball.getRotation());
                return Intersector.overlapConvexPolygons(obstaclePolygon, ballPolygon);
            }
        });
    }

    @Override
    public SetOfObstacles nextLevel() {
        return new Level1();
    }
}
