package com.apok.games.ballgame.entities.levels;

import com.apok.games.ballgame.entities.Obstacle;
import com.apok.games.ballgame.entities.ReflectiveObstacle;
import com.apok.games.ballgame.entities.SetOfObstacles;


class Level34 extends SetOfObstacles{
    @Override
    protected void initObstacles() {
        obstacles.add(new Obstacle(0, 500, 120, 0, 0));
        obstacles.add(new Obstacle(312, 500, 120, 0, 0));
        obstacles.add(new ReflectiveObstacle(140, 200, 200, 0, 0));
        obstacles.add(new ReflectiveObstacle(282, 200, 200, 0, 0));
        obstacles.add(new Obstacle(160, 350, 112, 0, 0));
    }

    @Override
    public SetOfObstacles nextLevel() {
        return new Level35();
    }
}
