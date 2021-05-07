package com.myapp.dragonball_part2_book.update;

import com.myapp.dragonball_part2_book.content.gameobject.GameObject;
import com.myapp.dragonball_part2_book.Interface.UpdateComponent;
import com.myapp.dragonball_part2_book.transform.Transform;

public class InanimateBlockUpdateComponent implements UpdateComponent {
    private boolean mColliderNotSet = true;

    @Override
    public void update(long fps,
                       Transform t,
                       Transform playerTransform, GameObject object) {

        // An alternative would be to update
        // the collider just once when it spawns.
        // But this would require spawn components
        // - More code but a bit faster
        if(mColliderNotSet) {
            // Only need to set the collider
            // once because it will never move
            t.updateCollider();
            mColliderNotSet = false;
        }
    }
}
