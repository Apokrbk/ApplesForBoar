package com.apok.games.ballgame.entities.levels;

import com.apok.games.ballgame.entities.Ball;
import com.apok.games.ballgame.entities.Obstacle;
import com.apok.games.ballgame.entities.SetOfObstacles;


class Level19 extends SetOfObstacles{
    @Override
    protected void initObstacles() {
        obstacles.add(new Obstacle(0, 500, 150, 0, 0){
            @Override
            protected boolean collidesWithBall(Ball ball) {
                if(ball.getY() > 300)
                    this.setPosition(141,500);
                return super.collidesWithBall(ball);
            }
        });
        obstacles.add(new Obstacle(282, 500, 150, 0, 0){
            @Override
            protected boolean collidesWithBall(Ball ball) {
                if(ball.getY() > 300)
                    this.setPosition(141,500);
                return super.collidesWithBall(ball);
            }
        });
    }

    @Override
    public SetOfObstacles nextLevel() {
        return new Level20();
    }
}
