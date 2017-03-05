package com.apok.games.ballgame.screens;

import com.apok.games.ballgame.BallGame;
import com.apok.games.ballgame.entities.Ball;
import com.apok.games.ballgame.entities.Boar;
import com.apok.games.ballgame.entities.Obstacle;
import com.apok.games.ballgame.entities.Player;
import com.apok.games.ballgame.ui.ScoreLabel;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import java.util.ArrayList;


class GameplayScreen extends AbstractScreen{

    private Player player;
    private Ball ball;
    private Vector3 input;
    private Boar boar;
    private ScoreLabel scoreLabel;
    private int balls = 15;
    private boolean ballOnScreen = false;
    private ArrayList<Obstacle> obstacles;

    GameplayScreen(BallGame game) {
        super(game);
    }

    @Override
    protected void init() {
        input = new Vector3(0,0,0);
        initBackground();
        initPlayer();
        initBoar();
        initScoreLabelBackground();
        initScoreLabel();
        initObstacles();

    }

    private void initObstacles() {
        obstacles = new ArrayList<Obstacle>();
        obstacles.add(new Obstacle());
        obstacles.add(new Obstacle());
        for(Obstacle obstacle: obstacles)
            stage.addActor(obstacle);
    }

    private void initScoreLabel() {
        scoreLabel = new ScoreLabel();
        scoreLabel.setText("SCORE: "+ game.getScore());
        stage.addActor(scoreLabel);
    }

    private void initScoreLabelBackground() {
        Image scoreLabelBackground = new Image(new Texture("scorelabel.png"));
        scoreLabelBackground.setPosition(10, 10);
        stage.addActor(scoreLabelBackground);
    }

    private void initBoar() {
        boar = new Boar();
        stage.addActor(boar);
    }

    private void initPlayer() {
        player = new Player();
        stage.addActor(player);
    }

    private void initBackground() {
        Image background = new Image(new Texture("menubackground.png"));
        stage.addActor(background);
    }

    public void render(float delta)
    {
        super.render(delta);
        setInput();
        addBall();
        boar.update();
        player.update(input);
        scoreLabel.setText("SCORE: "+ game.getScore());
        updateObstacles();
        stage.act();
        spriteBatch.begin();
        stage.draw();
        spriteBatch.end();
    }

    private void updateObstacles() {
            for(Obstacle obstacle: obstacles)
            {
                obstacle.update();
                if(ballOnScreen && obstacle.collidesWithBall(ball))
                {
                    ballOnScreen = false;
                    ball.remove();
                }
            }
            if(ballOnScreen)
            {
                ballOnScreen = ball.update(boar, game);
                if(!ballOnScreen)
                    game.setScreen(new GameplayScreen(game));
            }


    }

    private void setInput() {
        input.set(Gdx.input.getX(), Gdx.input.getY(), 0);
        camera.unproject(input);
    }

    private void addBall() {
        if(isShootingAllowed())
        {
            balls--;
            ballOnScreen = true;
            ball = new Ball((int)(player.getX()),
                    (int)(player.getY()),
                    input);
            stage.addActor(ball);
        }
    }

    private boolean isShootingAllowed()
    {
        return Gdx.input.isTouched() && input.y > 140 && !ballOnScreen && balls>0 && game.isPlaying();
    }


}
