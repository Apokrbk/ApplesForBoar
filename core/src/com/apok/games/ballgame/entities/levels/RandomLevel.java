package com.apok.games.ballgame.entities.levels;

import com.apok.games.ballgame.entities.Obstacle;
import com.apok.games.ballgame.entities.RotaryObstacle;
import com.apok.games.ballgame.entities.SetOfObstacles;
import com.badlogic.gdx.math.MathUtils;



class RandomLevel extends SetOfObstacles{
    @Override
    protected void initObstacles() {
        for(int i=0; i<MathUtils.random(2,5); i++)
            obstacles.add(new Obstacle(MathUtils.random(0,432),MathUtils.random(200,500),
                MathUtils.random(100,200), MathUtils.random(0,5), MathUtils.random(0,5)));
        for(int i=0; i<MathUtils.random(0,1); i++)
            obstacles.add(new RotaryObstacle(MathUtils.random(0,432),MathUtils.random(200,500),
                    MathUtils.random(100,200), MathUtils.random(0,5), MathUtils.random(0,5),
                    MathUtils.random(0,3)));

    }

    @Override
    public SetOfObstacles nextLevel() {
        return new RandomLevel();
    }
}
