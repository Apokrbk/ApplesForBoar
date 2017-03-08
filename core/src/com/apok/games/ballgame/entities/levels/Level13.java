package com.apok.games.ballgame.entities.levels;

import com.apok.games.ballgame.entities.Obstacle;
import com.apok.games.ballgame.entities.RotaryObstacle;
import com.apok.games.ballgame.entities.SetOfObstacles;

/**
 * Created by Apok on 08.03.2017.
 */

public class Level13 extends SetOfObstacles{
    @Override
    protected void initObstacles() {
        obstacles.add(new Obstacle(0, 320, 20, 0 , 0));
        obstacles.add(new Obstacle(412, 320, 20, 0 , 0));
        obstacles.add(new Obstacle(200, 320, 32, 0 ,0));
        obstacles.add(new RotaryObstacle(20, 320, 180, 0, 0, 1));
        obstacles.add(new RotaryObstacle(232, 320, 180, 0, 0, -1));
    }

    @Override
    public SetOfObstacles nextLevel() {
        return new Level14();
    }
}
