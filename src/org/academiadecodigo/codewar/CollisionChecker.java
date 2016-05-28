package org.academiadecodigo.codewar;

import org.academiadecodigo.codewar.gameobjects.Char;
import org.academiadecodigo.codewar.gameobjects.Projectile;

/**
 * Created by codecadet on 25/05/16.
 */
public class CollisionChecker {

    public static void check(Projectile[] projectiles, Char[] chars) {

        for (int i = 0; i < chars.length; i++) {

            for (int j = 0; j < chars.length; j++) {

                if (projectiles[i].getPos() == chars[i].getPos()) {

                    projectiles[i].hitTarget(); //update boolean, says it can be deleted
                    chars[i].getHit (projectiles[i]);

                }
            }
        }
    }
}
