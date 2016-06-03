package org.academiadecodigo.codewar.gameobjects;

import org.academiadecodigo.codewar.Direction;
import org.academiadecodigo.codewar.representable.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Created by diogocodecadet on 23/05/16.
 */
public class Codecadet extends Char {

    private static final int KISSIES_TO_BUG = 4;
    private int health = 6;
    private int kissyCounter;
    private Rectangle kissyBar;
    private Rectangle kissyBarFill;

    /**
     * Constructor of class Codecadet.
     * @param position
     */
    public Codecadet(GridPosition position) {

        super(position);

        kissyBar = new Rectangle(0, getPosition().getGrid().getRows()*getPosition().getGrid().getCellSize() - 20, 80, 20);
        kissyBarFill = new Rectangle(0, getPosition().getGrid().getRows()*getPosition().getGrid().getCellSize() - 20, 0, 0);
        kissyBarFill.setColor(Color.MAGENTA);
        kissyBar.setColor(Color.MAGENTA);
        kissyBar.draw();
    }

    /**
     * decreases health of character.
     */
    public void lowHealth() {

        health--;

        if (health == 0) {

         die();
        }
    }

    /**
     * makes the Codecadet move.
     */
    @Override
    public void move() {

        if (isMoving()) {

            getPosition().move(getCurrentDirection(), 1);
        }
    }

    /**
     * Receives a projectile and makes the Codecadet get hit by increasing kissyCounter or by lowering its health, depending on projectile type.
     * @param projectile
     */
    @Override
    public void getHit(Projectile projectile) {

        if (projectile.getType() == ProjectileType.KISSY) {

            if (kissyCounter < 4) {

                kissyCounter++;
                kissyBarFill.delete();
                kissyBarFill = new Rectangle(0, getPosition().getGrid().getRows() * getPosition().getGrid().getCellSize() - 20, kissyBarFill.getWidth() + 20, 20);
                kissyBarFill.setColor(Color.MAGENTA);
                kissyBarFill.fill();
            }

        } else if (projectile.getType() == ProjectileType.DICKY) {

            lowHealth();
        }
    }

    /**
     * makes the Codecadet shoot a Question.
     * @return Projectile.
     */
    public Projectile shoot() {

        return ProjectileFactory.get(ProjectileType.QUESTION, getPosition(), Direction.UP);
    }

    /**
     * makes the Codecadet shoot a Bug, as long as kissyCounter has reached an established value.
     * @return Projectile
     */
    public Projectile specialShoot() {

        // TODO: 31/05/16 barrinha hp

        if (kissyCounter >= KISSIES_TO_BUG) {

            kissyCounter = 0;
            kissyBarFill.delete();
            kissyBarFill = new Rectangle(0, getPosition().getGrid().getRows() * getPosition().getGrid().getCellSize() - 20, 0, 0);
            return ProjectileFactory.get(ProjectileType.BUG, this.getPosition(), Direction.UP);
        }
        // TODO: 31/05/16 exception
        return null;
    }
}