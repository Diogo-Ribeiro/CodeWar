package org.academiadecodigo.codewar.gameobjects;

/**
 * Created by diogocodecadet on 23/05/16.
 */
public abstract class Char extends GameObjects {

    private int hp;
    private boolean dead;
    private boolean specialShot;

    public void move ( ){

    }

    public abstract Projectile shoot( );

    public boolean isDead() {

        return dead;
    }

    public void Die () {

        dead = true;
    }
}
