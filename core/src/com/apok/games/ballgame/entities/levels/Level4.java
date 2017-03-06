package com.apok.games.ballgame.entities.levels;

import com.apok.games.ballgame.entities.Obstacle;
import com.apok.games.ballgame.entities.SetOfObstacles;


class Level4 extends SetOfObstacles {
    Level4() {
        super();
    }

    @Override
    protected void initObstacles() {
        obstacles.add(new Obstacle(0, 150, 120));
        obstacles.add(new Obstacle(312, 150, 120));
        obstacles.add(new Obstacle(156, 300, 120));
        obstacles.add(new Obstacle(0, 450, 120));
        obstacles.add(new Obstacle(312, 450, 120));

    }

    @Override
    public SetOfObstacles nextLevel() {
        return new Level5();
    }
}