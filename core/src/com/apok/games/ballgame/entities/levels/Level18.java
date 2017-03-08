package com.apok.games.ballgame.entities.levels;

import com.apok.games.ballgame.entities.Obstacle;
import com.apok.games.ballgame.entities.SetOfObstacles;

/**
 * Created by Apok on 08.03.2017.
 */

public class Level18 extends SetOfObstacles{
    @Override
    protected void initObstacles() {
        initStableObstacles();
        initFirstMovingObstacle();
        initSecondMovingObstacle();
        initThirdMovingObstacle();
    }

    private void initThirdMovingObstacle() {
        Obstacle obstacle = new Obstacle(144, 500, 144, -2, 0)
        {
            public void changeVelX()
            {
                if(getX() < -20)
                    velX = 15;
                else if(getX() > 144)
                    velX = -1;
            }
        };
        obstacles.add(obstacle);
    }

    private void initSecondMovingObstacle() {
        Obstacle obstacle = new Obstacle(134, 400, 144, -2, 0)
        {
            public void changeVelX()
            {
                if(getX() < -20)
                    velX = 15;
                else if(getX() > 144)
                    velX = -1;
            }
        };
        obstacles.add(obstacle);
    }

    private void initFirstMovingObstacle() {
        Obstacle obstacle = new Obstacle(124, 300, 144, -2, 0)
        {
            public void changeVelX()
            {
                if(getX() < -20)
                    velX = 15;
                else if(getX() > 144)
                    velX = -1;
            }
        };
        obstacles.add(obstacle);
    }

    private void initStableObstacles() {
        obstacles.add(new Obstacle(0, 300, 144, 0 ,0));
        obstacles.add(new Obstacle(0, 400, 144, 0 ,0));
        obstacles.add(new Obstacle(0, 500, 144, 0 ,0));
        obstacles.add(new Obstacle(288, 300, 144, 0 ,0));
        obstacles.add(new Obstacle(288, 400, 144, 0 ,0));
        obstacles.add(new Obstacle(288, 500, 144, 0 ,0));
    }

    @Override
    public SetOfObstacles nextLevel() {
        return new Level18();
    }
}
