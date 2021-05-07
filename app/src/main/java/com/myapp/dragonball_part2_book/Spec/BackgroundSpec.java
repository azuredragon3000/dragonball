package com.myapp.dragonball_part2_book.Spec;

import android.graphics.PointF;

public class BackgroundSpec extends GameObjectSpec {
    private static final String tag = "Background";
    private static final String bitmapName = "background6";
    private static final int framesOfAnimation = 1;
    private static final float speed = 3f;
    private static final boolean Active = true;
    private static final PointF size = new PointF(100, 70);
    private static final String[] components = new String [] {
            "BackgroundGraphicsComponent","BackgroundUpdateComponent"};

    public BackgroundSpec() {
        super(tag, bitmapName, speed, size, components, framesOfAnimation,Active);
    }
}
