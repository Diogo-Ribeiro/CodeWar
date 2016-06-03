package org.academiadecodigo.codewar.representable;

import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 25/05/16.
 */
public interface Grid {

    /**
     * Initializes the grid.
     */
    public void init();

    /**
     * @return the number of columns (width) of the grid.
     */
    public int getCols();

    /**
     *
     * @return the number of rows (height) of the grid.
     */
    public int getRows();

    /**
     * @param representable
     * @return a new random grid position with the given representable.
     */

    public GridPosition makeGridPosition(Picture representable);

    /**
     * @param col
     * @param row
     * @param representable
     * @return a new grid position at the specified column and row.
     */
    public GridPosition makeGridPosition (int col, int row, Picture representable);

    /**
     * shows the "Game Over" screen.
     */
    public void stackOverflow();

    /**
     * shows the "Win" screen.
     */
    public void win();

    /**
     *
     * @return the conversion rate from columns/rows to pixels.
     */
    public int getCellSize();

}
