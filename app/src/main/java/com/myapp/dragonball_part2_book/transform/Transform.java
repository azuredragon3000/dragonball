package com.myapp.dragonball_part2_book.transform;

import android.graphics.PointF;
import android.graphics.RectF;

public class Transform {
    RectF mCollider;
    private PointF mLocation;
    private float mSpeed;
    private float mObjectHeight;
    private float mObjectWidth;
    private PointF mStartingPosition;
    private boolean mHeadingUp = false;
    private boolean mHeadingDown = false;
    private boolean mFacingRight = true;
    private boolean mHeadingLeft = false;
    private boolean mHeadingRight = false;

    private boolean giuongcung;
    private boolean thacung;
    private boolean donecung;

    public Transform(float speed, float objectWidth,
                     float objectHeight, PointF startingLocation) {

        mCollider = new RectF();
        mSpeed = speed;
        mObjectHeight = objectHeight;
        mObjectWidth = objectWidth;
        mLocation = startingLocation;

        // This tells movable blocks their starting position
        mStartingPosition = new PointF(mLocation.x, mLocation.y);
    }


    public void updateCollider() {
        mCollider.top = mLocation.y;
        mCollider.left = mLocation.x ;
        mCollider.bottom = (mCollider.top + mObjectHeight);
        mCollider.right = (mCollider.left + mObjectWidth);
    }


    public RectF getCollider() {
        return mCollider;
    }

    public void headUp() {
        mHeadingUp = true;
        mHeadingDown = false;
    }

    public void headDown() {
        mHeadingDown = true;
        mHeadingUp = false;
    }

    public boolean headingUp() {
        return mHeadingUp;
    }

    public boolean headingDown() {
        return mHeadingDown;
    }

    public float getSpeed() {
        return mSpeed;
    }

    public PointF getLocation() {
        return mLocation;
    }

    public void setLocation(PointF location) {
        mLocation = location;
    }
    public PointF getSize() {
        return new PointF((int) mObjectWidth, (int) mObjectHeight);
    }

    public void headRight() {
        mHeadingRight = true;
        mHeadingLeft = false;
        mFacingRight = true;

    }

    public void headLeft() {
        mHeadingLeft = true;
        mHeadingRight = false;
        mFacingRight = false;
    }

    public boolean headingRight() {
        return mHeadingRight;
    }

    public boolean headingLeft() {
        return mHeadingLeft;
    }

    public void stopHorizontal() {
       // mHeadingLeft = false;
      //  mHeadingRight = false;

        mHeadingDown = false;
        mHeadingUp = false;
    }

    public void stopMovingLeft() {
        mHeadingLeft = false;
    }

    public void stopMovingRight() {
        mHeadingRight = false;
    }

    public boolean getFacingRight() {
        return mFacingRight;
    }

    public PointF getStartingPosition(){
        return mStartingPosition;
    }


    public boolean getGiuongcung() {
        return giuongcung;
    }

    public boolean getThaCung() {
        return thacung;
    }


    public void setGiuongCung() {
        giuongcung = true;
    }

    public void setThacung() {
        thacung = true;
    }
}
