package com.example.mary.tennisdemo;


import android.content.res.Resources;
import android.view.SurfaceHolder;

public class Game {
    private SurfaceHolder holder;
    private Resources resources;

    public Game(SurfaceHolder holder, Resources resources) {
        this.holder = holder;
        this.resources = resources;
    }

    //called once the game starts
    public void init() {

    }

    //elapsed = time elapsed since update was last called
    // need this variable to know how far to move the ball/paddle each time update is called
    public void update(long elapsed) {

    }

    public void draw() {

    }
}
