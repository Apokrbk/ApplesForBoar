package com.apok.games.ballgame.entities.levels;

import com.apok.games.ballgame.entities.Obstacle;
import com.apok.games.ballgame.entities.SetOfObstacles;
import com.badlogic.gdx.scenes.scene2d.Stage;


public class Level1 extends SetOfObstacles{
    public Level1(Stage stage) {
        super(stage);
    }

    @Override
    protected void initObstacles() {
        obstacles.add(new Obstacle(0, 400, 100, 2, 0));
    }
}
