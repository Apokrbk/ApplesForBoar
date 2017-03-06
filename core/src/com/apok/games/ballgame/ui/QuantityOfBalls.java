package com.apok.games.ballgame.ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class QuantityOfBalls {
    private Texture ball;

    public QuantityOfBalls()
    {
        ball = new Texture("apple.png");
    }

    public void drawBalls(SpriteBatch spriteBatch, int balls)
    {
        for(int i=0; i<balls; i++)
        {
            spriteBatch.draw(ball, 340 + i*30, 9, 30,30);
        }
    }
}
