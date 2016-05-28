package org.academiadecodigo.codewar.gameobjects;

import org.academiadecodigo.codewar.Direction;
import org.academiadecodigo.codewar.representable.GridPosition;

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
