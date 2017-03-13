package com.apok.games.ballgame.entities.levels;

import com.apok.games.ballgame.entities.Obstacle;
import com.apok.games.ballgame.entities.ReflectiveObstacle;
import com.apok.games.ballgame.entities.SetOfObstacles;
import com.badlogic.gdx.utils.Timer;


class Level18 extends SetOfObstacles{
    @Override
    protected void initObstacles() {
        obstacles.add(new ReflectiveObstacle(211, 160, 370, 0 ,0));
        initFirstObstacle();
        initSecondObstacle();
        initThirdObstacle();
        initFourthObstacle();
    }

    private void initFourthObstacle() {
        obstacles.add(new Obstacle(362, 300, 70, 0 ,0){
            @Override
            protected void initObstacle(int x, int y, int width, int velX, int velY) {
                super.initObstacle(x, y, width, velX, velY);
                Timer.schedule(new Timer.Task() {
                    @Override
                    public void run() {
                        if(getX() == 221)
                            setPosition(362, 300);
                        else
                            setPosition(221, 300);
                    }
                },0,1);
            }
        });
    }

    private void initThirdObstacle() {
        obstacles.add(new Obstacle(0, 300, 70, 0 ,0){
            @Override
            protected void initObstacle(int x, int y, int width, int velX, int velY) {
                super.initObstacle(x, y, width, velX, velY);
                Timer.schedule(new Timer.Task() {
                    @Override
                    public void run() {
                        if(getX() == 141)
                            setPosition(0, 300);
                        else
                            setPosition(141, 300);
                    }
                },0,1);
            }
        });
    }

    private void initSecondObstacle() {
        obstacles.add(new Obstacle(141, 500, 70, 0 ,0){
            @Override
            protected void initObstacle(int x, int y, int width, int velX, int velY) {
                super.initObstacle(x, y, width, velX, velY);
                Timer.schedule(new Timer.Task() {
                    @Override
                    public void run() {
                        if(getX() == 141)
                            setPosition(0, 500);
                        else
                            setPosition(141, 500);
                    }
                },0,1);
            }
        });
    }

    private void initFirstObstacle() {
        obstacles.add(new Obstacle(221, 500, 70, 0 ,0){
            @Override
            protected void initObstacle(int x, int y, int width, int velX, int velY) {
                super.initObstacle(x, y, width, velX, velY);
                Timer.schedule(new Timer.Task() {
                    @Override
                    public void run() {
                        if(getX() == 221)
                            setPosition(362, 500);
                        else
                            setPosition(221, 500);
                    }
                },0,1);
            }
        });
    }

    @Override
    public SetOfObstacles nextLevel() {
        return new Level19();
    }
}
