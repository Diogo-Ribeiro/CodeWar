package org.academiadecodigo.codewar;

import org.academiadecodigo.codewar.gameobjects.Char;
import org.academiadecodigo.codewar.gameobjects.Codecadet;
import org.academiadecodigo.codewar.gameobjects.Projectile;
import org.academiadecodigo.codewar.gameobjects.ProjectileType;

import java.util.LinkedList;

/**
 * Created by codecadet on 25/05/16.
 */
public class CollisionChecker {

    public static void check(LinkedList<Projectile> projectiles, Char[] chars) {

        for (int i = 0; i < chars.length; i++) {

            for (int j = 0; j < projectiles.size(); j++) {

                if (projectiles.get(j).getPosition().equals(chars[i].getPosition())) {

                    projectiles.get(j).reachTarget(); //update boolean, says it can be deleted
                    chars[i].getHit(projectiles.get(j));//deals damage (?) || increases counters
                    projectiles.remove(i);
                }
            }
        }
    }

    public static void check (LinkedList<Projectile> mcProjectiles, Codecadet player) {

        for (int i = 0; i < mcProjectiles.size(); i++) {

            if (mcProjectiles.get(i).getPosition().equals(player.getPosition())) {

                player.getHit(mcProjectiles.get(i));//deals damage (?) || increases counters
                mcProjectiles.get(i).reachTarget(); //update boolean, says it can be deleted
                mcProjectiles.remove(i);
            }
        }
    }

    public static void check(LinkedList<Projectile> mcProjectiles, LinkedList<Projectile> playerProjectiles) {

        for (int i = 0; i < mcProjectiles.size(); i++) {

            for (int j = 0; j < playerProjectiles.size(); j++) {

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

