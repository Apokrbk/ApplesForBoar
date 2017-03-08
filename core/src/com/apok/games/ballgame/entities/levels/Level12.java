package com.apok.games.ballgame.entities.levels;

import com.apok.games.ballgame.entities.Obstacle;
import com.apok.games.ballgame.entities.RotaryObstacle;
import com.apok.games.ballgame.entities.SetOfObstacles;

/**
 * Created by Apok on 07.03.2017.
 */

public class Level12 extends SetOfObstacles {
    @Override
    protected void initObstacles() {
        initFirstObstacle();
        initSecondObstacle();
    }

    private void initSecondObstacle() {
        RotaryObstacle obstacle = new RotaryObstacle(292, 250, 140, -3, 0, -4);
        obstacles.add(obstacle);
    }

    private void initFirstObstacle() {
        Obstacle obstacle = new RotaryObstacle(0, 400, 140, 3, 0, 4);
        obstacles.add(obstacle);
    }

    @Override
    public SetOfObstacles nextLevel() {
        return new Level13();
    }
}
