package org.academiadecodigo.codewar.gameobjects;

import org.academiadecodigo.codewar.Direction;
import org.academiadecodigo.codewar.representable.GridPosition;

/**
 * Created by diogocodecadet on 23/05/16.
 */
public class Codecadet extends Char{

    // TODO: 24/05/16 one char for each codecadet and associated game mode
    private boolean moving;

    //// TODO: 28/05/2016 find better name
    private int kissyCounter;

    public Codecadet(GridPosition position) {

        super(position);
    }

    @Override
    public void move () {

        if (moving) {

            getPosition().move(this.getCurrentDirection(), 1);

        }
    }

    @Override
    public void getHit(Projectile projectile) {

        if (projectile.getType() == ProjectileType.KISSY) {

            kissyCounter++;

        } else if (projectile.getType() == ProjectileType.DICKY) {

            lowerHP();
        }
    }

    public Projectile shoot() {

        return ProjectileFactory.get(ProjectileType.QUESTION, this.getPosition(), Direction.UP);
    }

    public Projectile specialShoot() {

        System.out.println(kissyCounter);
        if (kissyCounter >= 4) {

            kissyCounter = 0;
            return ProjectileFactory.get(ProjectileType.BUG, this.getPosition(), Direction.UP);
        }

        return null;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }
}