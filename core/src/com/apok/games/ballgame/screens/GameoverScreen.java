package com.apok.games.ballgame.screens;

import com.apok.games.ballgame.BallGame;
import com.apok.games.ballgame.ui.GameoverButton;
import com.apok.games.ballgame.ui.IClickCallback;
import com.apok.games.ballgame.ui.MyFont;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;


class GameoverScreen extends AbstractScreen{

    private MyFont myFont;
    private int score;

    GameoverScreen(BallGame game, int score) {
        super(game);
        this.score = score;
    }

    @Override
    protected void init() {
        myFont = new MyFont();
        Image scoreLabel = initScoreLabel();
        final Image background = new Image(new Texture("menubackground.png"));
        final GameoverButton gameoverButton = initGameoverButton();
        addActorsToStage(scoreLabel, background, gameoverButton);
    }

    private Image initScoreLabel() {
        Image scoreLabel = new Image(new Texture("scorelabel.png"));
        scoreLabel.setPosition(40, 230);
        return scoreLabel;
    }

    private GameoverButton initGameoverButton() {
        return new GameoverButton(new IClickCallback() {
                @Override
                public void onClick() {
                    for(Actor actor : stage.getActors())
                        actor.remove();
                    game.setScreen(new MenuScreen(game));
                }
            });
    }

    private void addActorsToStage(Image scoreLabel, Image background, GameoverButton gameoverButton) {
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
        myFont.drawScore(score, 135, 242, spriteBatch);
        spriteBatch.end();
    }

}
