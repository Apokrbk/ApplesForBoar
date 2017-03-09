package com.apok.games.ballgame.entities.levels;

import com.apok.games.ballgame.entities.Obstacle;
import com.apok.games.ballgame.entities.SetOfObstacles;
import com.badlogic.gdx.math.MathUtils;

/**
 * Created by Apok on 09.03.2017.
 */

public class Level20 extends SetOfObstacles{
    @Override
    protected void initObstacles() {
        obstacles.add(new Obstacle(-150, 400, 150, 15, 0){
            @Override
            public void update() {
                super.update();
                if(getX() > 432)
                    this.setPosition(-150, MathUtils.random(3,5)*100);
            }

            @Override
            protected void changeVelX() {

            }
        });
    }

    @Override
    public SetOfObstacles nextLevel() {
        return new Level21();
    }
}
