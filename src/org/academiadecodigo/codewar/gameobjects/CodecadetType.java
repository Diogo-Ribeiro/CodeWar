package org.academiadecodigo.codewar.gameobjects;

import org.academiadecodigo.codewar.representable.SimpleGfxGrid;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Enum with the codecadet types and his names.
 * Created by codecadet on 30/05/16.
 */

public enum CodecadetType {
    ANA("resources/Ana.png"),
    LAURA("resources/Laura.png"),
    NUNO("resources/Nuno.png"),
    HENRY("resources/Henry.png"),
    JOAO("resources/Joao.png"),
    SOFIA("resources/Sofia.png"),
    LUIS("resources/Luis.png"),
    DANIEL("resources/Daniel.png"),
    AMAURI("resources/Amauri.png"),
    ANDRE("resources/Andre.png"),
    IGOR("resources/Igor.png"),
    ELIAS("resources/Elias.png"),
    DIOGO("resources/Diogo.png"),
    FLAVIO("resources/Flavio.png"),
    BRUNO("resources/Bruno.png"),
    NELSON("resources/Nelson.png"),
    SAMUEL("resources/Samuel.png"),
    JORGE("resources/Jorge.png");

    private String picture;

    /**
     * The CodecadetType() recieves a string that is the path/reference of his picture and store this string into the "picture" local variable.
     *
     * @param picture
     */

    CodecadetType(String picture) {

        this.picture = picture;
    }

    /**
     * The getRepresentable() create and draw with a specified size, the picture of the codecadetType.
     *
     * @return Picture
     */

    public Picture getRepresentable() {

        Picture representable = new Picture(0, 0, picture);
        representable.grow((SimpleGfxGrid.CELL_SIZE * Char.AVATAR_DIMENSION - representable.getWidth()) / 2, (SimpleGfxGrid.CELL_SIZE * Char.AVATAR_DIMENSION - representable.getHeight()) / 2);
        representable.translate(-representable.getX(), -representable.getY());

        return representable;
    }
}
