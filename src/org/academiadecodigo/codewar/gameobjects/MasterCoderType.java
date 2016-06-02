package org.academiadecodigo.codewar.gameobjects;

import org.academiadecodigo.codewar.representable.SimpleGfxGrid;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by diogocodecadet on 23/05/16.
 */
public enum MasterCoderType {

    MARIO ("MC MARIO.png"),
    ANTONINHO ("MC ANTONINHO.png"),
    ICEMAN ("MC SERGIO.png"),
    FERRAO ("MC FERRAO.png"),
    JOANA ("MC JOANA.png"),
    NUNO ("MC ANTONINHO.png");

    private String picture;

    MasterCoderType (String string) {
        this.picture = string;

    }

    public Picture getRepresentable() {

        Picture representable = new Picture(0,0,picture);
        representable.grow((SimpleGfxGrid.CELL_SIZE*Char.AVATAR_DIMENSION-representable.getWidth())/2, (SimpleGfxGrid.CELL_SIZE*Char.AVATAR_DIMENSION - representable.getHeight())/2);
        representable.translate(-representable.getX(), -representable.getY());

        return representable;
    }
}
