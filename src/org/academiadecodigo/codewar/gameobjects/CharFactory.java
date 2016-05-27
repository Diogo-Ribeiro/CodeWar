package org.academiadecodigo.codewar.gameobjects;

import org.academiadecodigo.codewar.representable.Grid;
import org.academiadecodigo.codewar.representable.SimpleGfxGrid;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Created by diogocodecadet on 23/05/16.
 */
public class CharFactory {

    public static Char[] charMaker (SimpleGfxGrid grid) {

        Char[] chars = new Char[MasterCoderType.values().length + 1];

        chars[0] = new Codecadet(grid.makeGridPosition(grid.getCols()/2, grid.getRows()-1, new Rectangle(0,0,10,10)));

        for (int i = 1; i < chars.length; i++) {

            chars[i] = new MasterCoder(MasterCoderType.values()[i-1], grid.makeGridPosition(MasterCoderType.values()[i-1].getRepresentable()));
        }

        return chars;
    }
}

