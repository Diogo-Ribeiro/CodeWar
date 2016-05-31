package org.academiadecodigo.codewar;

import org.academiadecodigo.codewar.gameobjects.*;
import org.academiadecodigo.codewar.representable.Grid;
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

    private Keyboard k;

    // TODO: 29/05/2016 separate player from other chars
    private Char[] chars;
    private Projectile[] playerProjectiles;
    private Projectile[] masterCoderProjectiles;
    private Grid grid = new SimpleGfxGrid(40, 45);

    public Game () {

        // TODO: 25/05/16 init or constructor?
        // TODO: 29/05/2016 player selection
        chars = new Char[MASTER_CODERS + 1];
        playerProjectiles = new Projectile[MAX_PROJECTILES];
        masterCoderProjectiles = new Projectile[(MAX_PROJECTILES/2)*MASTER_CODERS];
        registerKeyboardInput();
    }

    public void init () {

        grid.init();
        chars = CharFactory.charMaker(grid);
    }

    public void start () throws InterruptedException {

        while (!chars[0].isDead() && !allMasterCodersDead()) {

            //move all chars
            for (int i = 0; i < chars.length; i++) {

                chars[i].move();
            }

            masterCodersShoot();
            updateProjectiles(masterCoderProjectiles);
            updateProjectiles(playerProjectiles);
            checkCollisions(masterCoderProjectiles, playerProjectiles, chars);

            Thread.sleep(100);
        }
        gameOver();
    }

    private boolean allMasterCodersDead() {

        for (int i = 1; i < chars.length; i++) {

            if (!chars[i].isDead()) {

                return false;
            }
        }

        return true;
    }

    private void checkCollisions(Projectile[] mcProjectiles, Projectile[] playerProjectiles, Char[] chars) {

        CollisionChecker.check(mcProjectiles, chars);
        CollisionChecker.check(playerProjectiles, chars);
        CollisionChecker.check(mcProjectiles, playerProjectiles);
    }

    private void codeCadetShoot(ProjectileType type) {

        if (!isFull(playerProjectiles)) {

            if (type == ProjectileType.QUESTION) {

                storeProjectile(playerProjectiles, chars[0].shoot());

            } else {

                storeProjectile(playerProjectiles, ((Codecadet)chars[0]).specialShoot());
            }
        }
    }

    private void masterCodersShoot () {

        Projectile currentProjectile;
        for (int j = 1; j < chars.length; j++) {

            // TODO: 29/05/2016 check if we can remove the second statement
            if (!isFull(masterCoderProjectiles) && chars[j] != null) {

                    currentProjectile = chars[j].shoot();

                if (currentProjectile != null) {

                    storeProjectile(masterCoderProjectiles, currentProjectile);
                    break;
                }
            }
        }
    }

    private void storeProjectile(Projectile[] projectiles, Projectile projectile) {

        for (int i = 0; i < projectiles.length; i++) {

            if (projectiles[i] == null) {

                projectiles[i] = projectile;
                break;
            }
        }
    }

    private void updateProjectiles (Projectile[] projectiles) {

        for (int i = 0; i < projectiles.length; i++) {

            if (projectiles[i] != null) {

                if (projectiles[i].isHitTarget()) {

                    projectiles[i] = null;

                } else {

                    projectiles[i].move();
                }
            }
        }
    }

    public boolean isFull(Projectile[] projectiles){

        for(int i=0; i < projectiles.length; i++ ){

            if(projectiles[i] == null){

                return false;
            }
        }
        return true;
    }

    public void gameOver () {

        if (chars[0].isDead()) {

            grid.stackOverflow();

        } else {

            grid.win();
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
                codeCadetShoot(ProjectileType.QUESTION);
                break;

            case KeyboardEvent.KEY_B:

                codeCadetShoot(ProjectileType.BUG);
        }
    }

    public void keyReleased(KeyboardEvent e) {

        switch (e.getKey()) {
            case KeyboardEvent.KEY_LEFT:

                ((Codecadet)chars[0]).setMoving(false);
                break;

            case KeyboardEvent.KEY_RIGHT:

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

        KeyboardEvent event6 = new KeyboardEvent();
        event6.setKey(KeyboardEvent.KEY_SPACE);
        event6.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        k.addEventListener(event6);

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



