package com.myapp.dragonball_part2_book.input;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.MotionEvent;

import com.myapp.dragonball_part2_book.GameEngine;
import com.myapp.dragonball_part2_book.GameState;
import com.myapp.dragonball_part2_book.Interface.GameEngineBroadcaster;
import com.myapp.dragonball_part2_book.Interface.InputObserver;

import java.util.ArrayList;

public class UIController implements InputObserver {

    private boolean initialPress = false;
    public UIController(GameEngineBroadcaster b, Point size) {
        // Add as an observer

        addObserver(b);


    }

    // Need to add observer each time a new game is started and the game objects are rebuilt
    // and the observer list is cleared. This method allows us to re-add an observer for this
    // Rather than just add it in the constructor.
    // The Player controller doesn't need it because a new object is created each level
    public void addObserver(GameEngineBroadcaster b) {
        b.addObserver(this);
    }

    @Override
    public void handleInput(MotionEvent event, GameState gameState, ArrayList<Rect> buttons) {

        int i = event.getActionIndex();
        int x = (int) event.getX(i);

        int eventType = event.getAction()
                & MotionEvent.ACTION_MASK;

        if (eventType == MotionEvent.ACTION_UP ||
                eventType == MotionEvent.ACTION_POINTER_UP) {

            // If game is over start a new game
            if (gameState.getGameOver() && initialPress) {

                gameState.startNewGame();


            }

            initialPress = !initialPress;
        }
    }
}
