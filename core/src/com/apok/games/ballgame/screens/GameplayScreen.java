package com.apok.games.ballgame.screens;

import com.apok.games.ballgame.BallGame;
import com.apok.games.ballgame.entities.Ball;
import com.apok.games.ballgame.entities.Boar;
import com.apok.games.ballgame.entities.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;

import java.util.ArrayList;


public class GameplayScreen extends AbstractScreen{

    private Image background;
    private Player player;
    private Ball ball;
    private Vector3 input;
    private Boar boar;
    private int balls = 3;
    private boolean ballOnScreen = false;

    public GameplayScreen(BallGame game) {
        super(game);
    }

    @Override
    protected void init() {
        input = new Vector3(0,0,0);
        background = new Image(new Texture("menubackground.png"));
        player = new Player();
        boar = new Boar();
        stage.addActor(background);
        stage.addActor(boar);
        stage.addActor(player);

    }

    public void render(float delta)
    {
        super.render(delta);
        input.set(Gdx.input.getX(), Gdx.input.getY(), 0);
        camera.unproject(input);
        addBall();
        boar.update();
        player.update(input);
        if(ballOnScreen)
            ballOnScreen = ball.update();
        spriteBatch.begin();
        stage.draw();
        spriteBatch.end();
    }

    private void addBall() {
        if(Gdx.input.isTouched() && input.y > 150 && !ballOnScreen && balls>0)
        {
            balls--;
            ballOnScreen = true;
            ball = new Ball((int)(player.getX()),
                    (int)(player.getY()),
                    input);
            stage.addActor(ball);
        }
    }

}
