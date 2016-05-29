package org.academiadecodigo.codewar.representable;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;

/**
 * Created by codecadet on 25/05/16.
 */
public class SimpleGfxGrid implements Grid {

    public static final int CELL_SIZE = 10;
    private int cols;
    private int rows;


    public SimpleGfxGrid (int cols, int rows) {

        this.cols = cols;
        this.rows = rows;
    }

    public void init() {

        Rectangle rectangle = new Rectangle(0, 0, cols*CELL_SIZE, rows*CELL_SIZE);
        rectangle.setColor(Color.BLACK);
        rectangle.draw();

    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }

    public SimpleGfxGridPosition makeGridPosition(Rectangle representable) {
        return new SimpleGfxGridPosition(this, representable);

    }

    public SimpleGfxGridPosition makeGridPosition(int col, int row, Rectangle representable) {
        return new SimpleGfxGridPosition(col, row, this, representable);
    }

    public static void gameOver() {

        Rectangle rectangle = new Rectangle(0, 0, 400, 600);
        rectangle.fill();

        Text text = new Text(200, 300, "STACK OVERFLOW");
        text.setColor(Color.RED);
        text.draw();

    }
}

