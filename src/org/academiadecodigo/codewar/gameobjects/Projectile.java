package org.academiadecodigo.codewar.gameobjects;

import org.academiadecodigo.codewar.Direction;

/**
 * Created by diogocodecadet on 23/05/16.
 */
public class Projectile extends GameObjects {
    ProjectileType type;
    //Amauri and Henry: made this constructor and method reachedEdge
   /* public Projectile(ProjectileType type){
        this.type = type;
    }*/

    public boolean reachedEdge(){
        //need to change this
        return true;
    }

    public void setType(ProjectileType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "I am a projectile!";
    }
}
