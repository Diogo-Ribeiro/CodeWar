package org.academiadecodigo.codewar.representable;

/**
 * Created by codecadet on 25/05/16.
 */
public abstract class AbstractGridPosition implements GridPosition {

    int col;
    int row;
    Grid grid;

    public AbstractGridPosition(int col, int row, Grid grid) {
        this.col = col;
        this.row = row;
        this.grid = grid;
    }

    @Override
    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    @Override
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }
}
