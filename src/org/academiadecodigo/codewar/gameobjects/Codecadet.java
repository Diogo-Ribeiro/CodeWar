package org.academiadecodigo.codewar.gameobjects;

/**
 * Created by diogocodecadet on 23/05/16.
 */
public class Codecadet extends Char {
    // TODO: 24/05/16 one char for each codecadet and associated game mode

    private boolean moving;

    public Codecadet(){

    }

    @Override
    public void move ( ){

        while (moving) {

            //move
        }

    }

    @Override
    public Projectile shoot(){

        //should I get the playerProjectiles[]? or should we have some sort of collision checker?
        return new Projectile();
    }

    public void dead () {

    }

    public void setMoving(boolean moving) {

        this.moving = moving;
    }
}
