package com.myapp.dragonball_part2_book.objectView;

import android.app.Activity;
import android.graphics.Point;

import com.myapp.dragonball_part2_book.Interface.InputComponent;
import com.myapp.dragonball_part2_book.multichoice.Question;
import com.myapp.dragonball_part2_book.specView.ObjectParentViewSpec;

public class MFactoryView {
    Activity activity;
    Point size;

    public MFactoryView(Activity activity, Point size){
        this.activity = activity;
        this.size = size;
    }

    public ObjectView create(ObjectParentViewSpec spec, InputComponent input, Question question){
        ObjectView objectView = new ObjectView(activity,size,question);
        objectView.setpViews(spec.getView());
        objectView.setInput(input);
        objectView.combine();
        return objectView;
    }
}
