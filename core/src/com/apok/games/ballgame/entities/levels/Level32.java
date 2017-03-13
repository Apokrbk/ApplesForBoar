package com.apok.games.ballgame.entities.levels;

import com.apok.games.ballgame.entities.Obstacle;
import com.apok.games.ballgame.entities.SetOfObstacles;


class Level32 extends SetOfObstacles{
    @Override
    protected void initObstacles() {
        obstacles.add(new Obstacle(0,290, 150, 4, 0));
        obstacles.add(new Obstacle(150,310, 150, 4, 0));

    }

    @Override
    public SetOfObstacles nextLevel() {
        return new Level33();
    }
}
