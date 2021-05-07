package com.myapp.dragonball_part2_book.transform;

import android.graphics.PointF;

public class FireBallTransform extends Transform{
    private boolean touched;
    public FireBallTransform(float speed, float objectWidth, float objectHeight, PointF startingLocation) {
        super(speed, objectWidth, objectHeight, startingLocation);
        touched = false;
    }
    public boolean getTouched() {
        return touched;
    }

    public void setTouched() {
        touched = true;
    }
}
