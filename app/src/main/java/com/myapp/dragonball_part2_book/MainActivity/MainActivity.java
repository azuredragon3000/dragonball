package com.myapp.dragonball_part2_book.MainActivity;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.view.MotionEvent;

import com.myapp.dragonball_part2_book.EngineView;
import com.myapp.dragonball_part2_book.GameEngine;
import com.myapp.dragonball_part2_book.Interface.ChangeView;
import com.myapp.dragonball_part2_book.Interface.Control;
import com.myapp.dragonball_part2_book.Interface.EngineBroadcaster;
import com.myapp.dragonball_part2_book.Interface.InputObserverView;
import com.myapp.dragonball_part2_book.Interface.TypeQuestion;
import com.myapp.dragonball_part2_book.StartView;
import com.myapp.dragonball_part2_book.input.InputViewCategory;
import com.myapp.dragonball_part2_book.input.InputViewQuestion;
import com.myapp.dragonball_part2_book.input.InputViewStart;
import com.myapp.dragonball_part2_book.multichoice.Question;
import com.myapp.dragonball_part2_book.objectView.Constants;
import com.myapp.dragonball_part2_book.objectView.MDisplay;
import com.myapp.dragonball_part2_book.objectView.MFactoryView;
import com.myapp.dragonball_part2_book.objectView.ObjectView;
import com.myapp.dragonball_part2_book.specView.ObjectViewCategorySpec;
import com.myapp.dragonball_part2_book.specView.ObjectViewQuestionSpec;
import com.myapp.dragonball_part2_book.specView.ObjectViewStartSpec;

import java.util.ArrayList;

public class MainActivity extends Activity implements Control,ChangeView {

    GameEngine mGameEngine;
    //StartView startview;
    EngineView mEngineView;
    private Point size;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        size = MDisplay.getDisplay(this);


        mGameEngine = new GameEngine(this,size);
        mEngineView = new EngineView(this,size,this,this);
        setViewStart();
        //mGameEngine = new GameEngine(this,size);

        //startview = new StartView(this,this);

    }
    @Override
    public void setView1() {
        startgame();
        //setContentView(mEngineView.getView1());
    }


    @Override
    public void setViewStart() {
        setContentView(mEngineView.getStartView());
    }

    @Override
    public void setView2(String category) {
        setContentView(mEngineView.getView2());
    }

    @Override
    public void exit() {
        finish();
    }


    @Override
    protected void onResume() {
        super.onResume();
    }


    @Override
    protected void onPause() {
        super.onPause();
        mGameEngine.stopThread();
    }

    @Override
    public void startgame() {
        setContentView(mGameEngine);
        mGameEngine.startThread();
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ArrayList<InputObserverView> inputObservers = mEngineView.getInput();
        int stage = mEngineView.getStage();
        for (InputObserverView o : inputObservers) {
            o.HandleInput(motionEvent,stage);
        }
        return true;
    }


}