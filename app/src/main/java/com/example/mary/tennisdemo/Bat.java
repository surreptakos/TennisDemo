package com.example.mary.tennisdemo;

import android.graphics.Bitmap;

public class Bat extends Sprite {

    private static final int margin = 20;
    private Position position;

    public Bat(int screenWidth, int screenHeight, Position position) {
        super(screenWidth, screenHeight);

        this.position = position;
    }

    @Override
    public void init(Bitmap image, Bitmap shadow) {
        super.init(image, shadow);

        setY((getScreenHeight() - getRect().height()) / 2);

        if (position == Position.LEFT) {
            setX(margin);
        } else if (position == Position.RIGHT) {
            setX(getScreenWidth() - margin - getRect().width());
        }

    }

    public enum Position {
        LEFT, RIGHT
    }
}
