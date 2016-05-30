package org.academiadecodigo.codewar;

import org.academiadecodigo.codewar.gameobjects.Char;
import org.academiadecodigo.codewar.gameobjects.Codecadet;
import org.academiadecodigo.codewar.gameobjects.Projectile;
import org.academiadecodigo.codewar.gameobjects.ProjectileType;

/**
 * Created by codecadet on 25/05/16.
 */
public class CollisionChecker {

    public static void check(Projectile[] projectiles, Char[] chars) {

        for (int i = 0; i < chars.length; i++) {

            for (int j = 0; j < projectiles.length; j++) {

                if (projectiles[j] != null && projectiles[j].getPosition().equals(chars[i].getPosition())) {

                    projectiles[j].reachTarget(); //update boolean, says it can be deleted
                    chars[i].getHit(projectiles[j]);//deals damage (?) || increases counters
                }
            }
        }
    }

    public static void check (Projectile[] mcProjectiles, Codecadet player) {

        for (int i = 0; i < mcProjectiles.length; i++) {

            if (mcProjectiles[i] != null && mcProjectiles[i].getPosition().equals(player.getPosition())) {

                mcProjectiles[i].reachTarget(); //update boolean, says it can be deleted
                player.getHit(mcProjectiles[i]);//deals damage (?) || increases counters
            }
        }
    }

    public static void check(Projectile[] mcProjectiles, Projectile[] playerProjectiles) {

        for (int i = 0; i < mcProjectiles.length; i++) {

            for (int j = 0; j < playerProjectiles.length; j++) {

                if (mcProjectiles[i] != null
                    && playerProjectiles[j] != null
                    && playerProjectiles[j].getType() != ProjectileType.BUG
                    && mcProjectiles[i].getPosition().getCol() == playerProjectiles[j].getPosition().getCol()
                    && (mcProjectiles[i].getPosition().getRow() == playerProjectiles[j].getPosition().getRow()-1
                        || mcProjectiles[i].getPosition().getRow() == playerProjectiles[j].getPosition().getRow())) {

                    mcProjectiles[i].reachTarget();
                    playerProjectiles[j].reachTarget(); //update boolean, says it can be deleted
                }
            }
        }
    }
}

