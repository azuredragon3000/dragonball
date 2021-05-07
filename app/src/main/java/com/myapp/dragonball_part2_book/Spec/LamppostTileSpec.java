package com.myapp.dragonball_part2_book.Spec;


import android.graphics.PointF;

import com.myapp.dragonball_part2_book.Spec.GameObjectSpec;

public class LamppostTileSpec extends GameObjectSpec {
    private static final String tag = "Inert Tile";
    private static final String bitmapName = "lamppost";
    private static final int framesOfAnimation = 1;
    private static final float speed = 0f;
    private static final boolean Active = false;
    private static final PointF size = new PointF(1f, 1f);
    private static final String[] components = new String[]{
            "InanimateBlockGraphicsComponent",
            "DecorativeBlockUpdateComponent"};

    public LamppostTileSpec() {
        super(tag, bitmapName, speed, size,
                components, framesOfAnimation,Active);
    }
}
