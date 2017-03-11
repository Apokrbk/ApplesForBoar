package com.apok.games.ballgame.entities.levels;

import com.apok.games.ballgame.entities.Obstacle;
import com.apok.games.ballgame.entities.SetOfObstacles;

/**
 * Created by Apok on 11.03.2017.
 */

public class Level35 extends SetOfObstacles {
    @Override
    protected void initObstacles() {
        obstacles.add(new Obstacle(85, 240, 30, 0, 0));
        obstacles.add(new Obstacle(201, 240, 30, 0, 0));
        obstacles.add(new Obstacle(317,240, 30,0,0));
        obstacles.add(new Obstacle(85, 440, 30, 0, 0));
        obstacles.add(new Obstacle(201, 440, 30, 0, 0));
        obstacles.add(new Obstacle(317,440, 30,0,0));
        obstacles.add(new Obstacle(85, 340, 30, 3, 0){
            @Override
            protected void changeVelX() {
                if(getX() <0 || getX() > 170)
                    velX *= -1;
            }
        });
        obstacles.add(new Obstacle(201, 340, 30, 3, 0){
            @Override
            protected void changeVelX() {
                if(getX() <116 || getX() > 286)
                    velX *= -1;
            }
        });
        obstacles.add(new Obstacle(317, 340, 30, 3, 0){
            @Override
            protected void changeVelX() {
                if(getX() <232 || getX() > 402)
                    velX *= -1;
            }
        });
        obstacles.add(new Obstacle(-30, 340, 30, 3, 0){
            @Override
            protected void changeVelX() {
                if(getX() <-115 || getX() > 55)
                    velX *= -1;
            }
        });
        obstacles.add(new Obstacle(433, 340, 30, 3, 0){
            @Override
            protected void changeVelX() {
                if(getX() <348 || getX() > 518)
                    velX *= -1;
            }
        });

    }

    @Override
    public SetOfObstacles nextLevel() {
        return new RandomLevel();
    }
}
