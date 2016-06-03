package org.academiadecodigo.codewar;

import java.io.FileNotFoundException;

/**
 * Created by diogocodecadet on 23/05/16.
 */
public class Main {

    /**
     * instantiates  a new game and initializes it.
     */
    public static void main(String[] args) throws InterruptedException, FileNotFoundException {

        Game g = new Game();

        //run the 'settings' part, which allows the player to choose the game mode and the codecadet char.
        g.init();
    }
}
