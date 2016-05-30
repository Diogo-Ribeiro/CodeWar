package org.academiadecodigo.codewar.representable;

import org.academiadecodigo.simplegraphics.graphics.Picture;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Created by codecadet on 25/05/16.
 */
public interface Grid {

    public void init();

    public int getCols();

    public int getRows();

    public GridPosition makeGridPosition(Picture representable);

    public GridPosition makeGridPosition (int col, int row, Picture representable);

    public void stackOverflow();

    public void win();


}
