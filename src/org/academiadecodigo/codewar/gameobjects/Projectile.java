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

           /* if (type == ProjectileType.BUG) {

                getPosition().move(this.getCurrentDirection(), 2);

            }*/

            getPosition().move(this.getCurrentDirection(), 1);

        }
    }

    // TODO: 29/05/2016 move this to gameobjects
    public boolean reachedEdge(){

        return (this.position.getRow() == 0
                || this.position.getMaxY() == this.position.getGrid().getRows());
    }

    public void reachTarget() {

        hitTarget = true;
        this.getPosition().hide();
    }

    // TODO: 31/05/16 move to game objects
    public GridPosition getPosition() {

        return position;
    }

    public ProjectileType getType() {
        return type;
    }

    public boolean isHitTarget() {
        return hitTarget;
    }

    @Override
    public String toString() {
        return "I am a projectile!";
    }

    @Override
    public void getHit(Projectile projectile){}
}
