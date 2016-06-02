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
    private boolean hitTarget;

    //Amauri and Henry: made this constructor and method reachedEdge
    public Projectile(ProjectileType type, GridPosition position, Direction direction){

        super(position);
        this.type = type;
        this.setCurrentDirection(direction);
    }

    public void move () {

        if (reachedEdge()) {

            reachTarget();

        } else {

            getPosition().move(this.getCurrentDirection(), 1);
        }
    }

    private boolean reachedEdge(){

        return (getPosition().getRow() == 0
                || getPosition().getMaxY() == getPosition().getGrid().getRows());
    }

    public void reachTarget() {

        hitTarget = true;
        this.getPosition().hide();
    }

    public ProjectileType getType() {
        return type;
    }

    public boolean isHitTarget() {
        return hitTarget;
    }

    @Override
    public void getHit(Projectile projectile){}
}
