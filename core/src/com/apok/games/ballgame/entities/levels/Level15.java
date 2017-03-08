package com.apok.games.ballgame.entities.levels;

import com.apok.games.ballgame.entities.Obstacle;
import com.apok.games.ballgame.entities.ReflectiveObstacle;
import com.apok.games.ballgame.entities.RotaryObstacle;
import com.apok.games.ballgame.entities.SetOfObstacles;

/**
 * Created by Apok on 08.03.2017.
 */

public class Level15 extends SetOfObstacles{
    @Override
    protected void initObstacles() {
        obstacles.add(new ReflectiveObstacle(81, 160, 380, 0, 0));
        obstacles.add(new ReflectiveObstacle(341, 160, 380, 0, 0));
        obstacles.add(new RotaryObstacle(0, 320, 81, 0, 0, 4));
        obstacles.add(new RotaryObstacle(351, 320, 81, 0, 0, -4));
        obstacles.add(new Obstacle(91, 200,100, 0, 0));
        obstacles.add(new Obstacle(91, 400,100, 0, 0));
        obstacles.add(new Obstacle(241, 300,100, 0, 0));
        obstacles.add(new Obstacle(241, 500,100, 0, 0));
    }

    @Override
    public SetOfObstacles nextLevel() {
        return new Level16();
    }
}
