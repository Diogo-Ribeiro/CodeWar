package org.academiadecodigo.codewar.gameobjects;

import org.academiadecodigo.codewar.Direction;
import org.academiadecodigo.codewar.RandomNumberGenerator;
import org.academiadecodigo.codewar.representable.Grid;
import org.academiadecodigo.codewar.representable.SimpleGfxGrid;
import org.academiadecodigo.codewar.representable.SimpleGfxGridPosition;

/**
 * Created by diogocodecadet on 23/05/16.
 */
public class MasterCoder extends Char {

    private MasterCoderType type;
    private int step;
    private final int MAX_STEP = 10;

    // TODO: 24/05/16 mcs open mouth to shoot kissies or dickies

    public MasterCoder (MasterCoderType type, SimpleGfxGridPosition position) {

        super(position);
        this.type = type;
        step = MAX_STEP;
        this.setCurrentDirection(Direction.getRandom());
    }

    public void move (){

        if (step%2 == 0) {

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

    public Projectile shoot () {
        // TODO: 25/05/16 think of an adequate shooting probability
        if (RandomNumberGenerator.get(0,10) < 3) {

            System.out.println("new projectile fired");
            return new Projectile();

        }

        System.out.println("didn't shoot");
        return null;
    }

    public boolean isHittingWall(Grid grid){
        return (getPosition().getCol() <= 0 || getPosition().getCol()>= grid.getCols()-1);
    }
}
