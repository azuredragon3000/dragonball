package com.myapp.dragonball_part2_book.specView;

import android.graphics.Point;
import android.graphics.Rect;

import com.myapp.dragonball_part2_book.objectView.PropertyView;

import java.util.ArrayList;

public class ObjectViewCategorySpec extends ObjectParentViewSpec{

    public ObjectViewCategorySpec(Point size) {
        super(size);
    }

     String[][] getTiles() {

        String[][] tiles= new String[][]{
                {"1", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                {"-", "-", "-", "-", "-", "-", "2", "-", "-", "-", "-"},
                {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                {"-", "-", "-", "-", "-", "-", "-", "-", "-", "2", "-"},
                {"-", "-", "-", "-", "-", "-", "3", "-", "-", "-", "-"},
                {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                {"-", "-", "-", "-", "-", "-", "-", "-", "-", "3", "-"},
                {"-", "-", "-", "-", "-", "-", "4", "-", "-", "-", "-"},
                {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                {"-", "-", "-", "-", "-", "-", "-", "-", "-", "4", "-"},
                {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "1"},
        };

        return tiles;
    }

    PropertyView[] getPropertyView() {
        PropertyView[] view;

        /* set up property view here */
        view = new PropertyView[4];

        Rect rect1 = getLayoutView("1");
        Rect rect2 = getLayoutView("2");
        Rect rect3 = getLayoutView("3");
        Rect rect4 = getLayoutView("4");

        view[0] = setView(rect1,"background","View");
        view[1] = setView(rect2,"button","View");
        view[2] = setView(rect3,"button","View");
        view[3] = setView(rect4,"button","View");

        return view;
    }



}
