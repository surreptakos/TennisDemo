package com.example.mary.tennisdemo;


import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Sprite {
    // we use float bc we want to maintain the highest accuracy internally, even though we need to
    // convert to int to render the sprite
    private float x;
    private float y;

    private int screenWidth;
    private int screenHeight;

    private Bitmap image;
    private Bitmap shadow;

    private Rect bounds;

    public Sprite(int screenWidth, int screenHeight) {
        this.x = 30;
        this.y = 30;

        this.screenHeight = screenHeight;
        this.screenWidth = screenWidth;
    }

    public void init(Bitmap image, Bitmap shadow) {
        this.image = image;
        this.shadow = shadow;

        bounds = new Rect(0, 0, image.getWidth(), image.getHeight());
    }


    //can't supply canvas to the constructor because we will lock the surface every time we draw,
    // and the canvas will be different every time
    public void draw(Canvas canvas) {
        canvas.drawBitmap(shadow, x, y, null);
        canvas.drawBitmap(image, x, y, null);
    }

    public Rect getRect() {
        return bounds;
    }

    public Rect getScreenRect() {
        Rect rect = new Rect((int) x, (int) y, (int) x + getRect().width(), (int) y + getRect().height());
        return rect;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }

}
