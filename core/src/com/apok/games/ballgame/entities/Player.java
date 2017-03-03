package com.apok.games.ballgame.entities;

import com.apok.games.ballgame.BallGame;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.ui.Image;


public class Player extends Image {
    private static final int WIDTH = 50;
    private static final int HEIGHT = 50;

    private static final int STARTING_X = 200;
    private static final int STARTING_Y = 50;

    public Player()
    {
        super(new Texture("apple.png"));
        this.setOrigin(WIDTH/2, HEIGHT/2);
        this.setSize(WIDTH,HEIGHT);
        this.setPosition(STARTING_X, STARTING_Y);
    }

    /*public float countAngleToInput(Vector3 input) {
        float x = input.x - getX();
        float y = input.y - getY();
        double angle = MathUtils.atan2(y,x) * 180.0d / Math.PI;
        return (float)angle;
    }*/

    public void update(Vector3 input) {
            Rectangle playerMovement = new Rectangle(0+this.getWidth()/2,0, BallGame.WIDTH - this.getWidth(), 200);
            if(Gdx.input.isTouched() && playerMovement.contains(input.x, input.y))
                this.setPosition(input.x - this.getWidth()/2, this.getY());
         /*   if(Gdx.input.isTouched() && input.y > 200)
            {
                this.setRotation(this.countAngleToInput(input) + 270);
            }*/
    }
}
