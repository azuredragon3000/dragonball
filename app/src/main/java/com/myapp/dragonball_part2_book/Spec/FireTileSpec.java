package com.myapp.dragonball_part2_book.Spec;


import android.graphics.PointF;

public class FireTileSpec extends GameObjectSpec {
    private static final String tag = "ground";
    private static final String bitmapName = "arrow_cupid";
    private static final int framesOfAnimation = 3;
    private static final float speed = 0f;
    private static final boolean Active = true;
    private static final PointF size = new PointF(1f, 1f);
    private static final String[] components = new String[]{
            "AnimatedGraphics2Component",
            "InanimateBlockUpdateComponent"};

    public FireTileSpec() {
        super(tag, bitmapName, speed, size,
                components, framesOfAnimation,Active);
    }
}
