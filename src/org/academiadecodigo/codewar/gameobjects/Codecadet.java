package org.academiadecodigo.codewar.gameobjects;

import org.academiadecodigo.codewar.Direction;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

/**
 * Created by diogocodecadet on 23/05/16.
 */
public class Codecadet extends Char implements KeyboardHandler{
    // TODO: 24/05/16 one char for each codecadet and associated game mode

    private boolean moving;
    Keyboard k;

    public Codecadet(){

    }

    @Override
    public void move ( ){

        while (moving) {

            System.out.println(currentDirection);

        }

    }


    @Override
    public Projectile shoot(){
        //should I get the playerProjectiles[]? or should we have some sort of collision checker?
        return new Projectile();
    }

    public void dead () {

    }

    public void setMoving(boolean moving) {

        this.moving = moving;
    }


    @Override
    public void keyPressed(KeyboardEvent e){

        switch (e.getKey()){
            case KeyboardEvent.KEY_LEFT:
                currentDirection = Direction.LEFT;
            break;

            case KeyboardEvent.KEY_RIGHT:
                currentDirection = Direction.RIGHT;
        }

    }

    @Override
    public void keyReleased(KeyboardEvent e){

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
        event2.setKey(KeyboardEvent.KEY_B);
        event2.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(event2);

        KeyboardEvent event3 = new KeyboardEvent();
        event3.setKey(KeyboardEvent.KEY_SPACE);
        event3.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(event3);
    }



}
