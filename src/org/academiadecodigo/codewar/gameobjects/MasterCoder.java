package org.academiadecodigo.codewar.gameobjects;

import org.academiadecodigo.codewar.Direction;
import org.academiadecodigo.codewar.RandomNumberGenerator;
import org.academiadecodigo.codewar.representable.GridPosition;

/**
 * Created by diogocodecadet on 23/05/16.
 */
public class MasterCoder extends Char {

    private final int MAX_STEP = 20;


    private MasterCoderType type;
    private int step;

    /**
     * The MasterCoder constructor recieves a MasterCoderType and a GridPosition.
     * Call's the superclass to store the position.
     * Atributes to the MasterCoder Class the type that recieves in the parameter.
     * Atributes to the step the MAX_STEP.
     * Call the setMoving() from Char and set it true.
     * Call the setCurrentDirection() and set the Direction with getRandomX().
     *
     * @param type
     * @param position
     */

    public MasterCoder(MasterCoderType type, GridPosition position) {

        super(position);
        this.type = type;
        step = MAX_STEP;
        this.setMoving(true);
        this.setCurrentDirection(Direction.getRandomX());
    }

    /**
     * The move() make the mastercoder move to the next position if the mastercoder isn't dead already.
     */
    @Override
    public void move() {

        if (!isDead() && isMoving()) {

            //only move every other turn
            if (step % 2 == 0) {

                if (step == 0) {

                    this.setCurrentDirection(Direction.getRandomX());
                    step = MAX_STEP;
                }

                if (isHittingWall()) {

                    setCurrentDirection(Direction.getOppositeX(getCurrentDirection()));
                }

                getPosition().move(this.getCurrentDirection(), 1);
            }

        } else if (!isMoving() && step == 0) {

            setMoving(true);
            step = MAX_STEP;
        }
        step--;
    }


    /**
     * The getHit() recieves a Projectile and if the MasterCoder has HP, set the move to false. Otherwise call the die() method.
     *
     * @param projectile
     */
    @Override
    public void getHit(Projectile projectile) {

        if (projectile.getType() == ProjectileType.BUG) {

            die();

        } else {

            setMoving(false);
            step = MAX_STEP;

        }
    }

    /**
     * The shoot() check if the MasterCoder isn't dead and if it isn't creates a new projectile of a Type selected randomly.
     *
     * @return Projectile
     */

    public Projectile shoot() {

        if (!isDead()) {

            int r = RandomNumberGenerator.get(0, 10);
            if (r < 2) {

                return ProjectileFactory.get(ProjectileType.KISSY, this.getPosition(), Direction.DOWN);

            } else if (r >= 2 && r < 4) {

                return ProjectileFactory.get(ProjectileType.DICKY, this.getPosition(), Direction.DOWN);

            }
        }

        return null;
    }

    /**
     * The isHittingWall() check if MasterCodet is in the grid limit and if it is returns true.
     *
     * @return
     */

    public boolean isHittingWall() {

        return (getPosition().getCol() <= 0 || getPosition().getCol() >= getPosition().getGrid().getCols() - Char.AVATAR_DIMENSION);
    }
}
