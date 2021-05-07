package com.myapp.dragonball_part2_book.Spec;

import android.graphics.PointF;

import com.myapp.dragonball_part2_book.Spec.GameObjectSpec;

public class HeartSpec extends GameObjectSpec {

    private static final String tag = "Movable Platform";
    private static final String bitmapName = "heart";
    private static final int framesOfAnimation = 1;
    private static final float speed = 3f;
    private static final boolean Active = true;
    private static final PointF size = new PointF(2, 2);
    private static final String[] components = new String [] {
            "InanimateBlockGraphicsComponent","MovableBlockUpdateComponent"};

    public HeartSpec() {
        super(tag, bitmapName, speed, size, components, framesOfAnimation,Active);
    }
}
