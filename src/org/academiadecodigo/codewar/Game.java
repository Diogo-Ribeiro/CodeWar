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

            for (int i = 0; i < chars.length; i++) {

                chars[i].move();
            }

            masterCodersShoot();
            updateProjectiles(MCProjectiles);
            updateProjectiles(playerProjectiles);
            System.out.println("_______________________");
            Thread.sleep(100);
        }
    }

    private void masterCodersShoot () {

        // TODO: 25/05/16
        Projectile currentProjectile;
        for (int j = 1; j < chars.length; j++) {

            if (chars[j] != null && !isFull(MCProjectiles)) {

                    currentProjectile = chars[j].shoot();

                if (currentProjectile != null) {
                    System.out.println("shot a projectile : " + currentProjectile.getType() + " position " + currentProjectile.getPosition().getRow());

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

    private void updateProjectiles (Projectile[] projectiles) {

        for (int i = 0; i < projectiles.length; i++) {
            if(projectiles[i] != null) {
                projectiles[i].move();
                System.out.println("projectile number " + i + " type " + projectiles[i].getType() + "position is: " + projectiles[i].getPosition().getRow());
            if (projectiles[i].reachedEdge()) {

                projectiles[i].getPosition().hide();
                projectiles[i] = null;

                  }


                //System.out.println(MCProjectiles[i]);
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

    public void keyPressed(KeyboardEvent e) {

        switch (e.getKey()) {
            case KeyboardEvent.KEY_LEFT:

                chars[0].setCurrentDirection(Direction.LEFT);
                ((Codecadet) chars[0]).setMoving(true);
                break;

            case KeyboardEvent.KEY_RIGHT:

                chars[0].setCurrentDirection(Direction.RIGHT);
                ((Codecadet) chars[0]).setMoving(true);
                break;

            case KeyboardEvent.KEY_SPACE:
                System.out.println("space");
                if (!isFull(playerProjectiles)) {
                    for (int i = 0; i < playerProjectiles.length; i++) {
                        if (playerProjectiles[i] == null) {
                            playerProjectiles[i] = chars[0].shoot();
                            break;
                        }
                    }

                    break;
                }
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



