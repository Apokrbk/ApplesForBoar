package com.apok.games.ballgame.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * Created by Apok on 02.03.2017.
 */

public class Player extends Image {
    private static final int WIDTH = 50;
    private static final int HEIGHT = 50;

    private static final int STARTING_X = 200;
    private static final int STARTING_Y = 50;

    public Player()
    {
        super(new Texture("player.png"));
        this.setSize(WIDTH,HEIGHT);
        this.setPosition(STARTING_X, STARTING_Y);
    }
}
