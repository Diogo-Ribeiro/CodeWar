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
public class Game implements KeyboardHandler{

    public static final int MASTER_CODERS = MasterCoderType.values().length;
    public static final int MAX_PROJECTILES = 5;
    Keyboard k;

    Char[] chars;
    Projectile[] playerProjectiles;
    Projectile[] MCProjectiles;
    SimpleGfxGrid grid = new SimpleGfxGrid(40, 80);

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

            for (int i = 1; i < chars.length; i++) {

                chars[i].move(grid);
            }

            //masterCodersShoot();
            //updateProjectiles();
            Thread.sleep(200);
        }
    }

    private void masterCodersShoot () {

        // TODO: 25/05/16
        for (int j = 1; j < chars.length; j++) {

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

            //if (MCProjectiles[i].reachedEdge()) {
            //MCProjectiles[i] = null;
            //  }
            System.out.println(MCProjectiles[i]);
        }
    }


    public void keyPressed(KeyboardEvent e) {

        switch (e.getKey()) {
            case KeyboardEvent.KEY_LEFT:

                chars[0].setCurrentDirection(Direction.LEFT);
                chars[0].move(grid);
                break;

            case KeyboardEvent.KEY_RIGHT:

                chars[0].setCurrentDirection(Direction.RIGHT);
                chars[0].move(grid);
                break;

            case KeyboardEvent.KEY_SPACE:
                System.out.println("space");
                break;
        }
    }

    public void keyReleased(KeyboardEvent e) {

    }

    private void registerKeyboardInput() {
        k = new Keyboard(this);

        KeyboardEvent event = new KeyboardEvent();
        event.setKey(KeyboardEvent.KEY_LEFT);
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(event);

        KeyboardEvent event2 = new KeyboardEvent();
        event2.setKey(KeyboardEvent.KEY_RIGHT);
        event2.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(event2);

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

