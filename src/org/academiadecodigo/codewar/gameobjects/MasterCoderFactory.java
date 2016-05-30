package org.academiadecodigo.codewar.gameobjects;

import org.academiadecodigo.codewar.representable.Grid;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.LinkedList;

/**
 * Created by diogocodecadet on 23/05/16.
 */
public class MasterCoderFactory {

    public static MasterCoder[] maker(Grid grid) {


        MasterCoder[] masterCoders = new MasterCoder[MasterCoderType.values().length];

        for (int i = 0; i < masterCoders.length; i++) {

            masterCoders[i] = new MasterCoder(MasterCoderType.values()[i], grid.makeGridPosition(MasterCoderType.values()[i].getRepresentable()));
        }

        return masterCoders;
    }


}

