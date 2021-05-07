package com.myapp.dragonball_part2_book.Interface;

import com.myapp.dragonball_part2_book.content.gameobject.GameObject;
import com.myapp.dragonball_part2_book.transform.Transform;

public interface UpdateComponent {
    // Everything has one of these so it can be updated
    // The player's transform could be left out because it is only needed
    // by the background(to see which way the player is moving)
    // However, if we added enemies at a later date they would likely need
    // to know where the player is and what he is doing.
    // So I left it in rather than create a communication between the
    // background and the player
    void update(long fps, Transform t, Transform playerTransform, GameObject object);
}
