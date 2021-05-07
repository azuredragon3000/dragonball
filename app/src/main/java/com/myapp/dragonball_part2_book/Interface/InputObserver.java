package com.myapp.dragonball_part2_book.Interface;

import android.graphics.Rect;
import android.view.MotionEvent;

import com.myapp.dragonball_part2_book.GameEngine;
import com.myapp.dragonball_part2_book.GameState;

import java.util.ArrayList;

public interface InputObserver {
    // This allows InputObservers to be called by GameEngine to handle input
    void handleInput(MotionEvent event, GameState ge, ArrayList<Rect> buttons);
}
