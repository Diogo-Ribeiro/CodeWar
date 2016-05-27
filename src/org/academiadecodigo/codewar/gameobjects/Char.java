package org.academiadecodigo.codewar.gameobjects;

import org.academiadecodigo.codewar.representable.SimpleGfxGridPosition;

/**
 * Created by diogocodecadet on 23/05/16.
 */
public abstract class Char extends GameObjects {

    private int hp;
    private boolean dead;
    private boolean specialShot;
    private SimpleGfxGridPosition position;

    public Char (SimpleGfxGridPosition position) {

        this.position = position;
    }
    public void move ( ) throws InterruptedException {

    }

    public abstract Projectile shoot();


    public boolean isDead() {

        return dead;
    }

    public void Die () {

        dead = true;
    }

    public SimpleGfxGridPosition getPosition() {
        return position;
    }

    public void setPosition(SimpleGfxGridPosition position) {
        this.position = position;
    }
}
