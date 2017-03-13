package com.apok.games.ballgame.entities.levels;

import com.apok.games.ballgame.entities.Obstacle;
import com.apok.games.ballgame.entities.SetOfObstacles;


class Level8 extends SetOfObstacles{
    @Override
    protected void initObstacles() {
        obstacles.add(new Obstacle(0, 180, 200,0,0));
        obstacles.add(new Obstacle(232, 320, 200, 0,0));
        obstacles.add(new Obstacle(0, 460, 200,0,0));
    }

    @Override
    public SetOfObstacles nextLevel() {
        return new Level9();
    }
}
