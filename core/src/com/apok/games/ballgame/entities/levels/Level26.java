package com.apok.games.ballgame.entities.levels;

import com.apok.games.ballgame.entities.SetOfObstacles;

/**
 * Created by Apok on 09.03.2017.
 */

public class Level26 extends SetOfObstacles{
    @Override
    protected void initObstacles() {

    }

    @Override
    public SetOfObstacles nextLevel() {
        return new Level1();
    }
}
