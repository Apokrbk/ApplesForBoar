package com.apok.games.ballgame.screens;


import com.apok.games.ballgame.BallGame;
import com.apok.games.ballgame.ui.IClickCallback;
import com.apok.games.ballgame.ui.MyFont;
import com.apok.games.ballgame.ui.PlayButton;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Timer;


public class MenuScreen extends AbstractScreen {

    private MyFont myFont;

    public MenuScreen(BallGame game) {
        super(game);
    }

    @Override
    protected void init() {
        myFont = new MyFont();
        Image highscoreLabel = initHighscoreLabel();
        final Image menuBackground = initBackground();
        final PlayButton playButton = initPlayButton();
        addActorsToStage(highscoreLabel, menuBackground, playButton);
    }

    private Image initBackground() {
        return new Image(new Texture("menubackground.png"));
    }

    private Image initHighscoreLabel() {
        Image highscoreLabel = new Image(new Texture("highscore.png"));
        highscoreLabel.setPosition(40,220);
        return highscoreLabel;
    }

    private PlayButton initPlayButton() {
        return new PlayButton(new IClickCallback() {
                @Override
                public void onClick() {
                    for(Actor actor : stage.getActors())
                        actor.remove();
                    game.setScreen(new GameplayScreen(game));
                    Timer.schedule(new Timer.Task() {
                        @Override
                        public void run() {
                            game.setPlaying(true);
                        }
                    }, 3);
                }
            });
    }

    private void addActorsToStage(Image highscoreLabel, Image menuBackground, PlayButton playButton) {
        stage.addActor(menuBackground);
        stage.addActor(playButton);
        stage.addActor(highscoreLabel);
    }

    public void render(float delta)
    {
        super.render(delta);
        spriteBatch.begin();
        stage.draw();
        spriteBatch.end();
        spriteBatch.begin();
        myFont.drawScore(game.getScoreService().getHighscore(), 253, 232, spriteBatch);
        spriteBatch.end();
    }
}