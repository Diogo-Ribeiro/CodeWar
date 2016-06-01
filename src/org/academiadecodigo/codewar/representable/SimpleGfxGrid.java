package org.academiadecodigo.codewar.representable;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

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

        Picture pic = new Picture();
        pic.load("/Users/codecadet/Desktop/CodeWar/resources/animated-gif-of-fighting-games-backgrounds-16.gif");
        pic.grow((cols*CELL_SIZE - pic.getWidth())/2, (rows*CELL_SIZE - pic.getHeight())/2);
        pic.translate(-pic.getX(), -pic.getY());
        pic.draw();

//        Rectangle rectangle = new Rectangle(0, 0, cols*CELL_SIZE, rows*CELL_SIZE);
//        rectangle.setColor(Color.BLACK);
//        rectangle.draw();
    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }

    @Override
    //TODO: 29/05/2016 Change argument Rectangle to more general representable
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

        Text text = new Text(0, 0, "You did it!");
        text.setColor(Color.BLACK);
        text.translate(cols*CELL_SIZE/2 - text.getWidth()/2, rows*CELL_SIZE/2 + text.getHeight()/2);
        text.draw();
    }

    @Override
    public int getCellSize() {
        return CELL_SIZE;
    }
}

