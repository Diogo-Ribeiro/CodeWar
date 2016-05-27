package org.academiadecodigo.codewar;

import org.academiadecodigo.codewar.gameobjects.*;
import org.academiadecodigo.codewar.representable.SimpleGfxGrid;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

/**
 * Created by diogocodecadet on 23/05/16.
 */
public class Game{

    public static final int MASTER_CODERS = MasterCoderType.values().length;
    public static final int MAX_PROJECTILES = 5;
    Keyboard k;

    Char[] chars;
    Projectile[] playerProjectiles;
    Projectile[] MCProjectiles;
    SimpleGfxGrid grid = new SimpleGfxGrid(40, 80);

    public Game () {

        // TODO: 25/05/16 init or constructor?
        chars = new Char[MASTER_CODERS + 1];
        playerProjectiles = new Projectile[MAX_PROJECTILES];
        MCProjectiles = new Projectile[(MAX_PROJECTILES/2)*MASTER_CODERS];

    }
    public void init () {

        grid.init();
        chars = CharFactory.charMaker(grid);

    }

    public void start () throws InterruptedException {

        while (true) {

            for (int i = 0; i < chars.length; i++) {

                chars[i].move();
            }

            //masterCodersShoot();
            //updateProjectiles();
            Thread.sleep(200);
        }
    }

    private void masterCodersShoot () {

        // TODO: 25/05/16
        for (int j = 1; j < chars.length; j++) {

            if (chars[j] != null) {

                Projectile currentProjectile = chars[j].shoot();

                if (currentProjectile != null) {

                    for (int i = 0; i < MCProjectiles.length; i++) {

                        if (MCProjectiles[i] == null) {

                            MCProjectiles[i] = currentProjectile;
                            break;
                        }
                    }
                }
            }
        }
    }

    private void updateProjectiles () {

        for (int i = 0; i < MCProjectiles.length; i++) {

            //if (projectile.reachedEdge) {
            //MCProjectiles[i] = null;
            //  }
            System.out.println(MCProjectiles[i]);
        }
    }


}


