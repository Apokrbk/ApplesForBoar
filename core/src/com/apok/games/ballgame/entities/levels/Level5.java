package com.apok.games.ballgame.entities.levels;

import com.apok.games.ballgame.entities.Obstacle;
import com.apok.games.ballgame.entities.SetOfObstacles;


class Level5 extends SetOfObstacles {

    private int velX;

    Level5() {
        super();
        velX = 2;
    }

    @Override
    protected void initObstacles() {
        obstacles.add(new Obstacle(0, 240, 216){
            public void update()
            {
                super.update();
                moveBy(velX, 0);
                if(getX() < 0)
                    velX*=-1;
            }
        });
        obstacles.add(new Obstacle(216, 440, 216){
            public void update()
            {
                super.update();
                moveBy(-velX, 0);
                if(getX() < 0)
                    velX*=-1;
            }
        });
    }

    @Override
    public SetOfObstacles nextLevel() {
        return new Level6();
    }
}