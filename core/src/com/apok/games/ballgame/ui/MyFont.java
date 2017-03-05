package com.apok.games.ballgame.ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

/**
 * Created by Apok on 05.03.2017.
 */

public class MyFont {
    private Array<TextureRegion> digits;
    private int digitWidth;

    public MyFont()
    {
        digits = new Array<TextureRegion>();
        TextureRegion region = new TextureRegion(new Texture("font.png"));
        digitWidth = region.getRegionWidth() / 10;
        for(int i=0; i<10; i++)
        {
            digits.add(new TextureRegion(region, i*digitWidth, 0, digitWidth, region.getRegionHeight()));
        }
    }

    public void drawScore(int score, int x, int y, SpriteBatch spriteBatch)
    {
        int hundreds = score/100;
        int dozens = (score - hundreds*100) / 10;
        int unities = (score - hundreds*100 - dozens*10);
        if(hundreds>0)
        {
            spriteBatch.draw(digits.get(hundreds), x,y);
            spriteBatch.draw(digits.get(dozens), x+digitWidth, y);
            spriteBatch.draw(digits.get(unities), x+2*digitWidth, y);
        }
        else if(dozens>0)
        {
            spriteBatch.draw(digits.get(dozens), x, y);
            spriteBatch.draw(digits.get(unities), x+digitWidth, y);
        }
        else
        {
            spriteBatch.draw(digits.get(unities), x, y);
        }
    }
}
