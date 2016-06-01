package org.academiadecodigo.codewar.gameobjects;

import org.academiadecodigo.codewar.Direction;
import org.academiadecodigo.codewar.representable.GridPosition;

/**
 * Created by diogocodecadet on 23/05/16.
 */
public abstract class GameObjects{
    // Allow direct access from subclasses
    private Direction currentDirection;

    public abstract void getHit(Projectile projectile);

    public void setCurrentDirection(Direction newDirection){
        currentDirection = newDirection;
    }

    public Direction getCurrentDirection(){
        return currentDirection;
    }

    public abstract GridPosition getPosition();


}

