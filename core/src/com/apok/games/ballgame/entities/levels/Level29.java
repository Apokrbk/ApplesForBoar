package com.apok.games.ballgame.entities.levels;

import com.apok.games.ballgame.entities.Obstacle;
import com.apok.games.ballgame.entities.ReflectiveObstacle;
import com.apok.games.ballgame.entities.SetOfObstacles;

/**
 * Created by Apok on 10.03.2017.
 */

public class Level29 extends SetOfObstacles{
    @Override
    protected void initObstacles() {
        obstacles.add(new ReflectiveObstacle(211, 200, 150, 0,0));
        obstacles.add(new ReflectiveObstacle(211, 430, 110, 0,0));
        obstacles.add(new Obstacle(0, 300, 181, 0, 0));
        obstacles.add(new Obstacle(251, 500, 211, 0, 0));

    }

    @Override
    public SetOfObstacles nextLevel() {
        return new Level29();
    }
}
