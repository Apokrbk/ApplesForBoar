package com.apok.games.ballgame.entities;

import com.badlogic.gdx.scenes.scene2d.Stage;

import java.util.ArrayList;


public abstract class SetOfObstacles {

    protected ArrayList<Obstacle> obstacles;

    public SetOfObstacles(Stage stage)
    {
        obstacles = new ArrayList<Obstacle>();
        initObstacles();
    }

    protected abstract void initObstacles();
    public boolean updateObstacles(boolean ballOnScreen, Ball ball)
    {
        boolean result = ballOnScreen;
        for(Obstacle obstacle : obstacles)
        {
            obstacle.update();
            if(ballOnScreen)
            {
                if(obstacle.collidesWithBall(ball))
                {
                    ball.remove();
                    result = false;
                }
            }
        }
        return result;
    }

    public void addObstaclesToStage(Stage stage)
    {
        for(Obstacle obstacle : obstacles)
        {
            stage.addActor(obstacle);
        }
    }


    public void removeFromStage()
    {
        {
            for(Obstacle obstacle : obstacles)
            {
                obstacle.remove();
            }
        }
    }
}
