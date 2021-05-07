package com.myapp.dragonball_part2_book.Interface;

import android.view.MotionEvent;

public interface InputObserverView {
    void HandleInput(MotionEvent event, int stage);
}
