package com.myapp.dragonball_part2_book;

import android.content.Context;
import android.graphics.Point;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceView;

import com.myapp.dragonball_part2_book.Interface.EngineController;
import com.myapp.dragonball_part2_book.input.HUD;
import com.myapp.dragonball_part2_book.Interface.GameEngineBroadcaster;
import com.myapp.dragonball_part2_book.Interface.InputObserver;
import com.myapp.dragonball_part2_book.input.UIController;
import com.myapp.dragonball_part2_book.platform.BitmapStore;
import com.myapp.dragonball_part2_book.platform.SoundEngine;

import java.util.concurrent.CopyOnWriteArrayList;

public class GameEngine extends SurfaceView implements Runnable, GameEngineBroadcaster, EngineController {

    private Thread mThread = null;
    private long mFPS;
    private boolean first;

    private GameState mGameState;
    PhysicsEngine mPhysicsEngine;
    HUD mHUD;

    LevelManager mLevelManager;
    Renderer mRenderer;
    UIController mUIController;
    private CopyOnWriteArrayList<InputObserver>
            inputObservers = new CopyOnWriteArrayList();

    public GameEngine(Context context, Point size) {
        super(context);
        // Prepare the bitmap store and sound engine
        BitmapStore bs = BitmapStore.getInstance(context);
        SoundEngine se = SoundEngine.getInstance(context);
        first = true;
        // Initialize all the significant classes
        // that make the engine work
        mHUD = new HUD(context, size);
        mGameState = new GameState(this, context);
        mUIController = new UIController(this, size);
        mPhysicsEngine = new PhysicsEngine();
        mRenderer = new Renderer(this, size);
        mLevelManager = new LevelManager(context, this,mRenderer.getPixelsPerMetre());

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        for (InputObserver o : inputObservers) {
            o.handleInput(event,mGameState,
                    mHUD.getControls());
        }
        return true;
    }

    @Override
    public void run() {
        while(mGameState.getThreadRunning()) {
            long frameStartTime = System.currentTimeMillis();

            if (!mGameState.getPaused()) {
                mPhysicsEngine.update(mFPS, mLevelManager.getGameObjects());
            }

            mRenderer.draw(mLevelManager.getGameObjects(),mGameState,
                    mHUD);

            long timeThisFrame = System.currentTimeMillis()
                    - frameStartTime;

            if (timeThisFrame >= 1) {
                final int MILLIS_IN_SECOND = 1000;
                mFPS = MILLIS_IN_SECOND / timeThisFrame;
            }
        }
    }

    @Override
    public void addObserver(InputObserver o) {
        inputObservers.add(o);
    }

    public void stopThread() {
        mGameState.stopEverything();
        mGameState.stopThread();
        try {
            mThread.join();
        } catch (InterruptedException e) {
            Log.e("Exception",
                    "stopThread()" + e.getMessage());
        }
    }

    public void startThread() {

        mGameState.startThread();
        mThread = new Thread(this);
        mThread.start();
    }

    public void startNewGame() {
        mThread = new Thread(this);
        inputObservers.clear();
        mUIController.addObserver(this);
        mLevelManager.setCurrentLevel("green");
        mLevelManager.buildGameObjects();
    }
}
