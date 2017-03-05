package com.apok.games.ballgame.entities.levels;

import com.apok.games.ballgame.entities.Obstacle;
import com.apok.games.ballgame.entities.SetOfObstacles;
import com.badlogic.gdx.scenes.scene2d.Stage;

import java.util.Stack;

/**
 * Created by Apok on 05.03.2017.
 */

public class Level2 extends SetOfObstacles {
    public Level2() {
        super();
    }

    @Override
    protected void initObstacles() {
        obstacles.add(new Obstacle(0, 300, 100, 3, 0));
    }

    public SetOfObstacles nextLevel()
    {
        return new Level1();
    }
}