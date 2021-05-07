package com.myapp.dragonball_part2_book.input;

import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;

import com.myapp.dragonball_part2_book.Interface.ChangeView;
import com.myapp.dragonball_part2_book.Interface.EngineBroadcaster;
import com.myapp.dragonball_part2_book.Interface.EngineController;
import com.myapp.dragonball_part2_book.Interface.InputComponent;
import com.myapp.dragonball_part2_book.Interface.InputObserverView;
import com.myapp.dragonball_part2_book.Interface.TypeQuestion;
import com.myapp.dragonball_part2_book.objectView.Constants;
import com.myapp.dragonball_part2_book.objectView.PropertyView;

public class InputViewCategory implements InputObserverView, InputComponent {
    private ChangeView changeView;
    private TypeQuestion question;
    PropertyView[] pViews;
    private Rect[] rects;

    public InputViewCategory(EngineBroadcaster ger, ChangeView changeView, TypeQuestion question){
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

        if(stage == Constants.VIEW1) {
            switch (event.getAction() & MotionEvent.ACTION_MASK) {
                case MotionEvent.ACTION_UP:

                    if (rects[1].contains(x, y)) {
                        Log.d("Debugview1", "java");
                        changeView.setView2("Java");
                    }

                    if (rects[2].contains(x, y)) {
                        Log.d("Debugview1", "perl");
                        changeView.setView2("Perl");
                    }

                    if (rects[3].contains(x, y)) {
                        Log.d("Debugview1", "thoat");
                        changeView.setViewStart();
                    }

                    break;
            }
        }
    }
}
