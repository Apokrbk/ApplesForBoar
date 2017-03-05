package com.apok.games.ballgame.screens;

import com.apok.games.ballgame.BallGame;
import com.apok.games.ballgame.entities.Ball;
import com.apok.games.ballgame.entities.Boar;
import com.apok.games.ballgame.entities.Player;
import com.apok.games.ballgame.entities.SetOfObstacles;
import com.apok.games.ballgame.entities.levels.Level1;
import com.apok.games.ballgame.entities.levels.Level2;
import com.apok.games.ballgame.services.SoundService;
import com.apok.games.ballgame.ui.ScoreLabel;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import java.util.Stack;


public class GameplayScreen extends AbstractScreen{

    private Player player;
    private Ball ball;
    private Vector3 input;
    private Boar boar;
    private ScoreLabel scoreLabel;
    private Stack<SetOfObstacles> levels;
    private SoundService soundService;

    GameplayScreen(BallGame game) {
        super(game);
    }

    @Override
    protected void init() {
        input = new Vector3(0,0,0);
        ball = new Ball();
        initBackground();
        initPlayer();
        initBoar();
        initScoreLabelBackground();
        initScoreLabel();
        initLevels();
        soundService = new SoundService();
        soundService.playBackgroundMusic();

    }

    private void initLevels() {
        levels = new Stack<SetOfObstacles>();
        levels.push(new Level2());
        levels.push(new Level1());
        levels.push(new Level2());
        levels.push(new Level1());
        levels.push(new Level2());
        levels.push(new Level1());
        levels.push(new Level2());
        levels.push(new Level1());
        levels.push(new Level2());
        levels.push(new Level1());
        levels.push(new Level2());
        levels.push(new Level1());
        levels.push(new Level2());
        levels.push(new Level1());
        levels.push(new Level2());
        levels.push(new Level1());
        levels.push(new Level2());
        levels.push(new Level1());
        levels.push(new Level2());
        levels.push(new Level1());
        levels.peek().addObstaclesToStage(stage);
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
        levels.peek().updateObstacles(ball);
        boar.update();
        player.update(input);
        if(isBallOnStage())
            ball.update(boar, this);
        scoreLabel.setText("SCORE: "+ game.getScore());
        stage.act();
        spriteBatch.begin();
        stage.draw();
        spriteBatch.end();
    }

    private void setInput() {
        input.set(Gdx.input.getX(), Gdx.input.getY(), 0);
        camera.unproject(input);
    }

    private void addBall() {
        if(isShootingAllowed())
        {
            ball = new Ball((int)(player.getX()),
                    (int)(player.getY()),
                    input);
            stage.addActor(ball);
        }
    }

    private boolean isShootingAllowed()
    {
        return Gdx.input.isTouched() && input.y > 140 && !isBallOnStage() && game.isPlaying();
    }

    private boolean isBallOnStage()
    {
        return !(ball.getStage() == null);
    }

    public BallGame getGame() {
        return game;
    }

    public void changeToNextLevel() {
        soundService.playChrum();
        levels.peek().removeFromStage();
        levels.pop();
        levels.peek().addObstaclesToStage(stage);
    }

}
