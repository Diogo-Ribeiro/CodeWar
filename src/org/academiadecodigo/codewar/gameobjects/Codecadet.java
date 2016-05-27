package org.academiadecodigo.codewar.gameobjects;

import org.academiadecodigo.codewar.Direction;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

/**
 * Created by diogocodecadet on 23/05/16.
 */
public class Codecadet extends Char implements KeyboardHandler {
    // TODO: 24/05/16 one char for each codecadet and associated game mode

    private boolean moving;
    Keyboard k;


    public Codecadet(){

        registerKeyboardInput();
    }

    @Override
    public void move (){

        if(moving) {

            System.out.println(getCurrentDirection());


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

    public boolean getMoving(){
        return moving;
    }


    @Override
    public void keyPressed(KeyboardEvent e){

        switch (e.getKey()){
            case KeyboardEvent.KEY_LEFT:
                setCurrentDirection(Direction.LEFT);
                setMoving(true);
            break;

            case KeyboardEvent.KEY_RIGHT:
                setCurrentDirection(Direction.RIGHT);
                setMoving(true);
                break;
            case KeyboardEvent.KEY_B:
                System.out.println("Special shoot");
                shoot();
                break;
            case KeyboardEvent.KEY_SPACE:
                System.out.println("Shoot");
                shoot();
                break;
        }

    }

    @Override
    public void keyReleased(KeyboardEvent e){
        setMoving(false);

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


        KeyboardEvent event4 = new KeyboardEvent();
        event4.setKey(KeyboardEvent.KEY_LEFT);
        event4.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        k.addEventListener(event4);

        KeyboardEvent event5 = new KeyboardEvent();
        event5.setKey(KeyboardEvent.KEY_RIGHT);
        event5.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        k.addEventListener(event5);
    }



}
