package com.myapp.dragonball_part2_book.update;

import android.graphics.PointF;

import com.myapp.dragonball_part2_book.content.gameobject.GameObject;
import com.myapp.dragonball_part2_book.Interface.UpdateComponent;
import com.myapp.dragonball_part2_book.transform.FireBallTransform;
import com.myapp.dragonball_part2_book.transform.PlayerTransform;
import com.myapp.dragonball_part2_book.transform.Transform;

public class CupidArrowUpdateComponent implements UpdateComponent {
    float x = 0; //= location.x;
    float y = 0;//= location.y;
   // PointF fireLocation = null;

    @Override
    public void update(long fps, Transform t, Transform playerTransform, GameObject object) {


      //  FireBallTransform t1 = (FireBallTransform)object.getTransform();
        FireBallTransform t1 =
                (FireBallTransform) t;

        PointF location = t.getLocation();
        PlayerTransform pt = (PlayerTransform) playerTransform;
        PointF playerLocation = playerTransform.getLocation();

        float speed = t.getSpeed();

        if(t1.getTouched()){
            object.setInactive();
            PointF fireLocation = new PointF(-1000, -1000);
            t.setLocation(fireLocation);
        }else {
            if (pt.getFireBall()) {
                object.setActive();
                x += speed / fps;
                PointF fireLocation = new PointF(x, y);
                t.setLocation(fireLocation);
            } else {
                x = location.x+2;
                y = location.y+3;
            }
        }


        t.updateCollider();
    }
}
