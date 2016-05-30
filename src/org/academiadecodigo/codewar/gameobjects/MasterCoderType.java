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

    MARIO ("/Users/codecadet/Desktop/CodeWar/resources/MC MARIO.png"),
    ANTONINHO ("/Users/codecadet/Desktop/CodeWar/resources/MC ANTONINHO.png"),
    ICEMAN ("/Users/codecadet/Desktop/CodeWar/resources/MC SERGIO.png"),
    FERRAO ("/Users/codecadet/Desktop/CodeWar/resources/MC FERRAO.png"),
    JOANA ("/Users/codecadet/Desktop/CodeWar/resources/MC JOANA.png"),
    NUNO ("/Users/codecadet/Desktop/CodeWar/resources/MC ANTONINHO.png");


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
