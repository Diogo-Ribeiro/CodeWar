package org.academiadecodigo.codewar;

import org.academiadecodigo.codewar.gameobjects.*;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by codecadet on 25/05/16.
 */
public class CollisionChecker {

   public static void check(Projectile projectile, GameObjects object){

       if(projectile.getPosition().equals(object.getPosition())){
           object.getHit(projectile);
           projectile.reachTarget();
           if(object instanceof Projectile){
              ((Projectile) object).reachTarget();
           }
           //System.out.println(projectile.isHitTarget());

       }
   }

    /*
    public static void check(LinkedList<Projectile> projectiles, Char[] chars) {

        for (int i = 0; i < chars.length; i++) {

            ListIterator<Projectile> a = projectiles.listIterator();

            while(a.hasNext()) {

                Projectile p = a.next();

                if (p.getPosition().equals(chars[i].getPosition())) {

                    chars[i].getHit(p);
                    p.reachTarget();

                }
            }
        }
    }

    public static void check (LinkedList<Projectile> mcProjectiles, Codecadet player) {

        ListIterator<Projectile> a = mcProjectiles.listIterator();

        while(a.hasNext()) {

            Projectile p = a.next();

            if (p.getPosition().equals(player.getPosition())) {

                player.getHit(p);
                p.reachTarget();
                a.remove();
            }
        }
    }

    public static void check(LinkedList<Projectile> mcProjectiles, LinkedList<Projectile> playerProjectiles) {

        ListIterator<Projectile> a = mcProjectiles.listIterator();
        ListIterator<Projectile> b = playerProjectiles.listIterator();

        while (a.hasNext()) {

            Projectile p = a.next();

            while (b.hasNext()) {

                Projectile q = b.next();

                if ((p.getPosition().equals(q.getPosition()) && !(q.getType() == ProjectileType.BUG) && !(p.getType() == ProjectileType.BUG) )) {

                    q.reachTarget();
                    p.reachTarget();
                }
            }
        }
    }*/
}

