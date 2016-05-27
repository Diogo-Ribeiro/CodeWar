package org.academiadecodigo.codewar.gameobjects;

import org.academiadecodigo.codewar.representable.Representable;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Created by diogocodecadet on 23/05/16.
 */
public enum MasterCoderType {

    MARIO (new Rectangle(0,0,10,10), Color.BLACK),
    ANTONINHO (new Rectangle(0,0,10,10), Color.RED),
    ICEMAN (new Rectangle(0,0,10,10), Color.GREEN),
    FERRAO (new Rectangle(0,0,10,10), Color.CYAN),
    JOANA (new Rectangle(0,0,10,10), Color.MAGENTA),
    NUNO (new Rectangle(0,0,10,10), Color.ORANGE);

    private Rectangle representable;

    MasterCoderType (Rectangle representable, Color color) {

        representable.setColor(color);
        this.representable = representable;
    }

    public Rectangle getRepresentable() {
        return representable;
    }
}
