package com.myapp.dragonball_part2_book.specView;

import android.graphics.Point;
import android.graphics.Rect;

import com.myapp.dragonball_part2_book.objectView.PropertyView;

import java.util.HashMap;

public class ObjectViewStartSpec extends ObjectParentViewSpec{
    public ObjectViewStartSpec(Point size) { super(size); }

    String[][] getTiles() {

        String[][] tiles= new String[][]{
                {"1", "-", "-", "-", "-", "-", "-", "-", "-", "6", "-"},
                {"-", "-", "-", "-", "-", "-", "-", "2", "-", "-", "6"},
                {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                {"-", "-", "-", "-", "-", "-", "-", "3", "-", "2", "-"},
                {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                {"-", "-", "-", "-", "-", "-", "-", "4", "-", "3", "-"},
                {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                {"-", "-", "-", "-", "-", "-", "-", "5", "-", "4", "-"},
                {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
                {"-", "-", "-", "-", "-", "-", "-", "-", "-", "5", "-"},
                {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "1"},
        };

        return tiles;
    }

    PropertyView[] getPropertyView() {
        PropertyView[] view;
        int max = 6;
        view = new PropertyView[max];

        HashMap<String, String>
                hm = new HashMap<>();

        hm.put("1", "background8");
        hm.put("2", "buttonbty");
        hm.put("3", "button_gty");
        hm.put("4", "button_tnty");
        hm.put("5", "button_bt");
        hm.put("6", "exit_button");

        int count = 0;
        for(String i: hm.keySet()){
            Rect rect = getLayoutView(i);
            view[count] = setView(rect,hm.get(i),"View");
            count++;
        }

        return view;
    }
}

   /* String[][] tiles= new String[][]{
            {"1", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
            {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
            {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
            {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
            {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
            {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
            {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
            {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
            {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
            {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-"},
            {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "1"},
    };*/