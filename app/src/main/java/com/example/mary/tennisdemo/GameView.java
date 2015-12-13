package com.example.mary.tennisdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

//it's a good idea to separate shadows from the main images


public class GameView extends SurfaceView {

    private Bitmap button;

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
}
