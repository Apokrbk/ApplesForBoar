package com.apok.games.ballgame.entities;

import com.badlogic.gdx.scenes.scene2d.Stage;

import java.util.ArrayList;


public abstract class SetOfObstacles {

    protected ArrayList<Obstacle> obstacles;

    public SetOfObstacles()
    {
        obstacles = new ArrayList<Obstacle>();
        initObstacles();
    }

    protected abstract void initObstacles();
    public abstract SetOfObstacles nextLevel();
    public void updateObstacles(Ball ball)
    {
        for(Obstacle obstacle : obstacles)
        {
            obstacle.update();
            if(ballHitObstacle(ball, obstacle))
                    ball.remove();

        }
    }

    private boolean ballHitObstacle(Ball ball, Obstacle obstacle) {
        return !(ball.getStage() == null) && obstacle.collidesWithBall(ball);
    }

    public void addObstaclesToStage(Stage stage)
    {
        for(Obstacle obstacle : obstacles)
            stage.addActor(obstacle);
    }

    public void removeFromStage()
    {
        for(Obstacle obstacle : obstacles)
            obstacle.remove();
    }
}
