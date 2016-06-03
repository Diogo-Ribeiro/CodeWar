package org.academiadecodigo.codewar.representable;

import org.academiadecodigo.codewar.Direction;

/**
 * Created by codecadet on 25/05/16.
 */
public abstract class AbstractGridPosition implements GridPosition {

    private int col;
    private int row;
    private Grid grid;

    /**
     * Constructs a new AbstractGridPosition at the specified Column and Row.
     * @param col
     * @param row
     * @param grid
     */
    AbstractGridPosition(int col, int row, Grid grid) {
        this.col = col;
        this.row = row;
        this.grid = grid;
    }

    public abstract void move (Direction direction, int cols);
    public abstract void show ();
    public abstract void hide ();

    @Override
    public int getCol() {
        return col;
    }

    @Override
    public void setCol(int col) {
        this.col = col;
    }

    @Override
    public int getRow() {
        return row;
    }

    @Override
    public void setRow(int row) {
        this.row = row;
    }

    @Override
    public Grid getGrid() {
        return grid;
    }


}
