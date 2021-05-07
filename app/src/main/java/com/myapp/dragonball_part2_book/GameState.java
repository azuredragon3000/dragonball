package com.myapp.dragonball_part2_book;

import android.content.Context;

import com.myapp.dragonball_part2_book.Interface.EngineController;
import com.myapp.dragonball_part2_book.platform.SoundEngine;

public class GameState {
    private static volatile boolean mThreadRunning = false;
    private static volatile boolean mPaused = true;
    private static volatile boolean mGameOver = true;
    private static volatile boolean mDrawing = false;
    private long startTimeInMillis;
    private EngineController engineController;
    GameState(EngineController gs, Context context){
        engineController = gs;
    }

    public void startNewGame() {
        // Don't want to be handling objects while
        // clearing ArrayList and filling it up again
        stopEverything();
        engineController.startNewGame();
        startEverything();
        startTimeInMillis = System.currentTimeMillis();
    }

    void death() {
        stopEverything();
        SoundEngine.playPlayerBurn();
    }

    void stopEverything() {// Except the thread
        mPaused = true;
        mGameOver = true;
        mDrawing = false;
    }

    private void startEverything() {
        mPaused = false;
        mGameOver = false;
        mDrawing = true;
    }
    void stopThread() {
        mThreadRunning = false;
    }

    boolean getThreadRunning() {
        return mThreadRunning;
    }

    void startThread() {
        mThreadRunning = true;
    }

    boolean getDrawing() {
        return mDrawing;
    }

    boolean getPaused() {
        return mPaused;
    }

    public boolean getGameOver() {
        return mGameOver;
    }
}
