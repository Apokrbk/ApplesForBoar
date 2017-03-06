package com.apok.games.ballgame.entities.levels;

import com.apok.games.ballgame.entities.Obstacle;
import com.apok.games.ballgame.entities.SetOfObstacles;
import com.badlogic.gdx.scenes.scene2d.Stage;

import java.util.Stack;


public class Level1 extends SetOfObstacles{
    public Level1() {
        super();
    }

    @Override
    protected void initObstacles() {
        obstacles.add(new Obstacle(116, 300, 200){
            public void update()
            {
                super.update();
            }
        });
    }

    public SetOfObstacles nextLevel()
    {
        return new Level2();
    }
}
