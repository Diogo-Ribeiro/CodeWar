package org.academiadecodigo.codewar.representable;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;

/**
 * Created by codecadet on 25/05/16.
 */

public class SimpleGfxGrid implements Grid {

    public static final int CELL_SIZE = 20;
    private int cols;
    private int rows;

    public SimpleGfxGrid (int cols, int rows) {

        this.cols = cols;
        this.rows = rows;
    }

    public void init() {

        Picture bg = new Picture();
        bg.load("resources/animated-gif-of-fighting-games-backgrounds-16.gif");
        bg.grow((cols*CELL_SIZE - bg.getWidth())/2, (rows*CELL_SIZE - bg.getHeight())/2);
        bg.translate(-bg.getX(), -bg.getY());
        bg.draw();
    }

    public int getCols() {

        return cols;
    }

    public int getRows() {
        return rows;
    }

    @Override
    public SimpleGfxGridPosition makeGridPosition(Picture representable) {

        return new SimpleGfxGridPosition(this, representable);
    }

    @Override
    public GridPosition makeGridPosition(int col, int row, Picture representable) {

        return new SimpleGfxGridPosition(col, row, this, representable);
    }

    @Override
    public void stackOverflow() {

        Rectangle rectangle = new Rectangle(0, 0, cols*getCellSize(), rows*getCellSize());
        rectangle.setColor(Color.WHITE);
        rectangle.fill();

        Picture picture = new Picture();
        picture.load("Screen Shot 2016-06-01 at 10.57.52.png");
        picture.translate((rows*CELL_SIZE - picture.getHeight())/2, cols*CELL_SIZE - picture.getWidth());
        picture.draw();
    }

    @Override
    public void win() {

        Rectangle rectangle = new Rectangle(0, 0, cols*getCellSize(), rows*getCellSize());
        rectangle.setColor(Color.WHITE);
        rectangle.fill();

        Text text = new Text(150, 300, "You did it!");
        text.setColor(Color.BLACK);
        text.translate(cols*CELL_SIZE/2 - text.getWidth()/2, rows*CELL_SIZE/2 + text.getHeight()/2);
        text.draw();
    }

    @Override
    public int getCellSize() {
        return CELL_SIZE;
    }
}

