package org.academiadecodigo.codewar;

import org.academiadecodigo.codewar.gameobjects.*;

/**
 * Created by codecadet on 25/05/16.
 */
public class CollisionChecker {

    public static void check(Projectile projectile, GameObjects object) {

        if (projectile.getPosition().equals(object.getPosition())) {

            object.getHit(projectile);
            projectile.reachTarget();
            if (object instanceof Projectile) {

                ((Projectile) object).reachTarget();
            }
        }
    }
}