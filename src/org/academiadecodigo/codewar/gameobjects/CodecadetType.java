package org.academiadecodigo.codewar.gameobjects;

import org.academiadecodigo.codewar.representable.SimpleGfxGrid;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 30/05/16.
 */
public enum CodecadetType {
    ANA("Ana.png"),
    LAURA("Laura.png"),
    NUNO("Nuno.png"),
    HENRY("Henry.png"),
    JOAO("Joao.png"),
    SOFIA("Sofia.png"),
    LUIS("Luis.png"),
    DANIEL("Daniel.png"),
    AMAURI("Amauri.png"),
    ANDRE("Andre.png"),
    IGOR("Igor.png"),
    ELIAS("Elias.png"),
    DIOGO("Diogo.png"),
    FLAVIO("Flavio.png"),
    BRUNO("Bruno.png"),
    NELSON("Nelson.png"),
    SAMUEL("Samuel.png"),
    JORGE("Jorge.png");

    private String picture;

    CodecadetType(String picture){

        this.picture = picture;
    }

    public Picture getRepresentable() {

        Picture representable = new Picture(0,0,picture);
        representable.grow((SimpleGfxGrid.CELL_SIZE* Char.AVATAR_DIMENSION-representable.getWidth())/2, (SimpleGfxGrid.CELL_SIZE*Char.AVATAR_DIMENSION - representable.getHeight())/2);
        representable.translate(-representable.getX(), -representable.getY());

        return representable;
    }
}
