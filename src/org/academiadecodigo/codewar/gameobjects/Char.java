package org.academiadecodigo.codewar.gameobjects;

import org.academiadecodigo.codewar.representable.GridPosition;

/**
 *
 * Represents all possible characters of the game.
 */
public abstract class Char extends GameObjects {

    /**
     * @param AVATAR
     */
    public final static int AVATAR_DIMENSION = 4;
    private boolean dead;
    private boolean moving;

    /**
     * Constructor of class Char.
     * @param position
     */
    Char (GridPosition position) {

        super (position);
    }

    /**
     * makes the character move.
     * call position.move().
     */
    public abstract void move ( );


    /**
     * @return Projectile.
     */
    public abstract Projectile shoot();

    /**
     * remove character.
     * set field dead to true.
     */

    void die () {

        getPosition().hide();
        dead = true;
    }

    /**
     * check if character is dead.
     * @return true if it is dead.
     */
    public boolean isDead() {
        return dead;
    }

    /**
     * check if character is moving.
     * @return true if it is moving.
     */
    boolean isMoving() {
        return moving;
    }

    /**
     * set field moving according to argument.
     * @param moving
     */
    public void setMoving(boolean moving) {
        this.moving = moving;
    }
}
