package org.academiadecodigo.codewar.gameobjects;

/**
 * Created by diogocodecadet on 23/05/16.
 */
public class CharFactory {

    public static Char[] charMaker () {

        Char[] chars = new Char[MasterCoderType.values().length + 1];

        chars[0] = new Codecadet();

        for (int i = 1; i < chars.length; i++) {

            chars[i] = new MasterCoder(MasterCoderType.values()[i-1]);
        }

        return chars;
    }
}

