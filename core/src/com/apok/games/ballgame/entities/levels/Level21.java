package com.apok.games.ballgame.entities.levels;

import com.apok.games.ballgame.entities.Obstacle;
import com.apok.games.ballgame.entities.SetOfObstacles;
import com.badlogic.gdx.math.MathUtils;

/**
 * Created by Apok on 09.03.2017.
 */

public class Level21 extends SetOfObstacles{
    @Override
    protected void initObstacles() {
        obstacles.add(new Obstacle(432, 400, 150, -15, 0){
            @Override
            public void update() {
                super.update();
                if(getX() < -150)
                    this.setPosition(432, MathUtils.random(2.0f,5.0f)*100);
            }

            @Override
            protected void changeVelX() {

            }
        });
    }

    @Override
    public SetOfObstacles nextLevel() {
        return new Level22();
    }
}
