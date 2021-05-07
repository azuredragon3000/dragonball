package com.myapp.dragonball_part2_book.transform;

import android.graphics.PointF;

public class BackgroundTransform extends Transform {
    private float xClip;
    private boolean reversedFirst = false;

    public BackgroundTransform(float speed,
                               float objectWidth,
                               float objectHeight,
                               PointF startingLocation) {

        super(speed, objectWidth,
                objectHeight,
                startingLocation);
    }

    public boolean getReversedFirst() {
        return reversedFirst;
    }

    public void flipReversedFirst() {
        reversedFirst = !reversedFirst;
    }

    public float getXClip() {
        return xClip;
    }

    public void setXClip(float newXClip) {
        xClip = newXClip;
    }
}
