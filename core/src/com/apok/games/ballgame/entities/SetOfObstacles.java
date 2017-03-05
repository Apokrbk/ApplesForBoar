package com.apok.games.ballgame.entities;

import java.util.ArrayList;


public abstract class SetOfObstacles {

    private ArrayList<Obstacle> obstacles;

    public SetOfObstacles()
    {
        initObstacles();
    }

    protected abstract void initObstacles();
    public void updateObstacles()
    {
        for(Obstacle obstacle : obstacles)
        {
            obstacle.update();
        }
    }


}
