package com.apok.games.ballgame.entities.levels;

import com.apok.games.ballgame.entities.Obstacle;
import com.apok.games.ballgame.entities.SetOfObstacles;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Timer;


class Level24 extends SetOfObstacles{

    private int firstPosition = 42;
    private int secondPosition = 158;
    private int thirdPosition = 274;

    @Override
    protected void initObstacles() {

        obstacles.add(new Obstacle(0, 450, 42, 0, 0));
        obstacles.add(new Obstacle(390, 450, 42, 0, 0));
        obstacles.add(new Obstacle(42, 450, 116,0,0){
            @Override
            protected void initObstacle(int x, int y, int width, int velX, int velY) {
                super.initObstacle(x, y, width, velX, velY);
                Timer.schedule(new Timer.Task() {
                    @Override
                    public void run() {
                        switch(MathUtils.random(1,3)){
                            case 1:
                                setPosition(firstPosition, getY()); break;
                            case 2:
                                setPosition(secondPosition, getY()); break;
                            case 3:
                                setPosition(thirdPosition, getY()); break;
                        }
                    }
                },0,1);
            }
        });
        obstacles.add(new Obstacle(158, 350, 116,0,0){
            @Override
            protected void initObstacle(int x, int y, int width, int velX, int velY) {
                super.initObstacle(x, y, width, velX, velY);
                Timer.schedule(new Timer.Task() {
                    @Override
                    public void run() {
                        switch(MathUtils.random(1,3)){
                            case 1:
                                setPosition(firstPosition, getY()); break;
                            case 2:
                                setPosition(secondPosition, getY()); break;
                            case 3:
                                setPosition(thirdPosition, getY()); break;
                        }
                    }
                },0,1);
            }
        });
        obstacles.add(new Obstacle(274, 250, 116,0,0){
            @Override
            protected void initObstacle(int x, int y, int width, int velX, int velY) {
                super.initObstacle(x, y, width, velX, velY);
                Timer.schedule(new Timer.Task() {
                    @Override
                    public void run() {
                        switch(MathUtils.random(1,3)){
                            case 1:
                                setPosition(firstPosition, getY()); break;
                            case 2:
                                setPosition(secondPosition, getY()); break;
                            case 3:
                                setPosition(thirdPosition, getY()); break;
                        }
                    }
                },0,1);
            }
        });


    }

    @Override
    public SetOfObstacles nextLevel() {
        return new Level25();
    }
}
