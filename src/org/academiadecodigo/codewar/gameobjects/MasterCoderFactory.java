package org.academiadecodigo.codewar.gameobjects;

import org.academiadecodigo.codewar.representable.Grid;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.LinkedList;

/**
 * Create all Master Coders.
 */
public class MasterCoderFactory {

    /**
     * Create an array with all de Master Coders.
     * @param grid
     * @return Master Coders with a position.
     */
    public static MasterCoder[] maker(Grid grid) {


        MasterCoder[] masterCoders = new MasterCoder[MasterCoderType.values().length];

        for (int i = 0; i < masterCoders.length; i++) {

            masterCoders[i] = new MasterCoder(MasterCoderType.values()[i], grid.makeGridPosition(MasterCoderType.values()[i].getRepresentable()));
        }

        return masterCoders;
    }
}

