package com.myapp.dragonball_part2_book.update;

import com.myapp.dragonball_part2_book.transform.BackgroundTransform;
import com.myapp.dragonball_part2_book.content.gameobject.GameObject;
import com.myapp.dragonball_part2_book.Interface.UpdateComponent;
import com.myapp.dragonball_part2_book.transform.Transform;

public class BackgroundUpdateComponent implements UpdateComponent {
    @Override
    public void update(long fps,
                       Transform t,
                       Transform playerTransform, GameObject object) {

        // Cast to background transform
        BackgroundTransform bt =
                (BackgroundTransform) t;

      //  PlayerTransform pt =
       //         (PlayerTransform) playerTransform;

        float currentXClip = bt.getXClip();

        // When the player is moving right -
        // update currentXClip to the left
        if (playerTransform.headingRight()) {
            currentXClip -= t.getSpeed() / fps;
            bt.setXClip(currentXClip);
        }

        // When the player is heading left -
        // update currentXClip to the right
        else if (playerTransform.headingLeft()) {
            currentXClip += t.getSpeed() / fps;
            bt.setXClip(currentXClip);
        }

        // When currentXClip reduces either
        // extreme left or right
        // Flip the order and reset currentXClip
        if (currentXClip >= t.getSize().x) {
            bt.setXClip(0);
            bt.flipReversedFirst();
        } else if (currentXClip <= 0) {
            bt.setXClip((int) t.getSize().x);
            bt.flipReversedFirst();
        }

    }

}
