package org.academiadecodigo.codewar.gameobjects;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Picture;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Created by diogocodecadet on 23/05/16.
 */
public enum ProjectileType {

    // TODO: 29/05/2016 how can we set the images?

    // TODO: Change color to adress of the pictures.
    KISSY (Color.PINK),
    DICKY (Color.LIGHT_GRAY),
    BUG (Color.YELLOW),
    QUESTION (Color.GREEN);

    private Color color;
    //TODO change Rectangle to more general representable

    //ProjectileType (int a, int b, int c, int d, Color color) {
    ProjectileType(Color color){
        this.color = color;

    }

    public Picture getRepresentable() {
        //TODO change new Rectangle to new Picture.
        Picture representable = new Picture(5, 5);
        representable.load("/Users/codecadet/Desktop/CodeWar/resources/00e8b7a51d52791be04e87acbe029132.png");
        System.out.println(representable);
        return representable;
    }
}

