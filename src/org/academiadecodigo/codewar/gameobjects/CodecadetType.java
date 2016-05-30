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
    SOFIA("/Users/codecadet/Desktop/CodeWar/resources/Sofia.png"),
    LUIS(""),
    DANIEL("/Users/codecadet/Desktop/CodeWar/resources/Daniel.png"),
    JORGE(""),
    AMAURI(""),
    ANDRE(""),
    IGOR("/Users/codecadet/Desktop/CodeWar/resources/Igor.png"),
    ELIAS(""),
    DIOGO("/Users/codecadet/Desktop/CodeWar/resources/Diogo.png"),
    FLAVIO("/Users/codecadet/Desktop/CodeWar/resources/Flavio.png"),
    BRUNO(""),
    NELSON("/Users/codecadet/Desktop/CodeWar/resources/Nelson.png"),
    SAMUEL("");

    private String picture;

    CodecadetType(String picture){

        this.picture = picture;

    }

    public static Picture getRepresentable() {

        Picture representable = new Picture(0,0,"/Users/codecadet/Desktop/CodeWar/resources/Igor.png");
        representable.grow((SimpleGfxGrid.CELL_SIZE*2-representable.getWidth())/2, (SimpleGfxGrid.CELL_SIZE*2 - representable.getHeight())/2);
        representable.translate(-representable.getX(), -representable.getY());

        return representable;
    }

}
