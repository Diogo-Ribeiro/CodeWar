package org.academiadecodigo.codewar.gameobjects;

import org.academiadecodigo.codewar.Direction;
import org.academiadecodigo.codewar.representable.GridPosition;

/**
 * SuperClass of all objects instantiated during the game.
 */
public abstract class GameObjects{

    // Allow direct access from subclasses
    private Direction currentDirection;
    private GridPosition position;

    /**
     * Forces all subclasses to receive a GridPosition.
     * @param position - The position the GameObject will have in game's grid.
     */
    public GameObjects (GridPosition position) {
        this.position = position;
    }

    /**
     * Receives as argument the projectile that hit it.
     * subclasses implement their own actions .
     * @param projectile
     */
    public abstract void getHit(Projectile projectile);


    /**
     * Setter method that will set the field currentDirection to parameter newDirection
     * @param newDirection  the new Direction the gameObject will have.
     */
    public void setCurrentDirection(Direction newDirection){
        currentDirection = newDirection;
    }

    /**
     * @return currentDirection
     */
    public Direction getCurrentDirection(){
        return currentDirection;
    }

    /**
     * @return position - The gridPosition of the object in the game.
     */
    public GridPosition getPosition() {

        return position;
    }
}

