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

    /**
     * Constructor for class SimpleGfxGrid.
     * @param cols number of grid columns
     * @param rows number of grid rows
     */
    public SimpleGfxGrid (int cols, int rows) {

        this.cols = cols;
        this.rows = rows;
    }

    /**
     * initializes the simple-graphics grid.
     */
    public void init() {

        Picture bg = new Picture();
        bg.load("resources/animated-gif-of-fighting-games-backgrounds-16.gif");
        bg.grow((cols*CELL_SIZE - bg.getWidth())/2, (rows*CELL_SIZE - bg.getHeight())/2);
        bg.translate(-bg.getX(), -bg.getY());
        bg.draw();
    }

    /**
     * returns the number of columns.
     * @return number of columns
     */
    public int getCols() {

        return cols;
    }

    /**
     * returns the number of rows.
     * @return number of rows
     */
    public int getRows() {
        return rows;
    }

    /**
     * receives a game representable and returns its random grid position.
     * @param representable picture representing any game object
     * @return simple-graphics random grid position
     */
    @Override
    public SimpleGfxGridPosition makeGridPosition(Picture representable) {

        return new SimpleGfxGridPosition(this, representable);
    }

    /**
     * receives a game representable and returns its fixed grid position.
     * @param col position column
     * @param row position row
     * @param representable picture representing any game object
     * @return simple-graphics fixed grid position
     */
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

