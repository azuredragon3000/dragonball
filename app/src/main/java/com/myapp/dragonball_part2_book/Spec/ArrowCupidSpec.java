package com.myapp.dragonball_part2_book.Spec;

import android.graphics.PointF;

import com.myapp.dragonball_part2_book.Spec.GameObjectSpec;

public class ArrowCupidSpec extends GameObjectSpec {
    private static final String tag = "Fire";
    private static final String bitmapName = "arrow_cupid";
    private static final int framesOfAnimation = 1;
    private static final float speed = 5f;
    private static final boolean Active = false;
    private static final PointF size = new PointF(4f, 1f);
    private static final String[] components = new String [] {
            "InanimateBlockGraphicsComponent",
            "FireBallUpdateComponent"};

    public ArrowCupidSpec() {
        super(tag, bitmapName, speed, size,
                components, framesOfAnimation,Active);
    }
}
