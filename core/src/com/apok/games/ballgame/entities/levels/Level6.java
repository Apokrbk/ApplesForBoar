package com.apok.games.ballgame.entities.levels;


import com.apok.games.ballgame.entities.RotaryObstacle;
import com.apok.games.ballgame.entities.SetOfObstacles;

class Level6 extends SetOfObstacles {

    private static final int STARTING_X = 41;
    private static final int STARTING_Y = 320;
    private static final int WIDTH = 350;

    Level6() {
        super();
    }

    @Override
    protected void initObstacles() {
        obstacles.add(new RotaryObstacle(STARTING_X, STARTING_Y, WIDTH, 0,0,2));
    }

    @Override
    public SetOfObstacles nextLevel() {
        return new Level6();
    }
}
