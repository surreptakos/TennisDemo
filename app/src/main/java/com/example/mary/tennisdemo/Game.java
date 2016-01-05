package com.example.mary.tennisdemo;


import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.SurfaceHolder;

public class Game {
    private SurfaceHolder holder;
    private Resources resources;

    private Ball ball;
    private Bat player;
    private Bat opponent;


    public Game(int screenWidth, int screenHeight, SurfaceHolder holder, Resources resources) {
        this.holder = holder;
        this.resources = resources;

        ball = new Ball(screenWidth, screenHeight);
        player = new Bat(screenWidth, screenHeight, Bat.Position.LEFT);
        opponent = new Bat(screenWidth, screenHeight, Bat.Position.RIGHT);
    }

    //called once the game starts
    public void init() {
        Bitmap ballImage = BitmapFactory.decodeResource(resources, R.drawable.button);
        Bitmap ballShadowImage = BitmapFactory.decodeResource(resources, R.drawable.buttonshadow);

        Bitmap batImage = BitmapFactory.decodeResource(resources, R.drawable.bat);
        Bitmap batShadowImage = BitmapFactory.decodeResource(resources, R.drawable.batshadow);


        ball.init(ballImage, ballShadowImage);
        player.init(batImage, batShadowImage);
        opponent.init(batImage, batShadowImage);

    }

    //elapsed = time elapsed since update was last called
    // need this variable to know how far to move the ball/paddle each time update is called
    public void update(long elapsed) {
        ball.update(elapsed);
    }

    public void draw() {
        Canvas canvas = holder.lockCanvas();

        if (canvas != null) {
            canvas.drawColor(Color.WHITE);
            ball.draw(canvas);
            player.draw(canvas);
            opponent.draw(canvas);

            holder.unlockCanvasAndPost(canvas);
        }


    }
}
