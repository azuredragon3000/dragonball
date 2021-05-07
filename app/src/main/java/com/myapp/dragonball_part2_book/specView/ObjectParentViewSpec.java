package com.myapp.dragonball_part2_book.specView;

import android.graphics.Point;
import android.graphics.Rect;

import com.myapp.dragonball_part2_book.objectView.PropertyView;

import java.util.ArrayList;

public abstract class ObjectParentViewSpec {

    PropertyView[] view; int x,y;
    private int sizex,sizey;
    ObjectParentViewSpec(Point size){
        x = size.x;
        y = size.y;
        view = getPropertyView();
        sizex = x/10;
        sizey = y/10;
    }

    public PropertyView[] getView() {
        return view;
    }

    abstract PropertyView[] getPropertyView();

    Rect getRect(int l, int t, int r, int b) {
        int temp_l,temp_t,temp_r,temp_b;

        temp_l = (l*x)/10;
        temp_t = (t*y)/10;
        temp_r = (r*x)/10;
        temp_b = (b*y)/10;
        Rect Rtemp = new Rect(temp_l,temp_t,temp_r,temp_b);

        return Rtemp;
    }

    void setUpView(PropertyView propertyView, String background, String view, int i1, int i2, int i3, int i4) {
        Rect Rtemp;
        propertyView.bg = background;
        propertyView.typeView = view;
        Rtemp = getRect(i1,i2,i3,i4);
        propertyView.position = new Rect(Rtemp);
        //propertyView.question = question;
    }

     PropertyView setView(Rect rect, String str, String v) {
        PropertyView view;
        view = new PropertyView();
        setUpView(view,str,
                v,rect.left,rect.top,rect.right,rect.bottom);
        return view;
    }

     Rect getLayoutView(String t) {
        ArrayList<Point> rect = new ArrayList<>();
        Rect newRect;
        String[][] tiles = getTiles();
        for(int row = 0; row < 11; row++ ) {
            for (int column = 0; column < 11; column++) {
                String str = tiles[row][column];
                if(str.equals(t)) {
                    rect.add(new Point(column, row));
                }
            }
        }
        if((rect.size() == 1)){
            newRect = new Rect(rect.get(0).x,rect.get(0).y,rect.get(0).x+(10),rect.get(0).y+(10));
        }else{
            newRect = new Rect(rect.get(0).x,rect.get(0).y,rect.get(1).x,rect.get(1).y);
        }

        return newRect;
    }

     abstract String[][] getTiles();
}
