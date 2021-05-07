package com.myapp.dragonball_part2_book;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;

import com.myapp.dragonball_part2_book.Interface.Control;

public class StartView extends View {
    private Paint paint;
    private Rect rect1;
    private Control control;
    public StartView(Control control, Context context) {
        super(context);
        paint = new Paint();
        paint.setColor(Color.YELLOW);
        rect1 = new Rect(100,100,300,300);
        this.control = control;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawRect(rect1,paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int eventType = event.getAction()
                & MotionEvent.ACTION_MASK;
        int i = event.getActionIndex();
        int x = (int) event.getX(i);
        int y = (int) event.getY(i);
        if (eventType == MotionEvent.ACTION_UP ||
                eventType == MotionEvent.ACTION_POINTER_UP) {

            if(rect1.contains(x,y)){
                control.startgame();
            }
        }

        return true;
    }
}
