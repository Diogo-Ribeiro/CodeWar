package org.academiadecodigo.codewar.gameobjects;

import org.academiadecodigo.codewar.representable.SimpleGfxGrid;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Represents all possible projectiles in the game with their picture.
 */
public enum ProjectileType {

    KISSY ("resources/54012f6264942f32f27114f45068fb87.png"),
    DICKY ("resources/avatar_a112a7e0bf35_128.png"),
    BUG ("resources/bug-alt-512.png"),
    QUESTION ("resources/00e8b7a51d52791be04e87acbe029132.png");

    /**
     * @param picture string of the path to resource directory.
     */
    private String picture;


    ProjectileType(String picture){

        this.picture = picture;
    }

    /**
     * draw the picture that represents the projectile
     * @return representable
     */
    public Picture getRepresentable() {

        Picture representable = new Picture(0,0,picture);
        //change size of picture.
        //divides to 2 because grow method enlarge dx to both sides.
        representable.grow((SimpleGfxGrid.CELL_SIZE*2 -representable.getWidth())/2, (SimpleGfxGrid.CELL_SIZE*2 - representable.getHeight())/2);
        //decrease size of picture.
        representable.translate(-representable.getX(), -representable.getY());
        return representable;
    }
}

