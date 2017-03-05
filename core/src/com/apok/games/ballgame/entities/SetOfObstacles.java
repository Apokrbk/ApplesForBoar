package com.apok.games.ballgame.entities;

import com.badlogic.gdx.scenes.scene2d.Stage;

import java.util.ArrayList;


public abstract class SetOfObstacles {

    protected ArrayList<Obstacle> obstacles;

    public SetOfObstacles(Stage stage)
    {
        obstacles = new ArrayList<Obstacle>();
        initObstacles();
        addObstaclesToStage(stage);
    }

    protected abstract void initObstacles();
    public void updateObstacles()
    {
        for(Obstacle obstacle : obstacles)
        {
            obstacle.update();
        }
    }

    protected void addObstaclesToStage(Stage stage)
    {
        for(Obstacle obstacle : obstacles)
        {
            stage.addActor(obstacle);
        }
    }


}
