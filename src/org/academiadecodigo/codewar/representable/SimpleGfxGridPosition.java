package org.academiadecodigo.codewar.representable;

import org.academiadecodigo.codewar.RandomNumberGenerator;

/**
 * Created by codecadet on 25/05/16.
 */
public class SimpleGfxGridPosition extends AbstractGridPosition {

    public SimpleGfxGridPosition (SimpleGfxGrid grid) {

        super(RandomNumberGenerator.get(0, grid.getCols()), RandomNumberGenerator.get(0, grid.getCols()), grid);

    }

    public SimpleGfxGridPosition (int col, int row, SimpleGfxGrid grid) {

        super (col, row, grid);
    }

    @Override
    public int getCol() {
        return col;
    }

    @Override
    public int getRow() {
        return row;
    }
}
