package com.myapp.dragonball_part2_book.input;

import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;

import com.myapp.dragonball_part2_book.Interface.ChangeView;
import com.myapp.dragonball_part2_book.Interface.EngineBroadcaster;
import com.myapp.dragonball_part2_book.Interface.InputComponent;
import com.myapp.dragonball_part2_book.Interface.InputObserverView;
import com.myapp.dragonball_part2_book.objectView.Constants;
import com.myapp.dragonball_part2_book.objectView.PropertyView;

public class InputViewQuestion implements InputObserverView, InputComponent {

    private ChangeView changeView;
    private PropertyView[] pViews;
    private Rect[] rects;

    public InputViewQuestion(EngineBroadcaster ger, ChangeView changeView) {
        ger.addObserver(this);
        this.changeView = changeView;
    }

    @Override
    public void setRects(PropertyView[] pViews) {
        this.pViews = pViews;
        rects = new Rect[pViews.length];
        for(int i=0;i<pViews.length;i++){
            rects[i] = pViews[i].position;
        }
    }

    @Override
    public void HandleInput(MotionEvent event, int stage) {
        int i = event.getActionIndex();
        int x = (int) event.getX(i);
        int y = (int) event.getY(i);

        if(stage == Constants.VIEW2) {
            switch (event.getAction() & MotionEvent.ACTION_MASK) {
                case MotionEvent.ACTION_UP:

                    if (rects[3].contains(x, y)) {
                        Log.d("Debugview2", "exit");
                        changeView.setViewStart();
                    }
                    break;
            }
        }
    }
}
