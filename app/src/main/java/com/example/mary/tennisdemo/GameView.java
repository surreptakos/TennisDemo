package com.example.mary.tennisdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

//it's a good idea to separate shadows from the main images
// not naow dammit

public class GameView extends SurfaceView implements SurfaceHolder.Callback {

    private Bitmap button;
    private GameRunner runner;
    private Game game;

    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);

        button = BitmapFactory.decodeResource(getResources(), R.drawable.button);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //onTouchEvent is called on both touch and drag events
        //returning true allows you to 'see' drag events
        //return true when you handle an event and false when you don't
        //returning false will get you the touch event, but it won't, for example, get you drag
        // events -- bc you can't have a drag event without a touch event

        //synchronizing this object will not prevent other portions of code from modifying it.
        SurfaceHolder surfaceHolder = getHolder();

        //locks the canvas so no one else can draw on it, and returns it to us. will return null if
        // it can't lock it
        Canvas canvas = surfaceHolder.lockCanvas();

        if (canvas != null) {
            //fills canvas with particular color
            canvas.drawColor(Color.WHITE);

            //must load bitmap before drawing it (see constructor above)
            canvas.drawBitmap(button, 50, 50, null);

            surfaceHolder.unlockCanvasAndPost(canvas);
        }

        return true;
    }


    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        Log.d("DJG", "created");
        game = new Game(holder, getResources());
        runner = new GameRunner(game);
        runner.start();
    }

    //Sunday

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

                }

            }
        }
    }
}
