package com.myapp.dragonball_part2_book.specView;

import android.graphics.Point;
import android.graphics.Rect;

import com.myapp.dragonball_part2_book.objectView.PropertyView;

public class ObjectViewQuestionSpec extends ObjectParentViewSpec{
    public ObjectViewQuestionSpec(Point size) { super(size); }


    String[][] getTiles() {

        String[][] tiles= new String[][]{
                {"1", "2", "-", "-", "3", "-", "-", "-", "4", "-", "-"},
                {"-", "-", "-", "2", "-", "-", "3", "-", "-", "-", "4"},
                {"5", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                {"-", "-", "-", "-", "-", "-", "5", "-", "-", "-", "-"},
                {"6", "-", "-", "-", "7", "-", "-", "-", "-", "-", "-"},
                {"-", "-", "6", "-", "-", "-", "7", "-", "-", "-", "-"},
                {"8", "-", "-", "-", "9", "-", "-", "-", "-", "-", "-"},
                {"-", "-", "8", "-", "-", "-", "9", "-", "-", "-", "1"},
        };

        return tiles;
    }

    PropertyView[] getPropertyView() {
        PropertyView[] view;
        /* set up property view here */
        view = new PropertyView[9];

        Rect rect1 = getLayoutView("1");
        Rect rect2 = getLayoutView("2");
        Rect rect3 = getLayoutView("3");
        Rect rect4 = getLayoutView("4");
        Rect rect5 = getLayoutView("5");
        Rect rect6 = getLayoutView("6");
        Rect rect7 = getLayoutView("7");
        Rect rect8 = getLayoutView("8");
        Rect rect9 = getLayoutView("9");

        view[0] = setView(rect1,"background","View");
        view[1] = setView(rect2,"view level","TextView");
        view[2] = setView(rect3,"view point","TextView");
        view[3] = setView(rect4,"button","View");
        view[4] = setView(rect5,"view question","TextView");
        view[5] = setView(rect6,"view option1","TextView");
        view[6] = setView(rect7,"view option2","TextView");
        view[7] = setView(rect8,"view option3","TextView");
        view[8] = setView(rect9,"view option4","TextView");

        return view;
    }
}
