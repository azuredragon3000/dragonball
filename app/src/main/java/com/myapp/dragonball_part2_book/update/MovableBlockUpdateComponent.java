package com.myapp.dragonball_part2_book.update;

import android.graphics.PointF;

import com.myapp.dragonball_part2_book.content.gameobject.GameObject;
import com.myapp.dragonball_part2_book.Interface.UpdateComponent;
import com.myapp.dragonball_part2_book.transform.Transform;

public class MovableBlockUpdateComponent implements UpdateComponent {

    @Override
    public void update(long fps,
                       Transform t,
                       Transform playerTransform, GameObject object) {

        PointF location = t.getLocation();
        if (t.headingUp()) {
            location.y -= t.getSpeed() / fps;
        } else if (t.headingDown()) {
            location.y += t.getSpeed() / fps;
        } else {
            // Must be first update of the game
            // so start with going down
            t.headUp();
        }

        // Check if the platform needs
        // to change direction
        if (t.headingDown() && location.y >=
                t.getStartingPosition().y) {
            // Back at the start
            t.headUp();
        } else if (t.headingUp() && location.y <=
                (t.getStartingPosition().y
                        - t.getSize().y * 10)) {
            // Moved ten times the height downwards
            t.headDown();
        }

        // Update the colliders with the new position
        t.updateCollider();
    }
}
