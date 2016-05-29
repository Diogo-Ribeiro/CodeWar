package org.academiadecodigo.codewar.gameobjects;

import org.academiadecodigo.codewar.Direction;
import org.academiadecodigo.codewar.RandomNumberGenerator;
import org.academiadecodigo.codewar.representable.Grid;
import org.academiadecodigo.codewar.representable.GridPosition;

/**
 * Created by diogocodecadet on 23/05/16.
 */
public class MasterCoder extends Char {

    private final int MAX_STEP = 10;

    private MasterCoderType type;
    private int step;

    // TODO: 24/05/16 mcs open mouth to shoot kissies or dickies

    public MasterCoder (MasterCoderType type, GridPosition position) {

        super(position);
        this.type = type;
        step = MAX_STEP;
        this.setCurrentDirection(Direction.getRandomX());
    }

    @Override
    public void move (){

        if (!isDead()) {

            //only move every other turn
            if (step % 2 == 0) {

                if (step == 0) {

                    this.setCurrentDirection(Direction.getRandomX());
                    step = MAX_STEP;
                }

                if (isHittingWall(getPosition().getGrid())) {

                    setCurrentDirection(Direction.getOppositeX(getCurrentDirection()));
                }

                getPosition().move(this.getCurrentDirection(), 1);
            }

            step--;
        }
    }

    @Override
    public void getHit(Projectile projectile) {

        die();
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

    public boolean isHittingWall(Grid grid){

        return (getPosition().getCol() <= 0 || getPosition().getCol()>= grid.getCols()-1);
    }
}
