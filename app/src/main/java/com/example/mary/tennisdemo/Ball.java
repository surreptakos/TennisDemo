package com.example.mary.tennisdemo;


import android.graphics.Rect;
import android.util.Log;

public class Ball extends Sprite {

    private float vX;
    private float vY;

    public Ball(int screenWidth, int screenHeight) {
        super(screenWidth, screenHeight);
        vX = 0.05f;
        vY = 0.05f;
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
}
