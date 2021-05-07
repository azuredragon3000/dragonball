package com.myapp.dragonball_part2_book.Interface;

public interface GameEngineBroadcaster {
    // This allows the Player and UI Controller components
    // to add themselves as listeners of the GameEngine class
    void addObserver(InputObserver o);
}
