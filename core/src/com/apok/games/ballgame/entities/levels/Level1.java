package com.apok.games.ballgame.entities.levels;

import com.apok.games.ballgame.entities.Obstacle;
import com.apok.games.ballgame.entities.SetOfObstacles;

public class Level1 extends SetOfObstacles{
    public Level1() {
        super();
    }

    @Override
    protected void initObstacles() {
        obstacles.add(new Obstacle(116, 300, 200 ,0 ,0));
    }

    public SetOfObstacles nextLevel()
    {
        return new Level13();
    }
}
