package com.myapp.dragonball_part2_book.input;

import android.graphics.Rect;
import android.view.MotionEvent;

import com.myapp.dragonball_part2_book.GameEngine;
import com.myapp.dragonball_part2_book.GameState;
import com.myapp.dragonball_part2_book.Interface.InputObserver;
import com.myapp.dragonball_part2_book.transform.PlayerTransform;
import com.myapp.dragonball_part2_book.transform.Transform;

import java.util.ArrayList;

public class PlayerInputComponent implements InputObserver {
    private Transform mPlayersTransform;
    private PlayerTransform mPlayersPlayerTransform;
    private int fire=0;
    public PlayerInputComponent(GameEngine ger) {
        ger.addObserver(this);
    }

    public void setTransform(Transform transform) {
        mPlayersTransform = transform;
        mPlayersPlayerTransform =
                (PlayerTransform) mPlayersTransform;
    }

    // Required method of InputObserver interface
    // called from the onTouchEvent method
    public void handleInput(MotionEvent event, GameState ge,
                            ArrayList<Rect> buttons) {

        int i = event.getActionIndex();
        int x = (int) event.getX(i);
        int y = (int) event.getY(i);

       // if(!gameState.getPaused()) {
            switch (event.getAction() & MotionEvent.ACTION_MASK) {

                case MotionEvent.ACTION_UP:
                    if (buttons.get(HUD.LEFT).contains(x, y)
                            || buttons.get(HUD.RIGHT)
                            .contains(x, y)) {
                        // Player has released either left or right
                        mPlayersTransform.stopHorizontal();
                    }
                    break;

                case MotionEvent.ACTION_DOWN:
                    if (buttons.get(HUD.LEFT).contains(x, y)) {
                        // Player has pressed left
                       // mPlayersTransform.headLeft();
                        mPlayersTransform.headUp();
                    } else if (buttons.get(HUD.RIGHT).contains(x, y)) {
                        // Player has pressed right
                      //  mPlayersTransform.headRight();
                        mPlayersTransform.headDown();
                    } else if (buttons.get(HUD.JUMP).contains(x, y)) {
                        // Player has released the jump button
                       // mPlayersPlayerTransform.triggerJump();
                       // mPlayersPlayerTransform.setFireBall();
                        if(fire == 0){
                            mPlayersPlayerTransform.setGiuongCung();
                            fire++;
                        }else if(fire == 1) {
                            mPlayersPlayerTransform.setThacung();
                            fire=0;

                            mPlayersPlayerTransform.setFireBall();

                        }
                    }
                    break;

                case MotionEvent.ACTION_POINTER_UP:
                    if (buttons.get(HUD.LEFT).contains(x, y)
                            || buttons.get(HUD.RIGHT).contains(x, y)) {
                        // Player has released either up or down
                        mPlayersTransform.stopHorizontal();
                    }
                    break;

                case MotionEvent.ACTION_POINTER_DOWN:
                    if (buttons.get(HUD.LEFT).contains(x, y)) {
                        // Player has pressed left
                      //  mPlayersTransform.headLeft();
                        mPlayersTransform.headUp();
                    } else if (buttons.get(HUD.RIGHT).contains(x, y)) {
                        // Player has pressed right
                      //  mPlayersTransform.headRight();
                        mPlayersTransform.headDown();
                    } else if (buttons.get(HUD.JUMP).contains(x, y)) {
                        // Player has released the jump button
                       // mPlayersPlayerTransform.triggerJump();

                        if(fire == 0){
                            mPlayersPlayerTransform.setGiuongCung();
                            fire++;
                        }else if(fire == 1) {
                            mPlayersPlayerTransform.setThacung();
                            fire=0;

                            mPlayersPlayerTransform.setFireBall();

                        }
                    }
                    break;
            }
        }

}
