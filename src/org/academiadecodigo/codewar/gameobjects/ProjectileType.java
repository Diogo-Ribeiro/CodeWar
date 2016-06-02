package org.academiadecodigo.codewar.gameobjects;

import org.academiadecodigo.codewar.representable.SimpleGfxGrid;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by diogocodecadet on 23/05/16.
 */
public enum ProjectileType {

    KISSY ("54012f6264942f32f27114f45068fb87.png"),
    DICKY ("avatar_a112a7e0bf35_128.png"),
    BUG ("bug-alt-512.png"),
    QUESTION ("00e8b7a51d52791be04e87acbe029132.png");

    private String picture;

    ProjectileType(String picture){

        this.picture = picture;
    }

    public Picture getRepresentable() {

        Picture representable = new Picture(0,0,picture);
        representable.grow((SimpleGfxGrid.CELL_SIZE*2 -representable.getWidth())/2, (SimpleGfxGrid.CELL_SIZE*2 - representable.getHeight())/2);
        representable.translate(-representable.getX(), -representable.getY());

        return representable;
    }
}

