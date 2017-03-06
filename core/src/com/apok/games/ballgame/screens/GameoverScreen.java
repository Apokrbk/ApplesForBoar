package com.apok.games.ballgame.screens;

import com.apok.games.ballgame.BallGame;
import com.apok.games.ballgame.ui.GameoverButton;
import com.apok.games.ballgame.ui.IClickCallback;
import com.apok.games.ballgame.ui.MyFont;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * Created by Apok on 06.03.2017.
 */

public class GameoverScreen extends AbstractScreen{

    private MyFont myFont;
    private int score;

    GameoverScreen(BallGame game, int score) {
        super(game);
        this.score = score;
    }

    @Override
    protected void init() {
        myFont = new MyFont();
        Image scoreLabel = new Image(new Texture("scorelabel"));
        scoreLabel.setPosition(40, 240);
        final Image background = new Image(new Texture("menubackground.png"));
        final GameoverButton gameoverButton = new GameoverButton(new IClickCallback() {
            @Override
            public void onClick() {
                game.setScreen(new MenuScreen(game));
            }
        });
        stage.addActor(background);
        stage.addActor(gameoverButton);
        stage.addActor(scoreLabel);
    }

    public void render(float delta)
    {
        super.render(delta);
        spriteBatch.begin();
        stage.draw();
        spriteBatch.end();
        spriteBatch.begin();
        myFont.drawScore(score, 253, 232, spriteBatch);
        spriteBatch.end();
    }

}
