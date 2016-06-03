package org.academiadecodigo.codewar.representable;

import org.academiadecodigo.codewar.Direction;

/**
 * Created by codecadet on 25/05/16.
 */
public interface GridPosition {

    /**
     *
     * @return the current column.
     */
    public int getCol();

    /**
     * sets the current col to the specified value.
     * @param col
     */
    public void setCol(int col);

    /**
     *
     * @return the current row.
     */
    public int getRow();


    /**
     *
     * @param row sets the current row to the specified value.
     */
    public void setRow(int row);

    /**
     *
     * @return the maximum X of this position.
     */
    public int getMaxX ();

    /**
     *
     * @return the maximum Y of this position.
     */
    public int getMaxY ();

    /**
     *
     * @return the grid to which this position belongs
     */
    public Grid getGrid();

    /**
     * Moves in the specified direction.
     * @param direction
     * @param distance
     */
    public void move(Direction direction, int distance);


    /**
     * makes this position visible
     */
    public void show();

    /**
     * makes this position invisible
     */
    public void hide();
}
