package org.academiadecodigo.codewar.gameobjects;

import org.academiadecodigo.codewar.Direction;
import org.academiadecodigo.codewar.representable.AbstractGridPosition;
import org.academiadecodigo.codewar.representable.GridPosition;
import org.academiadecodigo.codewar.representable.SimpleGfxGrid;
import org.academiadecodigo.codewar.representable.SimpleGfxGridPosition;

/**
 * The Projectile class represents all the projectiles instantiated in the game.
 */
public class Projectile extends GameObjects {

    /**
     * @param type represents the type of projectile, according to enum ProjectileType
     * @param hitTarget true if the projectile has hit another gameObject
     */
    ProjectileType type;
    private boolean hitTarget;


    /**
     * Constructs a new Projectile object according to its specified arguments.
     * @param type according to enum ProjectileType
     * @param position position of the object in the game grid.
     * @param direction direction of the movement.
     */
    public Projectile(ProjectileType type, GridPosition position, Direction direction){

        super(position);
        this.type = type;
        this.setCurrentDirection(direction);
    }

    /**
     * check if it reaches the limits of game's grid. If so, deletes the projectile.
     * else keep moving the projectile.
     */
    public void move () {

        if (reachedEdge()) {

            reachTarget();

        } else {

            getPosition().move(this.getCurrentDirection(), 1);
        }
    }

    /**
     * Check if projectile position row is 0 or the max row of game's grid.
     * @return true if the projectile has reached the edge of game's grid.
     */
    private boolean reachedEdge(){

        return (getPosition().getRow() == 0
                || getPosition().getMaxY() == getPosition().getGrid().getRows());
    }

    /**
     * method that sets field hitTarget to true and delete the projectile.
     */
    public void reachTarget() {

        hitTarget = true;
        this.getPosition().hide();
    }

    /**
     * Getter.
     * @return type of the projectile.
     */
    public ProjectileType getType() {
        return type;
    }


    /**
     * getter of hitTarget field.
     * @return hitTarget
     */
    public boolean isHitTarget() {
        return hitTarget;
    }

    @Override
    /**
     * Inherits from GameObjects
     */
    public void getHit(Projectile projectile){}
}
