package com.apok.games.ballgame.entities.levels;

import com.apok.games.ballgame.entities.RotaryObstacle;
import com.apok.games.ballgame.entities.SetOfObstacles;

/**
 * Created by Apok on 07.03.2017.
 */

public class Level11 extends SetOfObstacles {
    @Override
    protected void initObstacles() {
        initFirstObstacle();
        initSecondObstacle();
    }

    private void initSecondObstacle() {
        RotaryObstacle obstacleTwo = new RotaryObstacle(216, 320, 472, 0 ,0, -1){
            protected void changeRotation()
            {
                if(getRotation() < -90)
                    rotation = 10;
                else if(getRotation() > 0)
                    rotation = -1;
            }
        };
        obstacles.add(obstacleTwo);
    }

    private void initFirstObstacle() {
        RotaryObstacle obstacleOne = new RotaryObstacle(-256,320, 472, 0,0,1){
            protected void changeRotation()
            {
                if(getRotation() > 90)
                    rotation = -10;
                else if(getRotation() < 0)
                    rotation = 1;
            }
        };
        obstacles.add(obstacleOne);
    }

    @Override
    public SetOfObstacles nextLevel() {
        return new Level12();
    }
}
