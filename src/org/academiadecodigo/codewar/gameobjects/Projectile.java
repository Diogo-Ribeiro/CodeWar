package org.academiadecodigo.codewar.gameobjects;

import org.academiadecodigo.codewar.Direction;
import org.academiadecodigo.codewar.representable.GridPosition;

/**
 * Created by diogocodecadet on 23/05/16.
 */
public class Projectile extends GameObjects {
    ProjectileType type;
    private GridPosition position;

    //Amauri and Henry: made this constructor and method reachedEdge
    public Projectile(ProjectileType type, GridPosition position){
        this.type = type;
        this.position = position;
    }

    public boolean reachedEdge(){

        return (this.position.getRow() == 0
                || this.position.getRow() == this.position.getGrid().getRows()-1);
    }

    public void setType(ProjectileType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "I am a projectile!";
    }
}
