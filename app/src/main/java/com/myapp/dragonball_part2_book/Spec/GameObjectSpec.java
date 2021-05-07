package com.myapp.dragonball_part2_book.Spec;

import android.graphics.PointF;

public class GameObjectSpec {
    private String mTag;
    private String mBitmapName;
    private float mSpeed;
    private PointF mSize;
    private String[] mComponents;
    private int mFramesAnimation;
    private boolean mActive;

    GameObjectSpec(String tag,
                   String bitmapName,
                   float speed,
                   PointF size,
                   String[] components,
                   int framesAnimation ,boolean Active){

        mTag = tag;
        mBitmapName = bitmapName;
        mSpeed = speed;
        mSize = size;
        mComponents = components;
        mFramesAnimation = framesAnimation;
        mActive = Active;
    }

    public int getNumFrames(){
        return mFramesAnimation;
    }

    public String getTag(){
        return mTag;
    }

    public String getBitmapName(){
        return mBitmapName;
    }

    public float getSpeed(){
        return mSpeed;
    }

    public PointF getSize(){
        return mSize;
    }
    public boolean getActive(){
        return mActive;
    }

    public String[] getComponents(){
        return mComponents;
    }
}
