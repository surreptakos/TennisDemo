package com.example.mary.tennisdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

//it's a good idea to separate shadows from the main images

public class GameView extends SurfaceView implements SurfaceHolder.Callback {

    private GameRunner runner;
    private Game game;

    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Log.d("DJG", "here");

        SurfaceHolder holder = getHolder();

        holder.addCallback(this);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //onTouchEvent is called on both touch and drag events
        //returning true allows you to 'see' drag events
        //return true when you handle an event and false when you don't
        //returning false will get you the touch event, but it won't, for example, get you drag
        // events -- bc you can't have a drag event without a touch event

        //recovering from hangover, not enough time

        return true;
    }


    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        Log.d("DJG", "created");
        game = new Game(getWidth(), getHeight(), holder, getResources());
        runner = new GameRunner(game);
        runner.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        Log.d("DJG", "changed");
    }


    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        Log.d("DJG", "destroyed");
        if (runner != null) {
            runner.shutdown();
            // must wait until runner is fully shut down, because the surface has been shut down
            // already & we don't want runner to try to draw on a non-existent surface

            while (runner != null) {
                try {
                    //method that waits for the thread to terminate
                    runner.join();
                    runner = null;
                } catch (InterruptedException e) {
                    Log.d("DJG", "Uh oh spaghettios");

                }

            }
        }
    }
}
