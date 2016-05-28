package org.academiadecodigo.codewar;

import org.academiadecodigo.codewar.gameobjects.*;
import org.academiadecodigo.codewar.representable.SimpleGfxGrid;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

/**
 * Created by diogocodecadet on 23/05/16.
 */
public class Game implements KeyboardHandler {

    public static final int MASTER_CODERS = MasterCoderType.values().length;
    public static final int MAX_PROJECTILES = 5;
    Keyboard k;

    Char[] chars;
    Projectile[] playerProjectiles;
    Projectile[] MCProjectiles;
    SimpleGfxGrid grid = new SimpleGfxGrid(40, 60);

    public Game () {

        // TODO: 25/05/16 init or constructor?
        chars = new Char[MASTER_CODERS + 1];
        playerProjectiles = new Projectile[MAX_PROJECTILES];
        MCProjectiles = new Projectile[(MAX_PROJECTILES/2)*MASTER_CODERS];
        registerKeyboardInput();

    }

    public void init () {

        grid.init();
        chars = CharFactory.charMaker(grid);

    }

    public void start () throws InterruptedException {

        while (!chars[0].isDead()) {

            for (int i = 0; i < chars.length; i++) {

                chars[i].move();
            }

            masterCodersShoot();
            updateProjectiles();

            checkCollisions (MCProjectiles, playerProjectiles, chars);
            Thread.sleep(100);
        }

        SimpleGfxGrid.gameOver();
    }

    private void checkCollisions(Projectile[] mcProjectiles, Projectile[] playerProjectiles, Char[] chars) {

        CollisionChecker.check(mcProjectiles, chars);
    }

    private void codeCadetShoot() {

        Projectile currentProjectile = chars[0].shoot();

        if (currentProjectile != null) {

            for (int i = 0; i < playerProjectiles.length; i++) {

                if (playerProjectiles[i] == null) {

                    playerProjectiles[i] = currentProjectile;
                    break;
                }
            }
        }
    }

    private void masterCodersShoot () {

        for (int j = 1; j < 2; j++) {

            if (chars[j] != null) {

                Projectile currentProjectile = chars[j].shoot();

                if (currentProjectile != null) {

                    for (int i = 0; i < MCProjectiles.length; i++) {

                        if (MCProjectiles[i] == null) {

                            MCProjectiles[i] = currentProjectile;
                            break;
                        }
                    }
                }
            }
        }
    }

    private void updateProjectiles () {

        for (int i = 0; i < MCProjectiles.length; i++) {

            if (MCProjectiles[i] != null) {

                if (MCProjectiles[i].isHitTarget()) {

                    MCProjectiles[i] = null;

                } else {

                    MCProjectiles[i].move();
                }
            }
        }

        for (int i = 0; i < playerProjectiles.length; i++) {

            if (playerProjectiles[i] != null) {

                if (playerProjectiles[i].isHitTarget()) {

                   playerProjectiles[i] = null;

                } else {

                    playerProjectiles[i].move();
                }
            }
        }
    }

    public void keyPressed(KeyboardEvent e) {

        switch (e.getKey()) {
            case KeyboardEvent.KEY_LEFT:

            chars[0].setCurrentDirection(Direction.LEFT);
            ((Codecadet)chars[0]).setMoving(true);
            break;

            case KeyboardEvent.KEY_RIGHT:

            chars[0].setCurrentDirection(Direction.RIGHT);
            ((Codecadet)chars[0]).setMoving(true);
            break;

            case KeyboardEvent.KEY_SPACE:
                codeCadetShoot();
                break;
            case KeyboardEvent.KEY_B:
                ((Codecadet)chars[0]).specialShoot();
        }
    }

    public void keyReleased(KeyboardEvent e) {

        switch (e.getKey()) {
            case KeyboardEvent.KEY_LEFT:

                chars[0].setCurrentDirection(Direction.LEFT);
                ((Codecadet)chars[0]).setMoving(false);
                break;

            case KeyboardEvent.KEY_RIGHT:

                chars[0].setCurrentDirection(Direction.RIGHT);
                ((Codecadet)chars[0]).setMoving(false);
                break;

        }
    }

    private void registerKeyboardInput() {
        k = new Keyboard(this);


        KeyboardEvent event5 = new KeyboardEvent();
        event5.setKey(KeyboardEvent.KEY_SPACE);
        event5.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(event5);

        /*KeyboardEvent event6 = new KeyboardEvent();
        event6.setKey(KeyboardEvent.KEY_SPACE);
        event6.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        k.addEventListener(event6);
*/
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
    }
}



