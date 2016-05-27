package org.academiadecodigo.codewar;

import org.academiadecodigo.codewar.gameobjects.MasterCoder;

/**
 * Created by diogocodecadet on 23/05/16.
 */
public class Main {
    // TODO: 24/05/16 change name to beijinhos & caralhinhos
    public static void main(String[] args) throws InterruptedException{

        Game g = new Game();

        //run the 'settings' part, which allows the player to choose the game mode and the codecadet char.
        g.init();

        //start the actual game.
        g.start();

    }
}
