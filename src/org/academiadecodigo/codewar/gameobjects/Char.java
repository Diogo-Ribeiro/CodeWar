package org.academiadecodigo.codewar.gameobjects;

import org.academiadecodigo.codewar.representable.GridPosition;

/**
 * Created by diogocodecadet on 23/05/16.
 */
public abstract class Char extends GameObjects {

    private int hp = 6;
    private boolean dead;
    private boolean specialShot;
    private GridPosition position;

    public Char (GridPosition position) {

        this.position = position;
    }
    public abstract void move ( );

    public abstract Projectile shoot();

    public abstract void getHit(Projectile projectile);

    public void lowerHP() {

        hp--;

        if (hp == 0) {

            dead = true;
        }
    }

    public void die () {
        dead = true;
    }

    public boolean isDead() {
        return dead;
    }

    public GridPosition getPosition() {
        return position;
    }
}
