package org.academiadecodigo.codewar.representable;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Created by codecadet on 25/05/16.
 */
public interface Grid {

    public void init();

    public int getCols();

    public int getRows();

    public GridPosition makeGridPosition(Rectangle representable);

    public GridPosition makeGridPosition (int col, int row, Rectangle representable);

    public void stackOverflow();

    public void win();
}
