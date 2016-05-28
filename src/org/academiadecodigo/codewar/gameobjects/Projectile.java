package org.academiadecodigo.codewar.gameobjects;

import org.academiadecodigo.codewar.Direction;
import org.academiadecodigo.codewar.representable.AbstractGridPosition;
import org.academiadecodigo.codewar.representable.GridPosition;
import org.academiadecodigo.codewar.representable.SimpleGfxGrid;
import org.academiadecodigo.codewar.representable.SimpleGfxGridPosition;

/**
 * Created by diogocodecadet on 23/05/16.
 */
public class Projectile extends GameObjects {
    ProjectileType type;
    private AbstractGridPosition position;

    //Amauri and Henry: made this constructor and method reachedEdge
    public Projectile(ProjectileType type, SimpleGfxGridPosition position){
        this.type = type;
        this.position = position;
    }

    public boolean reachedEdge(){

        return (this.position.getRow() == 0
                || this.position.getRow() == this.position.getGrid().getRows());
    }

    public void setType(ProjectileType type) {
        this.type = type;
    }

    public void move(){
        position.move(Direction.DOWN,1);
    }

    public ProjectileType getType() {
        return type;
    }

    public AbstractGridPosition getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "I am a projectile!";
    }
}
