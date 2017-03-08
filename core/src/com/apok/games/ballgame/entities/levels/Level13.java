package com.apok.games.ballgame.entities.levels;

import com.apok.games.ballgame.entities.ReflectiveObstacle;
import com.apok.games.ballgame.entities.SetOfObstacles;

/**
 * Created by Apok on 08.03.2017.
 */

public class Level13 extends SetOfObstacles{
    @Override
    protected void initObstacles() {
        obstacles.add(new ReflectiveObstacle(50, 150, 300, 0 , 0));
        obstacles.add(new ReflectiveObstacle(350, 150, 300, 0 , 0));

    }

    @Override
    public SetOfObstacles nextLevel() {
        return new Level13();
    }
}
