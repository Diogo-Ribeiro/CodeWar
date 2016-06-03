package org.academiadecodigo.codewar.gameobjects;

import org.academiadecodigo.codewar.Direction;
import org.academiadecodigo.codewar.representable.GridPosition;

/**
 * Created by diogocodecadet on 23/05/16.
 */
public abstract class GameObjects{
    // Allow direct access from subclasses
    private Direction currentDirection;
    private GridPosition position;

    GameObjects (GridPosition position) {

        this.position = position;
    }
    public abstract void getHit(Projectile projectile);

    public void setCurrentDirection(Direction newDirection){
        currentDirection = newDirection;
    }

    Direction getCurrentDirection(){
        return currentDirection;
    }

    public GridPosition getPosition() {

        return position;
    }
}

