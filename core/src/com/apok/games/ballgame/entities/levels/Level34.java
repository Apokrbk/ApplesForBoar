package com.apok.games.ballgame.entities.levels;

import com.apok.games.ballgame.entities.Obstacle;
import com.apok.games.ballgame.entities.RotaryObstacle;
import com.apok.games.ballgame.entities.SetOfObstacles;

/**
 * Created by Apok on 11.03.2017.
 */

public class Level34 extends SetOfObstacles{
    @Override
    protected void initObstacles() {
        RotaryObstacle obstacle = new RotaryObstacle(0, 400, 150, 4, 0, 0);
        obstacle.setRotation(90);
        obstacles.add(obstacle);
        RotaryObstacle obstacle2 = new RotaryObstacle(282, 230, 150, -4, 0, 0);
        obstacle2.setRotation(90);
        obstacles.add(obstacle2);
        obstacles.add(new Obstacle(0, 313, 100, 0,0));
        obstacles.add(new Obstacle(332, 313, 100, 0,0));

    }

    @Override
    public SetOfObstacles nextLevel() {
        return new Level35();
    }
}
