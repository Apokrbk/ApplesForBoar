package com.apok.games.ballgame.entities.levels;

import com.apok.games.ballgame.entities.Obstacle;
import com.apok.games.ballgame.entities.ReflectiveObstacle;
import com.apok.games.ballgame.entities.RotaryObstacle;
import com.apok.games.ballgame.entities.SetOfObstacles;


class Level28 extends SetOfObstacles{
    @Override
    protected void initObstacles() {
        initSides();
        obstacles.add(new Obstacle(0, 525, 150, 0, 0));
        obstacles.add(new Obstacle(282, 525, 150, 0, 0));
        obstacles.add(new Obstacle(150, 320, 132, 0 , 0));
        obstacles.add(new ReflectiveObstacle(20, 160, 100, 0, 2){
            protected void changeVelY()
            {
                if(getY() < 160 || getY() > 420)
                    velY *= -1;
            }
        });
        obstacles.add(new ReflectiveObstacle(402, 420, 100, 0, -2)
        {
            protected void changeVelY()
            {
                if(getY() < 160 || getY() > 420)
                    velY *= -1;
            }
        });

    }

    private void initSides() {
        RotaryObstacle rotaryObstacle = new RotaryObstacle(-195, 320, 400, 0, 0, 0);
        rotaryObstacle.setRotation(90);
        obstacles.add(rotaryObstacle);
        rotaryObstacle = new RotaryObstacle(227, 320, 400, 0, 0, 0);
        rotaryObstacle.setRotation(90);
        obstacles.add(rotaryObstacle);
    }

    @Override
    public SetOfObstacles nextLevel() {
        return new Level29();
    }
}
