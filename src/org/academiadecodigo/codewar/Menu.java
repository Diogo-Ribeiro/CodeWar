package org.academiadecodigo.codewar;

import org.academiadecodigo.codewar.gameobjects.Char;
import org.academiadecodigo.codewar.gameobjects.CodecadetType;
import org.academiadecodigo.codewar.representable.Grid;
import org.academiadecodigo.codewar.representable.SimpleGfxGrid;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import static org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent.*;

/**
 * Created by codecadet on 01/06/16.
 */
public class Menu implements KeyboardHandler{

    private Keyboard k;
    private Rectangle rectangle;
    private int i = 0;
    private boolean notDone = true;
    private Picture pic;
    private Grid grid;

    public Menu(Grid grid) {
        this.grid = grid;
    }

    public void init() {

        pic = new Picture();
        pic.load("resources/menu.jpg");
        pic.grow((grid.getCols()*grid.getCellSize() - pic.getWidth())/2, (grid.getRows()*grid.getCellSize()- pic.getHeight())/2);
        pic.translate(-pic.getX(), -pic.getY());
        pic.draw();


        rectangle = new Rectangle(0,0,Char.AVATAR_DIMENSION* SimpleGfxGrid.CELL_SIZE, Char.AVATAR_DIMENSION* SimpleGfxGrid.CELL_SIZE);
        rectangle.setColor(Color.RED);
        rectangle.draw();
        registerKeyboardInput();
    }

    public CodecadetType choose() throws InterruptedException {

        Picture[] cadets = new Picture[CodecadetType.values().length];
        for (int i = 0; i < cadets.length; i++ ) {

            cadets[i] = CodecadetType.values()[i].getRepresentable();

            if (i > 0 && i < 9) {

                cadets[i].translate(cadets[i - 1].getMaxX(), 0);
            }

            if (i == 9) {

                cadets[i].translate(0, cadets[i].getHeight());
            }

            if (i > 9) {

                cadets[i].translate(cadets[i-1].getMaxX(), cadets[i].getHeight());
            }

            cadets[i].draw();
        }

        while (notDone) {

            Thread.sleep(100);
        }

        for (int i = 0; i < cadets.length; i++) {

            cadets[i].delete();
        }

        rectangle.delete();
        pic.delete();
        grid.init();

        return CodecadetType.values()[i];
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {

            case KEY_LEFT:
                if (i == 9) {
                    rectangle.translate(Char.AVATAR_DIMENSION* SimpleGfxGrid.CELL_SIZE*8, -Char.AVATAR_DIMENSION* SimpleGfxGrid.CELL_SIZE);
                    i--;
                } else if (i <= 17 && i > 0) {
                    rectangle.translate(-Char.AVATAR_DIMENSION* SimpleGfxGrid.CELL_SIZE, 0);
                    i--;
                }
                break;

            case KEY_RIGHT:

                if (i == 8) {
                    rectangle.translate(-Char.AVATAR_DIMENSION* SimpleGfxGrid.CELL_SIZE*8, Char.AVATAR_DIMENSION* SimpleGfxGrid.CELL_SIZE);
                    i ++;
                } else if (i >= 0 && i < 17) {
                    rectangle.translate(Char.AVATAR_DIMENSION* SimpleGfxGrid.CELL_SIZE, 0);
                    i ++;
                }
                break;

            case KEY_C:
                notDone = false;
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    private void registerKeyboardInput() {

        k = new Keyboard(this);

        KeyboardEvent event = new KeyboardEvent();
        event.setKey(KeyboardEvent.KEY_LEFT);
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(event);

        KeyboardEvent event1 = new KeyboardEvent();
        event1.setKey(KeyboardEvent.KEY_RIGHT);
        event1.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(event1);

        KeyboardEvent event2 = new KeyboardEvent();
        event2.setKey(KeyboardEvent.KEY_C);
        event2.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(event2);
    }
}
