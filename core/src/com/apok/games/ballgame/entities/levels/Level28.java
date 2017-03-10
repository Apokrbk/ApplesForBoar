package com.apok.games.ballgame.entities.levels;

import com.apok.games.ballgame.entities.Obstacle;
import com.apok.games.ballgame.entities.ReflectiveObstacle;
import com.apok.games.ballgame.entities.SetOfObstacles;

/**
 * Created by Apok on 10.03.2017.
 */

public class Level28 extends SetOfObstacles{
    @Override
    protected void initObstacles() {
        obstacles.add(new ReflectiveObstacle(150, 200, 100, 0, 0));
        obstacles.add(new ReflectiveObstacle(300, 430, 100 ,0 ,0));
        obstacles.add(new Obstacle(160, 290, 272,0,0));
        obstacles.add(new Obstacle(0, 430, 300, 0,0));
    }

    @Override
    public SetOfObstacles nextLevel() {
        return new Level29();
    }
}
