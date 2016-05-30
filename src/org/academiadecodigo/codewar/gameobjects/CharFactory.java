package org.academiadecodigo.codewar.gameobjects;

import org.academiadecodigo.codewar.representable.Grid;
import org.academiadecodigo.codewar.representable.SimpleGfxGrid;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Created by diogocodecadet on 23/05/16.
 */
public class CharFactory {

    public static Char[] charMaker (Grid grid) {


        Char[] chars = new Char[MasterCoderType.values().length + 1];

        // TODO: 29/05/2016 move the position making logic to codecadet
        //Class char receives "GridPosition" as argument. Here we use SimpleGfxGrid's method makeGridPosition (returns GridPosition)
        //Should we change the method makeGridPosition to interface in order to generalize ?
        chars[0] = new Codecadet(grid.makeGridPosition(grid.getCols()/2, grid.getRows()-1, new Picture(10,10)));

        for (int i = 1; i < chars.length; i++) {

            chars[i] = new MasterCoder(MasterCoderType.values()[i-1], grid.makeGridPosition(MasterCoderType.values()[i-1].getRepresentable()));
        }

        return chars;
    }
}

