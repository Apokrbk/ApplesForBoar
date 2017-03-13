package com.apok.games.ballgame.entities.levels;

import com.apok.games.ballgame.entities.RotaryObstacle;
import com.apok.games.ballgame.entities.SetOfObstacles;


class Level7 extends SetOfObstacles{
    @Override
    protected void initObstacles() {
        obstacles.add(new RotaryObstacle(0, 320, 216, 0,0, -2));
        obstacles.add(new RotaryObstacle(216, 320, 216, 0,0, 2));

    }

    @Override
    public SetOfObstacles nextLevel() {
        return new Level8();
    }
}
