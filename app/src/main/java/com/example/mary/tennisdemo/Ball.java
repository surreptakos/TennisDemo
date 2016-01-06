package com.example.mary.tennisdemo;


import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Log;

import java.util.Random;

public class Ball extends Sprite {

    private static final float V = 0.25f;
    private float vX;
    private float vY;

    public Ball(int screenWidth, int screenHeight) {
        super(screenWidth, screenHeight);
        vX = 0;
        vY = 0;
    }

    public void update(long elapsed) {

        float x = getX();
        float y = getY();

        float dx = vX * elapsed;
        float dy = vY * elapsed;

        Rect screenRect = getScreenRect();

        if (screenRect.left + dx <= 0 || screenRect.right + dx >= getScreenWidth()) {
            vX *= -1;
        }

        if (screenRect.top + dy <= 0 || screenRect.bottom + dy >= getScreenHeight()) {
            vY *= -1;
        }

        x += vX * elapsed;
        y += vY * elapsed;

        Log.d("DJG", "x is " + x);

        setX(x);
        setY(y);

    }

    @Override
    public void init(Bitmap image, Bitmap shadow) {
        super.init(image, shadow);

        setX((getScreenWidth() - getRect().width()) / 2);
        setY((getScreenHeight() - getRect().height()) / 2);

        Random random = new Random();

        float rand = (random.nextFloat() * 2) - 1;
        vX = V * rand;
        vY = V * (float) Math.sqrt((double) (1 - (rand * rand)));
    }
}
