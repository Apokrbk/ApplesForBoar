package com.apok.games.ballgame.entities.levels;

import com.apok.games.ballgame.entities.Obstacle;
import com.apok.games.ballgame.entities.ReflectiveObstacle;
import com.apok.games.ballgame.entities.SetOfObstacles;

/**
 * Created by Apok on 10.03.2017.
 */

public class Level30 extends SetOfObstacles{
    @Override
    protected void initObstacles() {
        obstacles.add(new Obstacle(0, 430, 150, 0, 0));
        obstacles.add(new Obstacle(160,230, 272, 0, 0 ));
        obstacles.add(new ReflectiveObstacle(150, 140, 100, 0, 2){
            @Override
            protected void changeVelY() {
                if(getY() > 240)
                    velY*=-1;
                else if(getY() < 140)
                    velY*=-1;
            }
        });
        obstacles.add(new ReflectiveObstacle(150, 340, 100, 0, 2){
            @Override
            protected void changeVelY() {
                if(getY() > 440)
                    velY*=-1;
                else if(getY() < 340)
                    velY*=-1;
            }
        });
    }

    @Override
    public SetOfObstacles nextLevel() {
        return new Level30();
    }
}
