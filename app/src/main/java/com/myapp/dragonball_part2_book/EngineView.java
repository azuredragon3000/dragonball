package com.myapp.dragonball_part2_book;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;

import com.myapp.dragonball_part2_book.Interface.ChangeView;
import com.myapp.dragonball_part2_book.Interface.EngineBroadcaster;
import com.myapp.dragonball_part2_book.Interface.InputObserverView;
import com.myapp.dragonball_part2_book.Interface.TypeQuestion;
import com.myapp.dragonball_part2_book.input.InputViewCategory;
import com.myapp.dragonball_part2_book.input.InputViewQuestion;
import com.myapp.dragonball_part2_book.input.InputViewStart;
import com.myapp.dragonball_part2_book.multichoice.Question;
import com.myapp.dragonball_part2_book.objectView.Constants;
import com.myapp.dragonball_part2_book.objectView.CustomLayout;
import com.myapp.dragonball_part2_book.objectView.MFactoryView;
import com.myapp.dragonball_part2_book.objectView.ObjectView;
import com.myapp.dragonball_part2_book.specView.ObjectViewCategorySpec;
import com.myapp.dragonball_part2_book.specView.ObjectViewQuestionSpec;
import com.myapp.dragonball_part2_book.specView.ObjectViewStartSpec;

import java.util.ArrayList;

public class EngineView extends View implements EngineBroadcaster, TypeQuestion {

    private ArrayList<ObjectView> mObjectView;
    private MFactoryView mFactoryMView;
    private ArrayList<InputObserverView> inputObservers = new ArrayList();
    private InputViewStart inputViewStart;
    private InputViewCategory mInputCategory;
    private InputViewQuestion mInputQuestion;
    private int stage;

    public EngineView(Context context, Point size, Activity activity, ChangeView view){
        super(context);

        mFactoryMView = new MFactoryView(activity,size);
        inputViewStart = new InputViewStart(this,view);
        mInputCategory = new InputViewCategory(this,view,this);
        mInputQuestion = new InputViewQuestion(this,view);
        Question question = getQuestion();
        mObjectView = new ArrayList<>();

        mObjectView.add(0,mFactoryMView.create(new ObjectViewStartSpec(size), inputViewStart,null));
        mObjectView.add(1,mFactoryMView.create(new ObjectViewCategorySpec(size),mInputCategory,null));
        mObjectView.add(2,mFactoryMView.create(new ObjectViewQuestionSpec(size),mInputQuestion,question));

        //setView(mObjectView.get(0).mLayout);
    }

    public CustomLayout getStartView() {
        stage = Constants.VIEWSTART;
        return mObjectView.get(0).mLayout;
    }

    public CustomLayout getView1() {
        stage = Constants.VIEW1;
        return mObjectView.get(1).mLayout;
    }

    public CustomLayout getView2() {
        stage = Constants.VIEW2;
        return mObjectView.get(2).mLayout;
    }

    

    @Override
    public void addObserver(InputObserverView o) {
        inputObservers.add(o);
    }

    @Override
    public Question PerlQuestion() {
        Question question = new Question();

        question.Question = "Perl";
        question.A ="A";
        question.B ="B";
        question.C ="C";
        question.D ="D";

        return question;
    }

    @Override
    public Question JavaQuestion() {
        Question question = new Question();
        question.Question = "Java";
        question.A ="A";
        question.B ="B";
        question.C ="C";
        question.D ="D";
        return question;
    }

    private Question getQuestion() {
        Question question = new Question();

        question.Question = "begin question";
        question.A = "A";
        question.B = "B";
        question.C = "C";
        question.D = "D";

        return question;
    }


    public ArrayList<InputObserverView> getInput() {
        return inputObservers;
    }

    public int getStage() {
        return stage;
    }
}
