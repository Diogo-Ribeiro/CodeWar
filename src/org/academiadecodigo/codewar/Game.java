package org.academiadecodigo.codewar;

import org.academiadecodigo.codewar.gameobjects.Char;
import org.academiadecodigo.codewar.gameobjects.Projectile;

/**
 * Created by diogocodecadet on 23/05/16.
 */
public class Game {

    public static final int MASTER_CODERS = 7;
    public static final int MAX_PROJECTILES = 5;

    Char[] chars;
    Projectile[] playerProjectiles;
    Projectile[] gameProjectiles;

    public Game () {

        chars = new Char[MASTER_CODERS + 1];
        playerProjectiles = new Projectile[MAX_PROJECTILES];
        gameProjectiles = new Projectile[(MAX_PROJECTILES/2)*MASTER_CODERS];

    }
    public void init () {}

    public void start () {}


}
