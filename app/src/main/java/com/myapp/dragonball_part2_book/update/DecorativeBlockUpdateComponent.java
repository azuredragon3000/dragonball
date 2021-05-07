package com.myapp.dragonball_part2_book.update;

import com.myapp.dragonball_part2_book.content.gameobject.GameObject;
import com.myapp.dragonball_part2_book.Interface.UpdateComponent;
import com.myapp.dragonball_part2_book.transform.Transform;

public class DecorativeBlockUpdateComponent implements UpdateComponent {
    @Override
    public void update(long fps, Transform t, Transform playerTransform , GameObject object) {
        // Do nothing
        // Not even set a collider
    }
}
