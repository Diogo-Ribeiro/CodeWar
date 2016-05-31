package org.academiadecodigo.codewar;

import org.academiadecodigo.codewar.gameobjects.*;
import org.academiadecodigo.codewar.representable.Grid;
import org.academiadecodigo.codewar.representable.SimpleGfxGrid;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by diogocodecadet on 23/05/16.
 */
public class Game implements KeyboardHandler {

    public static final int MAX_PROJECTILES = 5;

    private Keyboard k;

    // TODO: 29/05/2016 separate player from other chars

    private Codecadet player;
    private MasterCoder[] masterCoders;
    private LinkedList<Projectile> playerProjectiles;
    private LinkedList<Projectile> masterCoderProjectiles;
    private Grid grid = new SimpleGfxGrid(40, 45);

    public Game () {

        // TODO: 25/05/16 init or constructor?
        // TODO: 29/05/2016 player selection
        registerKeyboardInput();
    }

    public void init () {

        grid.init();
        masterCoders = MasterCoderFactory.maker(grid);
        playerProjectiles = new LinkedList<>();
        masterCoderProjectiles = new LinkedList<>();


        //todo make "menu" method
        player = CodeCadetFactory.make(grid, CodecadetType.IGOR);
    }

    public void start () throws InterruptedException {

        while (!player.isDead() && !allMasterCodersDead()) {

            //move all chars
            for (int i = 0; i < masterCoders.length; i++) {

                masterCoders[i].move();
            }
            player.move();

            masterCodersShoot();
            projectilesMove(playerProjectiles);
            projectilesMove(masterCoderProjectiles);
            checkCollisions(masterCoderProjectiles, playerProjectiles, masterCoders, player);

            Thread.sleep(100);
        }
        gameOver();
    }

    private boolean allMasterCodersDead() {

        for (int i = 1; i < masterCoders.length; i++) {

            if (!masterCoders[i].isDead()) {

                return false;
            }
        }

        return true;
    }

    private void checkCollisions(LinkedList <Projectile> mcProjectiles, LinkedList <Projectile> playerProjectiles, Char[] chars, Codecadet player) {

        CollisionChecker.check(mcProjectiles, player);
        CollisionChecker.check(playerProjectiles, chars);
        CollisionChecker.check(mcProjectiles, playerProjectiles);
        projectileUpdate(mcProjectiles);
        projectileUpdate(playerProjectiles);

    }

    private void projectileUpdate(LinkedList<Projectile> projectiles) {

        ListIterator <Projectile> a = projectiles.listIterator();

        while (a.hasNext()) {

          if (a.next().isHitTarget()) {
                a.remove();
            }
        }
    }

    private void codeCadetShoot(ProjectileType type) {

        if (playerProjectiles.size() < MAX_PROJECTILES) {

            if (type == ProjectileType.QUESTION) {

                playerProjectiles.add(player.shoot());

            } else {

                Projectile p = player.specialShoot();

                if (p != null) {
                    playerProjectiles.add(p);
                }
            }
        }
    }

    private void masterCodersShoot () {

        Projectile currentProjectile;
        for (int i = 0; i < masterCoders.length; i ++) {

            if (masterCoderProjectiles.size() < masterCoders.length * MAX_PROJECTILES / 2) {

                currentProjectile = masterCoders[i].shoot();

                if (currentProjectile != null) {

                    masterCoderProjectiles.add(currentProjectile);
                }
            }
        }
    }

    private void projectilesMove (LinkedList <Projectile> projectiles) {

        Iterator<Projectile> a = projectiles.iterator();

        while(a.hasNext()) {

          a.next().move();
        }
    }


    public void gameOver () {

        if (player.isDead()) {

            grid.stackOverflow();

        } else {

            grid.win();
        }
    }

    public void keyPressed(KeyboardEvent e) {

        switch (e.getKey()) {

            case KeyboardEvent.KEY_LEFT:

                player.setCurrentDirection(Direction.LEFT);
                player.setMoving(true);
                break;

            case KeyboardEvent.KEY_RIGHT:

                player.setCurrentDirection(Direction.RIGHT);
                player.setMoving(true);
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

                player.setMoving(false);
                break;

            case KeyboardEvent.KEY_RIGHT:

                player.setMoving(false);
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



