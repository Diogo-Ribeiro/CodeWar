package org.academiadecodigo.codewar.gameobjects;

import org.academiadecodigo.codewar.representable.Grid;

/**
 * Create Code Cadet.
 */
public class CodeCadetFactory {


    /**
     * @param grid
     * @param type
     * @return Code Cadet in the middle of the grid.
     */
    public static Codecadet make (Grid grid, CodecadetType type) {

        return new Codecadet(grid.makeGridPosition(grid.getCols() / 2, grid.getRows() - (Char.AVATAR_DIMENSION), type.getRepresentable()));
    }
}
