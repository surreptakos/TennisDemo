package com.example.mary.tennisdemo;

// the job of this class is to update the surface frame by frame

//we are using Thread instead of async task bc we want to force updates to happen when we want
// them to happen

public class GameRunner extends Thread {

    //this is volatile because threads can sometimes cache variables if they see that its not being
    // updated by itself. Since we may use multiple threads here, we want to make sure each thread
    // knows not to cache this variable
    private volatile boolean running = true;
    private Game game;

    public GameRunner(Game game) {
        this.game = game;
    }

    @Override
    public void run() {
        game.init();

        long lastTime = System.currentTimeMillis();

        // Game loop
        while (running) {
            //draw stuff
            long now = System.currentTimeMillis();
            long elapsed = now - lastTime;

            if (elapsed < 100) {
                game.update(elapsed);
                game.draw();
            }

            lastTime = now;

        }
    }

    public void shutdown() {
        running = false;
    }
}
