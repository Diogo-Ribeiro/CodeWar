package org.academiadecodigo.codewar.gameobjects;

import org.academiadecodigo.codewar.representable.SimpleGfxGrid;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 30/05/16.
 */
public enum CodecadetType {
    ANA(""),
    LAURA(""),
    NUNO(""),
    HENRY(""),
    JOAO(""),
    SOFIA("Sofia.png"),
    LUIS(""),
    DANIEL("Daniel.png"),
    JORGE(""),
    AMAURI(""),
    ANDRE(""),
    IGOR("Igor.png"),
    ELIAS(""),
    DIOGO("Diogo.png"),
    FLAVIO("Flavio.png"),
    BRUNO(""),
    NELSON("Nelson.png"),
    SAMUEL("");

    private String picture;

    CodecadetType(String picture){

        this.picture = picture;

    }

    public static Picture getRepresentable() {

        Picture representable = new Picture(0,0,"Igor.png");
        representable.grow((SimpleGfxGrid.CELL_SIZE* Char.AVATAR_DIMENSION-representable.getWidth())/2, (SimpleGfxGrid.CELL_SIZE*Char.AVATAR_DIMENSION - representable.getHeight())/2);
        representable.translate(-representable.getX(), -representable.getY());

        return representable;
    }

}
