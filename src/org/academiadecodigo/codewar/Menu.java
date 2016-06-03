package org.academiadecodigo.codewar;

import org.academiadecodigo.codewar.gameobjects.Char;
import org.academiadecodigo.codewar.gameobjects.CodecadetType;
import org.academiadecodigo.codewar.representable.Grid;
import org.academiadecodigo.codewar.representable.SimpleGfxGrid;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import static org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent.*;

/**
 * Created by codecadet on 01/06/16.
 */
public class Menu implements KeyboardHandler {

    private Keyboard k;
    private Rectangle rectangle;
    private int i = 0;
    private boolean notDone = true;
    private Picture pic;
    private Grid grid;

    /**
     * Menu Constructor that recieves a grid.
     *
     * @param grid
     */
    public Menu(Grid grid) {
        this.grid = grid;
    }

    /**
     * Init method that initiate the game. Creates a grid with a picture "menu.jpg" and creates a grid.
     * The KeyBoardInput method is called here to be possible to select the codecadet.
     */

    public void init() {

        pic = new Picture();
        pic.load("resources/menu.jpg");
        pic.grow((grid.getCols() * grid.getCellSize() - pic.getWidth()) / 2, (grid.getRows() * grid.getCellSize() - pic.getHeight()) / 2);
        pic.translate(-pic.getX(), -pic.getY());
        pic.draw();


        rectangle = new Rectangle(0, 0, Char.AVATAR_DIMENSION * SimpleGfxGrid.CELL_SIZE, Char.AVATAR_DIMENSION * SimpleGfxGrid.CELL_SIZE);
        rectangle.setColor(Color.RED);
        rectangle.draw();
        registerKeyboardInput();
    }

    /**
     * The choose() method creates a grid of codecadets and for each one draws his picture.
     * Until the user press the Keyboard_K, the choose method stays in the while loop.
     * After the player make them choose, the choose method deletes all the codecadet's pictures and call method init() of the game grid.
     *
     * @return CodeCadetType
     * @throws InterruptedException
     */


    public CodecadetType choose() throws InterruptedException {

        Picture[] cadets = new Picture[CodecadetType.values().length];
        for (int i = 0; i < cadets.length; i++) {

            cadets[i] = CodecadetType.values()[i].getRepresentable();

            if (i > 0 && i < 9) {

                cadets[i].translate(cadets[i - 1].getMaxX(), 0);
            }

            if (i == 9) {

                cadets[i].translate(0, cadets[i].getHeight());
            }

            if (i > 9) {

                cadets[i].translate(cadets[i - 1].getMaxX(), cadets[i].getHeight());
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

    /**
     * The KeyPressed method recieves a keyboardEvent from the keyboard, and translate that Key input in a game action.
     * KEY_UP - Iterate and move the selection rectangle to Backwards.
     * KEY_DOWN - Iterate and move the selection rectangle to Forwards.
     * KEY_C - Select the codecadet and set the propriety notDone to false.
     *
     * @param keyboardEvent
     */

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {

            case KEY_UP:
                if (i == 9) {
                    rectangle.translate(Char.AVATAR_DIMENSION * SimpleGfxGrid.CELL_SIZE * 8, -Char.AVATAR_DIMENSION * SimpleGfxGrid.CELL_SIZE);
                    i--;
                } else if (i <= 17 && i > 0) {
                    rectangle.translate(-Char.AVATAR_DIMENSION * SimpleGfxGrid.CELL_SIZE, 0);
                    i--;
                }
                break;

            case KEY_DOWN:

                if (i == 8) {
                    rectangle.translate(-Char.AVATAR_DIMENSION * SimpleGfxGrid.CELL_SIZE * 8, Char.AVATAR_DIMENSION * SimpleGfxGrid.CELL_SIZE);
                    i++;
                } else if (i >= 0 && i < 17) {
                    rectangle.translate(Char.AVATAR_DIMENSION * SimpleGfxGrid.CELL_SIZE, 0);
                    i++;
                }
                break;

            case KEY_C:
                notDone = false;
                break;
        }
    }

    /**
     * Does nothing at all.
     *
     * @param keyboardEvent
     */
    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    /**
     * The registerKeyboardInput register the keyboard keys and add the keyboardEvent to the EventListener.
     */
    private void registerKeyboardInput() {

        k = new Keyboard(this);

        KeyboardEvent event = new KeyboardEvent();
        event.setKey(KeyboardEvent.KEY_UP);
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(event);

        KeyboardEvent event1 = new KeyboardEvent();
        event1.setKey(KeyboardEvent.KEY_DOWN);
        event1.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(event1);

        KeyboardEvent event2 = new KeyboardEvent();
        event2.setKey(KeyboardEvent.KEY_C);
        event2.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(event2);
    }
}
