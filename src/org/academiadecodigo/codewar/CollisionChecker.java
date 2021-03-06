package org.academiadecodigo.codewar;

import org.academiadecodigo.codewar.gameobjects.*;

import java.util.LinkedList;

/**
 * Created by codecadet on 25/05/16.
 */
class CollisionChecker {

    /**
     * Checks for collisions between any projectile and any game object (projectile, mc, codecadet)
     * @param projectile represents either MasterCoder Projectile or Codecadet Projectile
     * @param object represents any game object (Projectile, MasterCoder or Codecadet)
     */
    private static void check(Projectile projectile, GameObjects object) {

        if (projectile.getPosition().equals(object.getPosition())) {

            object.getHit(projectile);
            projectile.reachTarget();
            if (object instanceof Projectile) {

                ((Projectile) object).reachTarget();
            }
        }
    }

    /**
     * Checks for collisions between mcProjectiles and playerProjectiles and codecadet; and between playerProjectiles and masterCoders
     * @param mcProjectiles Linked List of MasterCoder Projectiles
     * @param playerProjectiles Linked List of Player Projectiles
     * @param masterCoders Array of MasterCoders
     * @param player The Codecadet
     */
    static void checkCollisions(LinkedList<Projectile> mcProjectiles, LinkedList <Projectile> playerProjectiles, MasterCoder[] masterCoders, Codecadet player) {

        for (int j = 0; j < mcProjectiles.size(); j++) {
            check(mcProjectiles.get(j), player);

            for (int i = 0; i < playerProjectiles.size(); i++) {

                for (MasterCoder mc : masterCoders) {

                    check(playerProjectiles.get(i), mc);
                }

                if (playerProjectiles.get(i).getType().equals(ProjectileType.QUESTION)) {

                    check(playerProjectiles.get(i), mcProjectiles.get(j));
                }
            }
        }
    }
}