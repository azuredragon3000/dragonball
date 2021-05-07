package com.myapp.dragonball_part2_book.Interface;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;


import com.myapp.dragonball_part2_book.platform.Camera;
import com.myapp.dragonball_part2_book.Spec.GameObjectSpec;
import com.myapp.dragonball_part2_book.transform.Transform;


public interface GraphicsComponent {
    // Added int mPixelsPerMetre to
    // scale the bitmap to the camera
    void initialize(Context c, GameObjectSpec spec,
                    PointF objectSize, int pixelsPerMetre);

    // Updated from the last project
    // to take a reference to a Camera
    void draw(Canvas canvas, Paint paint,
              Transform t, Camera cam);
}
