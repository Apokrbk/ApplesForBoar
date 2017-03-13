package com.apok.games.ballgame.entities.levels;

import com.apok.games.ballgame.entities.Obstacle;
import com.apok.games.ballgame.entities.SetOfObstacles;


class Level4 extends SetOfObstacles {

    Level4() {
        super();
    }

    @Override
    protected void initObstacles() {
        obstacles.add(new Obstacle(0, 240, 216,2,0));
        obstacles.add(new Obstacle(216, 440, 216, -2,0));
    }

    @Override
    public SetOfObstacles nextLevel() {
        return new Level5();
    }
}