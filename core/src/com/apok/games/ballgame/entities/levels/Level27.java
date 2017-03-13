package com.apok.games.ballgame.entities.levels;

import com.apok.games.ballgame.entities.Obstacle;
import com.apok.games.ballgame.entities.RotaryObstacle;
import com.apok.games.ballgame.entities.SetOfObstacles;
import com.badlogic.gdx.utils.Timer;


class Level27 extends SetOfObstacles{
    @Override
    protected void initObstacles() {
        obstacles.add(new Obstacle(0, 450, 108,0,0));
        obstacles.add(new Obstacle(324, 450, 108,0,0));
        obstacles.add(new RotaryObstacle(85, 390, 160, 0, 0,0){
            @Override
            protected void initObstacle(int x, int y, int width, int velX, int velY) {
                super.initObstacle(x, y, width, velX, velY);
                Timer.schedule(new Timer.Task() {
                    @Override
                    public void run() {
                        if(getRotation() == -45)
                        {
                            setRotation(45);
                            setPosition(85, 390);
                        }
                        else
                        {
                            setRotation(-45);
                            setPosition(193,390);
                        }

                    }
                },0,1);
            }
        });
        obstacles.add(new Obstacle(216, 450, 108, 0, 0){
            @Override
            protected void initObstacle(int x, int y, int width, int velX, int velY) {
                super.initObstacle(x, y, width, velX, velY);
                Timer.schedule(new Timer.Task() {
                    @Override
                    public void run() {
                       if(getX() == 216)
                           setPosition(108, 450);
                        else
                           setPosition(216,450);
                    }
                },0,1);
            }
        });
    }

    @Override
    public SetOfObstacles nextLevel() {
        return new Level28();
    }
}
