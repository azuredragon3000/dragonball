package com.myapp.dragonball_part2_book.platform;

import android.graphics.Rect;

import com.myapp.dragonball_part2_book.transform.Transform;

public  class Animator {

    private Rect mSourceRect;
    private int mFrameCount;
    private int mCurrentFrame;
    private long mFrameTicker;
    private int mFramePeriod;
    private int mFrameWidth;

    public Animator(float frameHeight,
                    float frameWidth,
                    int frameCount,
                    int pixelsPerMetre) {

        final int ANIM_FPS = 10;

        this.mCurrentFrame = 0;
        this.mFrameCount = frameCount;
        this.mFrameWidth = (int)frameWidth * pixelsPerMetre;

        /* divide frame for 2 */
        frameHeight = (frameHeight * pixelsPerMetre)/2;

        mSourceRect = new Rect(0, 0,
                this.mFrameWidth,
                (int)frameHeight);

        mFramePeriod = 1000 / ANIM_FPS;
        mFrameTicker = 0L;
    }

    public Rect getFrame(int frame){
        this.mSourceRect.left = frame * mFrameWidth;
        this.mSourceRect.right = this.mSourceRect.left
                + mFrameWidth;

        return mSourceRect;
    }
    public Rect getCurrentFrame(long time, Transform t) {
        if (time > mFrameTicker + mFramePeriod) {
            mFrameTicker = time;
            if(t == null){
                mCurrentFrame++;
            }else if(t.headingRight()){
                mCurrentFrame++;
            }else if(t.headingLeft()){
                mCurrentFrame--;
            }else{
                mCurrentFrame++;
            }

            if (mCurrentFrame >= mFrameCount) {
                mCurrentFrame = 0;
            }else if(mCurrentFrame < 0){
                mCurrentFrame = mFrameCount;
            }
        }

        // Update the left and right values of the source of
        // the next frame on the spritesheet
        this.mSourceRect.left = mCurrentFrame * mFrameWidth;
        this.mSourceRect.right = this.mSourceRect.left
                + mFrameWidth;

        return mSourceRect;
    }
}
