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
    private GridPosition position;
    private boolean hitTarget;

    //Amauri and Henry: made this constructor and method reachedEdge
    public Projectile(ProjectileType type, GridPosition position, Direction direction){

        this.type = type;
        this.position = position;
        this.setCurrentDirection(direction);
    }

    public void move () {

        if (reachedEdge()) {

            reachTarget();

        } else {

            this.getPosition().move(this.getCurrentDirection(), 1);
        }
    }

    public boolean reachedEdge(){

        return (this.position.getRow() < 0
                || this.position.getRow() == this.position.getGrid().getRows());
    }

    public void setType(ProjectileType type) {
        this.type = type;
    }

    public void move(){
        switch (type) {
            case KISSY:
            position.move(Direction.DOWN, 1);
                break;
            case DICKY:
                position.move(Direction.DOWN, 1);
                break;
            case BUG:
                position.move(Direction.UP, 1);
                break;
            case QUESTION:
                position.move(Direction.UP, 1);
        }
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

    public void reachTarget() {

        hitTarget = true;
        this.getPosition().hide();
    }

    public GridPosition getPosition() {

        return position;
    }

    public ProjectileType getType() {
        return type;
    }

    public boolean isHitTarget() {
        return hitTarget;
    }
}
