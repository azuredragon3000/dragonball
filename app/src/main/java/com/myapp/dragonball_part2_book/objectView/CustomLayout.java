package com.myapp.dragonball_part2_book.objectView;

import android.content.Context;
import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup;

public class CustomLayout extends ViewGroup {
    private View[] child;
    private int x,y;
    private PropertyView[] pViews;


    public CustomLayout(Context context, Point size, PropertyView[] pViews) {
        super(context);
        x = size.x;
        y = size.y;
        child = new View[pViews.length];
        this.pViews = pViews;

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        for(int i=0;i<pViews.length;i++){
            child[i] = getChildAt(i);
            setView(child[i],
                    pViews[i].position.left,
                    pViews[i].position.top,
                    pViews[i].position.right,
                    pViews[i].position.bottom
                    );
        }
    }

    private void setView(View child,int l, int t, int r,int b){
        child.layout(l,t,r,b);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(x,y);
    }
}
