package org.academiadecodigo.codewar.gameobjects;

import org.academiadecodigo.codewar.Direction;
import org.academiadecodigo.codewar.representable.GridPosition;
import org.academiadecodigo.codewar.representable.Representable;

/**
 * Created by diogocodecadet on 23/05/16.
 */
public abstract class GameObjects{
    // Allow direct access from subclasses
    private Direction currentDirection;

    public void setCurrentDirection(Direction newDirection){
        currentDirection = newDirection;
    }

    public Direction getCurrentDirection(){
        return currentDirection;
    }


}

