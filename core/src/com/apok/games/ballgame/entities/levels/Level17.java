package com.apok.games.ballgame.entities.levels;

import com.apok.games.ballgame.entities.Obstacle;
import com.apok.games.ballgame.entities.ReflectiveObstacle;
import com.apok.games.ballgame.entities.SetOfObstacles;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Timer;


class Level17 extends SetOfObstacles{
    @Override
    protected void initObstacles() {
        obstacles.add(new ReflectiveObstacle(211, 150, 390, 0, 0));
        obstacles.add(new ReflectiveObstacle(100, 150, 390, 0, 0));
        obstacles.add(new ReflectiveObstacle(322, 150, 390, 0, 0));
        obstacles.add(new Obstacle(0, 440, 80, 0 ,0){
            @Override
            protected void initObstacle(int x, int y, int width, int velX, int velY) {
                super.initObstacle(x, y, width, velX, velY);
                Timer.schedule(new Timer.Task() {
                    @Override
                    public void run() {
                        setPosition(MathUtils.random(0,3)*108 + 14, 440);
                    }
                }, 0, 0.5f);
            }
        });
    }

    @Override
    public SetOfObstacles nextLevel() {
        return new Level18();
    }
}
