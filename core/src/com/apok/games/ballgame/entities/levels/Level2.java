package com.apok.games.ballgame.entities.levels;

import com.apok.games.ballgame.entities.Obstacle;
import com.apok.games.ballgame.entities.SetOfObstacles;


class Level2 extends SetOfObstacles {
    Level2() {
        super();
    }

    @Override
    protected void initObstacles() {
        obstacles.add(new Obstacle(0, 300, 150));
        obstacles.add(new Obstacle(282, 300, 150));
    }

    public SetOfObstacles nextLevel()
    {
        return new Level3();
    }
}