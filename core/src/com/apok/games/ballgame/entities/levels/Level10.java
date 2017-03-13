package com.apok.games.ballgame.entities.levels;

import com.apok.games.ballgame.entities.Obstacle;
import com.apok.games.ballgame.entities.SetOfObstacles;


class Level10 extends SetOfObstacles{
    @Override
    protected void initObstacles() {
        obstacles.add(new Obstacle(0,500,144,0,0));
        obstacles.add(new Obstacle(288, 500, 144, 0 ,0));
        obstacles.add(new Obstacle(144, 500, 144, 0, 4){
            protected void changeVelY()
            {
                if(getY()<140 || getY()>500)
                    velY *= -1;
            }
        });
    }

    @Override
    public SetOfObstacles nextLevel() {
        return new Level11();
    }
}
