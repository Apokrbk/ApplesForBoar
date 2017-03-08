package com.apok.games.ballgame.entities.levels;

import com.apok.games.ballgame.entities.Obstacle;
import com.apok.games.ballgame.entities.SetOfObstacles;

/**
 * Created by Apok on 08.03.2017.
 */

public class Level17 extends SetOfObstacles{
    @Override
    protected void initObstacles() {
        obstacles.add(new Obstacle(108, 450, 216, -2, -2)
        {
            protected void changeVelY()
            {
                if(getY() < 250 || getY() > 450)
                    velY *= -1;
            }
        });
        obstacles.add(new Obstacle(108, 250, 216, 2, 2){
            protected void changeVelY()
            {
                if(getY() < 250 || getY() > 450)
                    velY *= -1;
            }
        });

    }

    @Override
    public SetOfObstacles nextLevel() {
        return new Level18();
    }
}
