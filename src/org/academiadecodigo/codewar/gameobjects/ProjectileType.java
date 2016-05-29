package org.academiadecodigo.codewar.gameobjects;

import org.academiadecodigo.simplegraphics.graphics.Color;
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
    private Rectangle representable;

    //ProjectileType (int a, int b, int c, int d, Color color) {
    ProjectileType(Color color){
        this.color = color;

    }

    public Rectangle getRepresentable() {
        //TODO change new Rectangle to new Picture.
        representable = new Rectangle(0,0,5,5);
        representable.setColor(color);
        System.out.println(representable);
        return representable;
    }
}

