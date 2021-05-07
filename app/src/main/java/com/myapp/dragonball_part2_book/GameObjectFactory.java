package com.myapp.dragonball_part2_book;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;

import com.myapp.dragonball_part2_book.Spec.GameObjectSpec;
import com.myapp.dragonball_part2_book.content.gameobject.GameObject;
import com.myapp.dragonball_part2_book.graphic.AnimatedGraphicsComponent;
import com.myapp.dragonball_part2_book.graphic.BackgroundGraphicsComponent;
import com.myapp.dragonball_part2_book.graphic.InanimateBlockGraphicsComponent;
import com.myapp.dragonball_part2_book.input.PlayerInputComponent;
import com.myapp.dragonball_part2_book.transform.BackgroundTransform;
import com.myapp.dragonball_part2_book.transform.FireBallTransform;
import com.myapp.dragonball_part2_book.transform.PlayerTransform;
import com.myapp.dragonball_part2_book.transform.Transform;
import com.myapp.dragonball_part2_book.update.BackgroundUpdateComponent;
import com.myapp.dragonball_part2_book.update.DecorativeBlockUpdateComponent;
import com.myapp.dragonball_part2_book.update.CupidArrowUpdateComponent;
import com.myapp.dragonball_part2_book.update.InanimateBlockUpdateComponent;
import com.myapp.dragonball_part2_book.update.MovableBlockUpdateComponent;
import com.myapp.dragonball_part2_book.update.PlayerUpdateComponent;

public class GameObjectFactory {
    private Context mContext;
    private GameEngine mGameEngineReference;
    private int mPixelsPerMetre;

    public GameObjectFactory(Context context,
                             GameEngine gameEngine,
                             int pixelsPerMetre) {
        mContext = context;

        mGameEngineReference = gameEngine;
        mPixelsPerMetre = pixelsPerMetre;

    }

    public GameObject create(GameObjectSpec spec, PointF location) {
        GameObject object = new GameObject();

        int mNumComponents = spec.getComponents().length;
        object.setTag(spec.getTag());

        // First give the game object the
        // right kind of transform
        switch(object.getTag()){
            case "Fire":
                object.setTransform(
                        new FireBallTransform(
                                spec.getSpeed(),
                                spec.getSize().x,
                                spec.getSize().y,
                                location));
                break;

            case "Background":
                // Code coming soon
                object.setTransform(
                        new BackgroundTransform(
                                spec.getSpeed(),
                                spec.getSize().x,
                                spec.getSize().y,
                                location));
                break;

            case "Player":
                // Code coming soon
                object.setTransform(
                        new PlayerTransform(spec.getSpeed(),
                                spec.getSize().x,
                                spec.getSize().y,
                                location));
                break;

            default:// normal transform
                object.setTransform(new Transform(
                        spec.getSpeed(),
                        spec.getSize().x,
                        spec.getSize().y,
                        location));
                break;
        }


        // Loop through and add/initialize all the components
        for (int i = 0; i < mNumComponents; i++) {
            switch (spec.getComponents()[i]) {
                case "PlayerInputComponent":
                    // Code coming soon
                    object.setPlayerInputTransform(
                            new PlayerInputComponent(
                                    mGameEngineReference));
                    break;

                case "AnimatedGraphicsComponent":
                    // Code coming soon
                    object.setGraphics(
                            new AnimatedGraphicsComponent(),
                            mContext, spec, spec.getSize(),
                            mPixelsPerMetre,spec.getActive());
                    break;

                case "DecorativeBlockUpdateComponent":
                    object.setMovement(new
                            DecorativeBlockUpdateComponent());
                    break;

                case "PlayerUpdateComponent":
                    // Code coming soon
                    object.setMovement(new PlayerUpdateComponent());
                    break;

                case "InanimateBlockGraphicsComponent":
                    object.setGraphics(new
                                    InanimateBlockGraphicsComponent(),
                            mContext, spec, spec.getSize(),
                            mPixelsPerMetre,spec.getActive());
                    break;

                case "MovableFireGraphicsComponent":
                    object.setGraphics(new
                                    InanimateBlockGraphicsComponent(),
                            mContext, spec, spec.getSize(),
                            mPixelsPerMetre,spec.getActive());
                    break;

                case "InanimateBlockUpdateComponent":
                    object.setMovement(new
                            InanimateBlockUpdateComponent());
                    break;

                case "BackgroundGraphicsComponent":
                    // Code coming soon
                    object.setGraphics(
                            new BackgroundGraphicsComponent(),
                            mContext, spec, spec.getSize(),
                            mPixelsPerMetre,spec.getActive());
                    break;
                case "BackgroundUpdateComponent":
                    // Code coming soon
                    object.setMovement(new BackgroundUpdateComponent());
                    break;
                case "MovableBlockUpdateComponent":
                    // Code coming soon
                    object.setMovement(new
                            MovableBlockUpdateComponent());
                    break;

                case "FireBallUpdateComponent":
                    // Code coming soon
                    object.setMovement(new
                            CupidArrowUpdateComponent());
                    break;
                default:
                    // Error unidentified component
                    break;
            }
        }

        // Return the completed GameObject
        // to the LevelManager class
        return object;
    }
}
