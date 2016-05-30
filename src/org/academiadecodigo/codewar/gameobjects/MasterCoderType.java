package org.academiadecodigo.codewar.gameobjects;

import org.academiadecodigo.codewar.representable.Representable;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Picture;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Created by diogocodecadet on 23/05/16.
 */
public enum MasterCoderType {

    MARIO (new Picture(10,10), "https://apkplz.com/storage/images/com/whileone/mastercode/300/master-code.png"),
    ANTONINHO (new Picture(10,10),"https://apkplz.com/storage/images/com/whileone/mastercode/300/master-code.png"),
    ICEMAN (new Picture(10,10),"https://apkplz.com/storage/images/com/whileone/mastercode/300/master-code.png"),
    FERRAO (new Picture(10,10),"https://apkplz.com/storage/images/com/whileone/mastercode/300/master-code.png"),
    JOANA (new Picture(10,10),"https://apkplz.com/storage/images/com/whileone/mastercode/300/master-code.png"),
    NUNO (new Picture(10,10),"https://apkplz.com/storage/images/com/whileone/mastercode/300/master-code.png");

    private Picture representable;
    private Picture picture;

    MasterCoderType (Picture representable, String pic) {
        this.picture = representable;
        representable.load(pic);

    }

    public Picture getRepresentable() {
        return picture;
    }
}
