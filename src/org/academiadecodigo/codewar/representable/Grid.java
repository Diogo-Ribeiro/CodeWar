package org.academiadecodigo.codewar.representable;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Created by codecadet on 25/05/16.
 */
public interface Grid {

    public int getCols();
    public int getRows();
    public SimpleGfxGridPosition makeGridPosition(int col, int row, Rectangle representable);
}
