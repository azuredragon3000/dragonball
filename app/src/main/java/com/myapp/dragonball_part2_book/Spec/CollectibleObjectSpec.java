package com.myapp.dragonball_part2_book.Spec;

import android.app.Activity;
import android.graphics.PointF;

import com.myapp.dragonball_part2_book.Spec.GameObjectSpec;

public class CollectibleObjectSpec extends GameObjectSpec {
    private static final String tag = "Collectible";
    private static final String bitmapName = "coin";
    private static final int framesOfAnimation = 1;
    private static final float speed = 0f;
    private static final boolean Active = true;
    private static final PointF size = new PointF(1f, 1f);
    private static final String[] components = new String [] {
            "InanimateBlockGraphicsComponent",
            "InanimateBlockUpdateComponent"};

    public CollectibleObjectSpec() {
        super(tag, bitmapName, speed, size,
                components, framesOfAnimation, Active);
    }
}
