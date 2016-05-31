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

    private boolean moving;

    // TODO: 24/05/16 mcs open mouth to shoot kissies or dickies

    public MasterCoder (MasterCoderType type, GridPosition position) {

        super(position);
        this.type = type;
        step = MAX_STEP;
        this.moving = true;
        this.setCurrentDirection(Direction.getRandomX());
    }

    @Override
    public void move (){

        if (!isDead() && moving) {

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

        } else if (!moving && step == 0) {

            moving = true;
            step = MAX_STEP;
        }
        step--;
    }

    @Override
    public void getHit(Projectile projectile) {

        if (projectile.getType() == ProjectileType.BUG) {

            die();

        } else {

            moving = false;
            step = MAX_STEP;
        }
    }

    public Projectile shoot () {

        if (!isDead()) {
            // TODO: 25/05/16 think of adequate shooting probabilities
            int r = RandomNumberGenerator.get(0, 10);

            if (r < 3) {

                return ProjectileFactory.get(ProjectileType.KISSY, this.getPosition(), Direction.DOWN);

            } else if (r == 3) {

                return ProjectileFactory.get(ProjectileType.DICKY, this.getPosition(), Direction.DOWN);

            }
        }

        return null;
    }

    // TODO: 27/05/16 remove grid from arguments

    public boolean isHittingWall(){

        return (getPosition().getCol() <= 0 || getPosition().getCol()>= getPosition().getGrid().getCols()-Char.AVATAR_DIMENSION);
    }
}
