package org.academiadecodigo.codewar.gameobjects;

import org.academiadecodigo.codewar.Direction;
import org.academiadecodigo.codewar.RandomNumberGenerator;
import org.academiadecodigo.codewar.representable.Grid;
import org.academiadecodigo.codewar.representable.GridPosition;
import org.academiadecodigo.codewar.representable.SimpleGfxGridPosition;

/**
 * Created by diogocodecadet on 23/05/16.
 */
public class MasterCoder extends Char {

    private MasterCoderType type;
    private int step;
    private final int MAX_STEP = 10;

    // TODO: 24/05/16 mcs open mouth to shoot kissies or dickies

    public MasterCoder (MasterCoderType type, GridPosition position) {

        super(position);
        this.type = type;
        step = MAX_STEP;
        this.setCurrentDirection(Direction.getRandom());
    }

    public void move (){


        if (!isDead()) {

            if (step % 2 == 0) {

                if (step == 0) {

                    this.setCurrentDirection(Direction.getRandom());
                    step = MAX_STEP;
                }

                if (isHittingWall(getPosition().getGrid())) {

                    setCurrentDirection(Direction.getOpposite(getCurrentDirection()));
                }

                getPosition().move(this.getCurrentDirection(), 1);

            }
            step--;
        }
    }

    @Override
    public void getHit(Projectile projectile) {

        System.out.println("hit");
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
