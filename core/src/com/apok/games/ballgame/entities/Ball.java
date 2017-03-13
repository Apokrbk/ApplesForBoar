package com.apok.games.ballgame.entities;

import com.apok.games.ballgame.BallGame;
import com.apok.games.ballgame.screens.GameplayScreen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;


public class Ball extends Image {
    private static int WIDTH = 40;
    private static int HEIGHT = 40;
    private static final int BASIC_VELOCITY = 14;

    public static void makeBallSmaller()
    {
        WIDTH = 30;
        HEIGHT = 30;
    }

    private float velX;
    private float velY;

    public Ball(){}
    public Ball(int x, int y, Vector3 input)
    {
        super(new Texture("apple.png"));
        this.setOrigin(WIDTH/2, HEIGHT/2);
        this.setSize(WIDTH,HEIGHT);
        this.setPosition(x, y);
        velX = velY = 0;
        setVelocitiesBasedOnInput(input);
        rotate();
    }

    private void setVelocitiesBasedOnInput(Vector3 input)
    {
        float xSide = input.x - getX();
        float ySide = input.y - getY();
        float ratio = ySide / xSide;
        velY = (float)(BASIC_VELOCITY/ Math.sqrt(1+ (1/Math.pow(ratio,2))));
        velX = velY / ratio;
    }

    public void update(Boar boar, GameplayScreen gameplayScreen)
    {
        this.moveBy(velX, velY);
        changeDirectionIfBallHitSide();
        if(ballCollidesWithBoar(boar))
        {
            gameplayScreen.getGame().getScoreService().addPoint();
            gameplayScreen.changeToNextLevel();
            this.remove();
        }
        else if(this.getY()> BallGame.HEIGHT)
        {
            this.remove();
        }
    }

    private void changeDirectionIfBallHitSide() {
        if(this.getX() < 0 || this.getX() > BallGame.WIDTH - WIDTH)
            reverseDirection();
    }

    void reverseDirection()
    {
        velX *= -1;
    }

    private boolean ballCollidesWithBoar(Boar boar)
    {
        Rectangle ballRectangle = new Rectangle(getX(), getY(), WIDTH, HEIGHT);
        Rectangle boarRectangle = new Rectangle(boar.getX(), boar.getY(), boar.getWidth(), boar.getHeight());
        return ballRectangle.overlaps(boarRectangle);
    }

    private void rotate()
    {
        Action rotation = Actions.rotateBy(4*360, 4);
        this.addAction(rotation);
    }

    public static void setToStartingSize() {
        WIDTH = 40;
        HEIGHT = 40;
    }
}
