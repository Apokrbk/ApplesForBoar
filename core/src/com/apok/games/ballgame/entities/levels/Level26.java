package com.apok.games.ballgame.entities.levels;

import com.apok.games.ballgame.entities.Obstacle;
import com.apok.games.ballgame.entities.SetOfObstacles;


class Level26 extends SetOfObstacles{
    @Override
    protected void initObstacles() {
        obstacles.add(new Obstacle(0,350, 41, 0,0));
        obstacles.add(new Obstacle(391,350, 41, 0,0));
        obstacles.add(new Obstacle(41, 350, 116,0, 2){
            @Override
            protected void changeVelY() {
                if(getY() > 425 || getY() < 275)
                    velY*=-1;
            }
        });
        obstacles.add(new Obstacle(275, 350, 116,0, 2){
            @Override
            protected void changeVelY() {
                if(getY() > 425 || getY() < 275)
                    velY*=-1;
            }
        });
        obstacles.add(new Obstacle(157, 350, 118,0, -2){
            @Override
            protected void changeVelY() {
                if(getY() > 425 || getY() < 275)
                    velY*=-1;
            }
        });

    }

    @Override
    public SetOfObstacles nextLevel() {
        return new Level27();
    }
}
