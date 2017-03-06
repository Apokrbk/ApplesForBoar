package com.apok.games.ballgame.entities.levels;

import com.apok.games.ballgame.entities.Obstacle;
import com.apok.games.ballgame.entities.SetOfObstacles;

/**
 * Created by Apok on 06.03.2017.
 */

public class Level3 extends SetOfObstacles{
    public Level3() {
        super();
    }

    @Override
    protected void initObstacles() {
        obstacles.add(new Obstacle(0, 240, 216));
        obstacles.add(new Obstacle(216, 440, 216));
    }

    @Override
    public SetOfObstacles nextLevel() {
        return new Level1();
    }
}
