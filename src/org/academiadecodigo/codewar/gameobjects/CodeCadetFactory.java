package org.academiadecodigo.codewar.gameobjects;

import org.academiadecodigo.codewar.representable.Grid;

/**
 * Created by codecadet on 30/05/16.
 */
public class CodeCadetFactory {

    public static Codecadet make (Grid grid, CodecadetType type) {

        return new Codecadet(grid.makeGridPosition(grid.getCols() / 2, grid.getRows() - (Char.AVATAR_DIMENSION), CodecadetType.DIOGO.getRepresentable()));
    }
}
