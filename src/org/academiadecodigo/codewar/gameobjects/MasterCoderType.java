package org.academiadecodigo.codewar.gameobjects;

import org.academiadecodigo.codewar.representable.SimpleGfxGrid;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Represents all the Master Coders in the game with their picture
 */
public enum MasterCoderType {

    MARIO ("MC MARIO.png"),
    ANTONINHO ("MC ANTONINHO.png"),
    ICEMAN ("MC SERGIO.png"),
    FERRAO ("MC FERRAO.png"),
    JOANA ("MC JOANA.png"),
    NUNO ("MC ANTONINHO.png");

    /**
     * @param picture path.
     */
    private String picture;

    MasterCoderType (String string) {
        this.picture = string;

    }

    /**
     * draw the picture tha represents de Master Coders.
     * @return representable
     */
    public Picture getRepresentable() {

        Picture representable = new Picture(0,0,picture);
        //change size of picture.
        //divides to 2 because grow method enlarge dx to both sides
        representable.grow((SimpleGfxGrid.CELL_SIZE*Char.AVATAR_DIMENSION-representable.getWidth())/2, (SimpleGfxGrid.CELL_SIZE*Char.AVATAR_DIMENSION - representable.getHeight())/2);
        //decrease size of picture
        representable.translate(-representable.getX(), -representable.getY());

        return representable;
    }
}
