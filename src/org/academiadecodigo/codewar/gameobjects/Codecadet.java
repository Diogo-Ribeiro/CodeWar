package org.academiadecodigo.codewar.gameobjects;

import org.academiadecodigo.codewar.Direction;
import org.academiadecodigo.codewar.representable.Grid;
import org.academiadecodigo.codewar.representable.SimpleGfxGrid;
import org.academiadecodigo.codewar.representable.SimpleGfxGridPosition;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

/**
 * Created by diogocodecadet on 23/05/16.
 */
public class Codecadet extends Char{
    // TODO: 24/05/16 one char for each codecadet and associated game mode


    private boolean moving;
    //// TODO: 28/05/2016 find better name
    private int kissyCounter;

    public Codecadet(SimpleGfxGridPosition position) {

        super(position);

    }

    @Override
    public void move () {

        if (true) {

            if (moving) {

                getPosition().move(this.getCurrentDirection(), 1);

                System.out.println(this.getPosition().getCol());
            }
        }
    }

    @Override
    public void getHit(Projectile projectile) {

        System.out.println(projectile.getType());
        if (projectile.getType() == ProjectileType.KISSY) {

            kissyCounter++;

        } else if (projectile.getType() == ProjectileType.DICKY) {

            lowerHP();
        }
    }

    public Projectile shoot() {

        return ProjectileFactory.get(ProjectileType.QUESTION, this.getPosition(), Direction.UP);
    }

    public Projectile specialShoot() {

        System.out.println(kissyCounter);
        if (kissyCounter == 4) {

            kissyCounter = 0;
            return ProjectileFactory.get(ProjectileType.BUG, this.getPosition(), Direction.UP);

        }

        return null;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }
}

 /*   public void keyPressed(KeyboardEvent e) {

        switch (e.getKey()) {
            case KeyboardEvent.KEY_LEFT:

                setCurrentDirection(Direction.LEFT);
                setMoving(true);
                break;

            case KeyboardEvent.KEY_RIGHT:

                setCurrentDirection(Direction.RIGHT);
                setMoving(true);
                break;
        }
    }

    public void keyReleased(KeyboardEvent e) {

        switch (e.getKey()) {
            case KeyboardEvent.KEY_LEFT:
                setMoving(false);
                break;

            case KeyboardEvent.KEY_RIGHT:
                setMoving(false);
                break;

        }
    }

    private void registerKeyboardInput() {
        k = new Keyboard(this);

        KeyboardEvent event = new KeyboardEvent();
        event.setKey(KeyboardEvent.KEY_LEFT);
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(event);

        KeyboardEvent event1 = new KeyboardEvent();
        event1.setKey(KeyboardEvent.KEY_LEFT);
        event1.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        k.addEventListener(event1);

        KeyboardEvent event2 = new KeyboardEvent();
        event2.setKey(KeyboardEvent.KEY_RIGHT);
        event2.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(event2);

        KeyboardEvent event3 = new KeyboardEvent();
        event3.setKey(KeyboardEvent.KEY_RIGHT);
        event3.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        k.addEventListener(event3);

        KeyboardEvent event4 = new KeyboardEvent();
        event4.setKey(KeyboardEvent.KEY_B);
        event4.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(event4);

        KeyboardEvent event5 = new KeyboardEvent();
        event5.setKey(KeyboardEvent.KEY_SPACE);
        event5.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(event5);
    }
}
*/