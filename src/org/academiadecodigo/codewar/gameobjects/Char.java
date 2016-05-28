package org.academiadecodigo.codewar.gameobjects;

import org.academiadecodigo.codewar.representable.SimpleGfxGridPosition;

/**
 * Created by diogocodecadet on 23/05/16.
 */
public abstract class Char extends GameObjects {

    private int hp = 6;
    private boolean dead;
    private boolean specialShot;
    private SimpleGfxGridPosition position;

    public Char (SimpleGfxGridPosition position) {

        this.position = position;
    }
    public void move ( ){

    }

    public abstract void getHit(Projectile projectile);
    public abstract Projectile shoot();

    public void lowerHP() {

        hp--;

        if (hp == 0) {

            die();
        }
    }

    public int getHp () {
        return hp;
    }
    public boolean isDead() {

        return dead;
    }

    public void die () {

        dead = true;
    }

    public SimpleGfxGridPosition getPosition() {
        return position;
    }

    public void setPosition(SimpleGfxGridPosition position) {
        this.position = position;
    }
}
