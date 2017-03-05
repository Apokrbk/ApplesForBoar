package com.apok.games.ballgame.services;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

/**
 * Created by Apok on 05.03.2017.
 */

public class ScoreService {

    private static final String GAME_PREFS = "com.apok.boar.prefs";
    private static final String GAME_HIGHSCORE = "com.apok.boar.prefs.highscore";

    public int getPoints() {
        return points;
    }

    public int getHighscore() {
        return highscore;
    }

    private int points;
    private int highscore;
    private Preferences preferences;

    public ScoreService()
    {
        init();
    }

    private void init() {
        preferences = Gdx.app.getPreferences(GAME_PREFS);
        loadHighscore();
    }

    private void loadHighscore() {
        highscore = preferences.getInteger(GAME_HIGHSCORE);
    }

    public void addPoint()
    {
        points++;
    }

    public void resetGameScore()
    {
        points =0;
    }

    public void setHighscore()
    {
        if(points > highscore)
        {
            highscore = points;
            preferences.putInteger(GAME_HIGHSCORE, highscore);
            preferences.flush();
        }
    }
}
