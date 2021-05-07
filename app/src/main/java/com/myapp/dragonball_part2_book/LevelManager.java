package com.myapp.dragonball_part2_book;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.util.Log;

import com.myapp.dragonball_part2_book.content.gameobject.GameObject;
import com.myapp.dragonball_part2_book.Spec.BackgroundSpec;
import com.myapp.dragonball_part2_book.Spec.CollectibleObjectSpec;
import com.myapp.dragonball_part2_book.Spec.ArrowCupidSpec;
import com.myapp.dragonball_part2_book.Spec.FireTileSpec;
import com.myapp.dragonball_part2_book.Spec.GroundSpec;
import com.myapp.dragonball_part2_book.Spec.LamppostTileSpec;
import com.myapp.dragonball_part2_book.Spec.HeartSpec;
import com.myapp.dragonball_part2_book.Spec.PlayerSpec;
import com.myapp.dragonball_part2_book.level.Level;
import com.myapp.dragonball_part2_book.level.LevelGreen;

import java.util.ArrayList;

public class LevelManager {

    static int PLAYER_INDEX = 0;
    static int FIREBALL_INDEX =0;
    static int LAM_INDEX = 0;
    private ArrayList<GameObject> objects;
    private Level currentLevel;
    private GameObjectFactory factory;

    LevelManager(Context context, GameEngine ge, int pixelsPerMetre){

        objects = new ArrayList<>();
        factory = new GameObjectFactory(context,
                ge,
                pixelsPerMetre);
    }

    void setCurrentLevel(String level){
        switch (level) {
            case "green":
                currentLevel = new LevelGreen();
                break;

            case "city":
              //  currentLevel = new LevelCity();
                break;

            case "mountains":
             //   currentLevel = new LevelMountains();
                break;
        }
    }

    void buildGameObjects(){
        // Backgrounds 1, 2, 3(City, Underground, Mountain...)
        // p = Player
        // g = Grass tile
        // o = Objective
        // m = Movable platform
        // b = Brick tile
        // c = mine Cart
        // s = Stone pile
        // l = coaL
        // n = coNcrete
        // a = lAmpost
        // r = scoRched tile
        // w = snoW tile
        // t = stalacTite
        // i = stalagmIte
        // d = Dead tree
        // e = snowy trEe
        // x = Collectable
        // z = Fire
        // y = invisible death_invisible

       // gs.resetCoins();
       // objects.clear();
        ArrayList<String> levelToLoad = currentLevel.getTiles();

        for(int row = 0; row < levelToLoad.size(); row++ )
        {
            for(int column = 0;
                column < levelToLoad.get(row).length();
                column++){

                PointF coords = new PointF(column, row);

                switch (levelToLoad.get(row)
                        .charAt(column)){

                    case '1':
                        objects.add(factory.create(
                                new BackgroundSpec(),
                                coords));
                        break;

                    case 'g':
                        objects.add(factory.create(
                                new GroundSpec(),
                                coords));
                        break;

                    case 'm':
                        objects.add(factory.create(
                                new HeartSpec(),
                                coords));
                        break;


                    case 'p':
                        objects.add(factory.create(new
                                        PlayerSpec(),
                                coords));
                        // Remember the location of

                        // the player
                        PLAYER_INDEX = objects.size()-1;

                        objects.add(factory.create(new
                                        ArrowCupidSpec(),
                                coords));

                        FIREBALL_INDEX = objects.size()-1;
                        break;

                    case 'x':
                        objects.add(factory.create(
                                new CollectibleObjectSpec(),
                                coords));
                        //gs.coinAddedToLevel();
                        break;
                    case 'a':
                        objects.add(factory.create(
                                new LamppostTileSpec(),
                                coords));

                        LAM_INDEX = objects.size()-1;
                        break;
                    case 'z':
                        objects.add(factory.create(
                                new FireTileSpec(),
                                coords));
                        break;

                    case '.':
                        // Nothing to see here
                        break;

                    default:
                        Log.e("Unhandled item in level",
                                "row:"+row
                                        + " column:"+column);
                        break;
                }

            }

        }

    }

    ArrayList<GameObject> getGameObjects(){
        return objects;
    }
}
