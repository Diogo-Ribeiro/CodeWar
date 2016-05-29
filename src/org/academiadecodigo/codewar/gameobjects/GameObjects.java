package org.academiadecodigo.codewar.gameobjects;

import org.academiadecodigo.codewar.Direction;

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

