package com.myapp.dragonball_part2_book.objectView;

import android.app.Activity;
import android.graphics.Point;
import android.view.Display;

public class MDisplay {

    public static Point getDisplay(Activity activity){
        Display display = activity.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return size;
    }
}

