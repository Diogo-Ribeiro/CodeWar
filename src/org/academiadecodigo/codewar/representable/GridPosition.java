package org.academiadecodigo.codewar.representable;

import org.academiadecodigo.codewar.Direction;

/**
 * Created by codecadet on 25/05/16.
 */
public interface GridPosition {

    public int getCol();

    public void setCol(int col);

    public int getRow();

    public void setRow(int row);

    public int getMaxX ();

    public int getMaxY ();

    public Grid getGrid();

    public void move(Direction direction, int distance);

    public void show();

    public void hide();
}
