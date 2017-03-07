package com.apok.games.ballgame.entities.levels;

import com.apok.games.ballgame.entities.Obstacle;
import com.apok.games.ballgame.entities.SetOfObstacles;

/**
 * Created by Apok on 07.03.2017.
 */

public class Level9 extends SetOfObstacles {
    @Override
    protected void initObstacles() {
        obstacles.add(new Obstacle(0, 320, 150, 3, 0));
        obstacles.add(new Obstacle(282, 320, 150, -3, 0));
    }

    @Override
    public SetOfObstacles nextLevel() {
        return new Level10();
    }
}
