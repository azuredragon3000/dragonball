package com.myapp.dragonball_part2_book.Spec;

import android.graphics.PointF;

import com.myapp.dragonball_part2_book.Spec.GameObjectSpec;

public class PlayerSpec extends GameObjectSpec {
    private static final String tag = "Player";
    private static final String bitmapName = "player2";
    private static final int framesOfAnimation = 3;
    private static final float speed = 10f;
    private static final boolean Active = true;
    private static final PointF size = new PointF(5f, 5f);
    private static final String[] components = new String [] {
            "PlayerInputComponent",
            "PlayerUpdateComponent",
            "AnimatedGraphicsComponent"};

    public PlayerSpec() {
        super(tag, bitmapName, speed,
                size, components, framesOfAnimation,Active);
    }
}
