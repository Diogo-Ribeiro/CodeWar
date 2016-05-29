package org.academiadecodigo.codewar.representable;

import org.academiadecodigo.codewar.Direction;

/**
 * Created by codecadet on 25/05/16.
 */
public interface GridPosition {

    public int getCol();

    public int getRow();

    public Grid getGrid();

    public void move(Direction direction, int distance);

    public void show();

    public void hide();
}
