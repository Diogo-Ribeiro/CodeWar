package org.academiadecodigo.codewar.gameobjects;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Created by diogocodecadet on 23/05/16.
 */
public enum ProjectileType {

    KISSY (0,0,5,5, Color.PINK),
    DICKY (0,0,5,5, Color.LIGHT_GRAY),
    BUG (0,0,5,5, Color.YELLOW),
    QUESTION (0,0,5,5, Color.DARK_GRAY);

    private Rectangle representable;

    ProjectileType (int a, int b, int c, int d, Color color) {

        representable = new Rectangle(a, b, c, d);
        representable.setColor(color);
        this.representable = representable;
    }

    public Rectangle getRepresentable() {
        return representable;
    }
}

