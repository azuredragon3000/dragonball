package com.myapp.dragonball_part2_book.input;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;

import com.myapp.dragonball_part2_book.platform.BitmapStore;

import java.util.ArrayList;

public class HUD {
    private int mScreenHeight;
    private int mScreenWidth;
    static int LEFT = 0;
    static int RIGHT = 1;
    static int JUMP = 2;
    static int TEST = 3;
    private Bitmap b_up;
    private Bitmap b_down;

    private ArrayList<Rect> mControls;
    public HUD(Context context, Point size){
        mScreenHeight = size.y;
        mScreenWidth = size.x;

        prepareControls(context,"up","down");
    }

    private void prepareControls(Context context, String up, String down) {
        int buttonWidth = mScreenWidth / 14;
        int buttonHeight = mScreenHeight / 12;
        int buttonPadding = mScreenWidth / 90;


        Rect left = new Rect(
                buttonPadding,
                mScreenHeight - buttonHeight - buttonPadding,
                buttonWidth + buttonPadding,
                mScreenHeight - buttonPadding);

        Rect right = new Rect(
                (buttonPadding * 2) + buttonWidth,
                mScreenHeight - buttonHeight - buttonPadding,
                (buttonPadding * 2) + (buttonWidth * 2),
                mScreenHeight - buttonPadding);

        Rect jump = new Rect(mScreenWidth - buttonPadding - buttonWidth,
                mScreenHeight - buttonHeight - buttonPadding,
                mScreenWidth - buttonPadding,
                mScreenHeight - buttonPadding);


        Rect test = new Rect(mScreenWidth - buttonPadding*2 - buttonWidth*2,
                mScreenHeight - buttonHeight - buttonPadding,
                mScreenWidth - buttonPadding*2 -buttonWidth,
                mScreenHeight - buttonPadding);

        BitmapStore.addBitmap(context,
                up,
                new PointF(buttonWidth, buttonHeight),
                1, false);

        BitmapStore.addBitmap(context,
                down,
                new PointF(buttonWidth, buttonHeight),
                1, false);

        mControls = new ArrayList<>();
        mControls.add(LEFT,left);
        mControls.add(RIGHT,right);
        mControls.add(JUMP, jump);
        mControls.add(TEST, test);

        b_up = BitmapStore.getBitmap(down);
        b_down = BitmapStore.getBitmap(up);
    }
    private void drawControls(Canvas c, Paint p){
        p.setColor(Color.argb(100,255,255,255));

        //for(Rect r : mControls){
           // if()
           // c.drawRect(mControls.get(LEFT).left, r.top, r.right, r.bottom, p);

        c.drawBitmap(b_up,null,(mControls.get(LEFT)),p);
        c.drawBitmap(b_down,null,(mControls.get(RIGHT)),p);
        c.drawRect(mControls.get(JUMP).left, mControls.get(JUMP).top, mControls.get(JUMP).right, mControls.get(JUMP).bottom, p);
      //  c.drawRect(mControls.get(LEFT).left, r.top, r.right, r.bottom, p);
        //}

        // Set the colors back
        p.setColor(Color.argb(255,255,255,255));
    }
    public void draw(Canvas c, Paint p){
        drawControls(c, p);
    }

    public ArrayList<Rect> getControls(){
        return mControls;
    }

}
