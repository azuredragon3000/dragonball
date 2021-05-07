package com.myapp.dragonball_part2_book.content.gameobject;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.Log;

import com.myapp.dragonball_part2_book.Interface.GraphicsComponent;
import com.myapp.dragonball_part2_book.Interface.UpdateComponent;
import com.myapp.dragonball_part2_book.Spec.GameObjectSpec;
import com.myapp.dragonball_part2_book.input.PlayerInputComponent;
import com.myapp.dragonball_part2_book.platform.Camera;
import com.myapp.dragonball_part2_book.transform.Transform;

public class GameObject {

    private Transform mTransform;
    private boolean mActive;// = true;
    private String mTag;

    private GraphicsComponent mGraphicsComponent;
    private UpdateComponent mUpdateComponent;

    public void setGraphics(GraphicsComponent g,
                            Context c,
                            GameObjectSpec spec,
                            PointF objectSize,
                            int pixelsPerMetre, boolean Active) {

        mGraphicsComponent = g;
        mActive = Active;
        g.initialize(c, spec, objectSize, pixelsPerMetre);
    }

    public void setMovement(UpdateComponent m) {
        mUpdateComponent = m;
    }

    public void setPlayerInputTransform(PlayerInputComponent s) {
        s.setTransform(mTransform);
    }


    public void setTransform(Transform t) {
        mTransform = t;
    }

    public void draw(Canvas canvas, Paint paint, Camera cam) {
        try {
            mGraphicsComponent.draw(canvas,
                    paint,
                    mTransform, cam);
        }catch(NullPointerException e){
            Log.d("Cuong",this.mTag);
        }
    }

    public void update(long fps, Transform playerTransform) {
        mUpdateComponent.update(fps,
                mTransform,
                playerTransform,this);
    }

    public boolean checkActive() {
        return mActive;
    }

    public String getTag() {
        return mTag;
    }

    public void setInactive() {
        mActive = false;
    }

    public Transform getTransform() {
        return mTransform;
    }

    public void setTag(String tag) {
        mTag = tag;
    }

    public void setActive() {
        mActive = true;
    }
}
