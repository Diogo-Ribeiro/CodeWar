package org.academiadecodigo.codewar.gameobjects;

import org.academiadecodigo.codewar.representable.Representable;
import org.academiadecodigo.codewar.representable.SimpleGfxGrid;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Created by diogocodecadet on 23/05/16.
 */
public enum MasterCoderType {

    MARIO ("resources/MC MARIO.png"),
    ANTONINHO ("resources/MC ANTONINHO.png"),
    ICEMAN ("resources/MC SERGIO.png"),
    FERRAO ("resources/MC FERRAO.png"),
    JOANA ("resources/MC JOANA.png"),
    NUNO ("resources/MC ANTONINHO.png");


    private String picture;

    MasterCoderType (String string) {
        this.picture = string;

    }

    public Picture getRepresentable() {

        Picture representable = new Picture(0,0,picture);
        representable.grow((SimpleGfxGrid.CELL_SIZE*2-representable.getWidth())/2, (SimpleGfxGrid.CELL_SIZE*2 - representable.getHeight())/2);
        representable.translate(-representable.getX(), -representable.getY());

        return representable;
    }
}
