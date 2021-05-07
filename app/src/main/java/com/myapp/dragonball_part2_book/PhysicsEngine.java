package com.myapp.dragonball_part2_book;

import android.graphics.PointF;
import android.graphics.RectF;

import com.myapp.dragonball_part2_book.content.gameobject.GameObject;
import com.myapp.dragonball_part2_book.platform.SoundEngine;
import com.myapp.dragonball_part2_book.transform.FireBallTransform;
import com.myapp.dragonball_part2_book.transform.PlayerTransform;
import com.myapp.dragonball_part2_book.transform.Transform;

import java.util.ArrayList;

public class PhysicsEngine {

    void update(long fps, ArrayList<GameObject> objects) {
        for (GameObject object : objects) {
            object.update(fps,
                    objects.get(LevelManager.PLAYER_INDEX)
                            .getTransform());
        }

        detectCollisions(objects);
    }

    private void detectCollisions(ArrayList<GameObject> objects) {
        // More code here soon
        boolean collisionOccurred = false;

        // Something collides with some part of
        // the player most frames
        // so lets make some handy references
        // Get a reference to the players position
        // as we will probably need to update it
        Transform playersTransform =
                objects.get(LevelManager.PLAYER_INDEX)
                        .getTransform();

        FireBallTransform fireTransform =
                (FireBallTransform)objects.get(LevelManager.FIREBALL_INDEX)
                        .getTransform();

        PlayerTransform playersPlayerTransform =
                (PlayerTransform) playersTransform;

        // Get the players extra colliders
        // from the cast object
        ArrayList<RectF> playerColliders =
                playersPlayerTransform.getColliders();

        PointF playersLocation =
                playersTransform.getLocation();

        for (GameObject go : objects) {
            // Just need to check player collisions
            // with everything else
            if(go.checkActive()){
                if (go.getTag().equals("Movable Platform")) {

                        if (RectF.intersects(go.getTransform().getCollider(), fireTransform.getCollider())) {
                            switch (go.getTag()) {
                                case "Movable Platform":// Feet
                                    SoundEngine.playJump();
                                    // Switch off coin
                                    go.setInactive();
                                    fireTransform.setTouched();
                                    break;
                                default:
                                    break;
                            }
                        }
                }
            }

            if (go.checkActive()) {
                // Object is active so check for collision
                // with player - anywhere at all
                if (RectF.intersects(go.getTransform()
                                .getCollider(),
                        playersTransform.getCollider())) {

                    // A collision of some kind has occurred
                    // so lets dig a little deeper
                    collisionOccurred = true;
                    // Get a reference to the current (being tested)
                    // object's transform and location
                    Transform testedTransform = go.getTransform();
                    PointF testedLocation = testedTransform.getLocation();
                    // Don't check the player against itself
                    if (objects.indexOf(go) != LevelManager.PLAYER_INDEX) {
                        // Where was the player hit?
                        for (int i = 0; i < playerColliders.size(); i++) {
                            if (RectF.intersects(testedTransform.getCollider(),
                                    playerColliders.get(i))) {

                                // React to the collision based on the
                                // body part and object type
                                switch (go.getTag() + " with " + "" + i) {
                                    // Test feet first to avoid the
                                    // player sinking in to a tile
                                    // and unnecessarily triggering
                                    // right and left as well
                                    case "Movable Platform with 0":// Feet
                                        playersPlayerTransform.grounded();
                                        playersLocation.y =
                                                (testedTransform.getLocation().y)
                                                        - (playersTransform.getSize().y);

                                        break;

                                    case "Collectible with 2":// Right
                                        SoundEngine.playPlayerMain();
                                        // Switch off coin
                                        go.setInactive();
                                        // Tell the game state a coin has been found
                                       // gs.coinCollected();
                                        break;

                                    case "ground with 0":// Feet
                                        playersPlayerTransform.grounded();
                                        playersLocation.y =
                                                (testedTransform.getLocation().y)
                                                        - (playersTransform.getSize().y);
                                        break;



                                    case "ground with 1":// Head
                                        // Just update the player to a suitable height
                                        // but allow any jumps to continue
                                        playersLocation.y = testedLocation.y
                                                + testedTransform.getSize().y;

                                        playersPlayerTransform.triggerBumpedHead();
                                        break;

                                    case "ground with 2":// Right
                                        // Stop the player moving right
                                        playersTransform.stopMovingRight();
                                        // Move the player to the left of the tile
                                        playersLocation.x = (testedTransform
                                                .getLocation().x)
                                                - playersTransform.getSize().x;
                                        break;
                                    case "ground with 3":// Left
                                        playersTransform.stopMovingLeft();
                                        // Moiiki
                                        playersLocation.x =
                                                testedLocation.x
                                                        + testedTransform.getSize().x;
                                        break;
                                    default:

                                        break;
                                }
                            }
                        }
                    }
                }
            }
        }

        if (!collisionOccurred) {
            // No connection with main player collider so not grounded
            playersPlayerTransform.notGrounded();

        }
    }
}
