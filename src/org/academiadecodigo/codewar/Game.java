package org.academiadecodigo.codewar;

import org.academiadecodigo.codewar.gameobjects.*;
import org.academiadecodigo.codewar.representable.Grid;
import org.academiadecodigo.codewar.representable.SimpleGfxGrid;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by diogocodecadet on 23/05/16.
 */
public class Game implements KeyboardHandler {

    public static final int MAX_PLAYERS_PROJECTILES = 5;
    public static final int MAX_MC_PROJECTILES = 20;

    private Mouse m;
    private Keyboard k;
    private CodecadetType playerType;
    private Codecadet player;
    private MasterCoder[] masterCoders;
    private LinkedList<Projectile> playerProjectiles;
    private LinkedList<Projectile> masterCoderProjectiles;
    private Grid grid = new SimpleGfxGrid(40, 45);
    private Menu menu;

    public Game () {

        // TODO: 25/05/16 init or constructor?
        // TODO: 29/05/2016 player selection
        registerKeyboardInput();
        menu = new Menu();
    }

    public void init () throws InterruptedException {

        grid.init();

        playerProjectiles = new LinkedList<>();
        masterCoderProjectiles = new LinkedList<>();

        menu.init();
        player = CodeCadetFactory.make(grid, menu.choose());

        start();
    }

    public void start () throws InterruptedException {

        masterCoders = MasterCoderFactory.maker(grid);

        while (!player.isDead() && !allMasterCodersDead()) {


            for (int i = 0; i < masterCoders.length; i++) {

                masterCoders[i].move();
            }
            player.move();

            masterCodersShoot();
            projectileUpdate(masterCoderProjectiles);
            projectileUpdate(playerProjectiles);
            checkCollisions(masterCoderProjectiles, playerProjectiles, masterCoders, player);

            Thread.sleep(100);
        }
        gameOver();
    }

    private boolean allMasterCodersDead() {

        for (int i = 0; i < masterCoders.length; i++) {

            if (!masterCoders[i].isDead()) {

                return false;
            }
        }

        return true;
    }

    private void checkCollisions(LinkedList <Projectile> mcProjectiles, LinkedList <Projectile> playerProjectiles, MasterCoder[] masterCoders, Codecadet player) {

        // TODO: 31/05/16 juntar tudo huma unica lista e passar pro collision detector
        // TODO: 31/05/16 interface collidable
        CollisionChecker.check(mcProjectiles, player);
        CollisionChecker.check(playerProjectiles, masterCoders);
        CollisionChecker.check(mcProjectiles, playerProjectiles);

    }

    private void codeCadetShoot(ProjectileType type) {

        if (playerProjectiles.size() < MAX_PLAYERS_PROJECTILES) {

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

            if (masterCoderProjectiles.size() < MAX_MC_PROJECTILES) {

                currentProjectile = masterCoders[i].shoot();

                if (currentProjectile != null) {

                    masterCoderProjectiles.add(currentProjectile);
                }
            }
        }
    }

    private void projectileUpdate(LinkedList<Projectile> projectiles) {

        ListIterator <Projectile> a = projectiles.listIterator();

        while (a.hasNext()) {

            Projectile p = a.next();

            if (p.isHitTarget()) {

                a.remove();

            } else {

                p.move();
            }
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

        KeyboardEvent event6 = new KeyboardEvent();
        event6.setKey(KeyboardEvent.KEY_SPACE);
        event6.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        k.addEventListener(event6);

       /* KeyboardEvent event7 = new KeyboardEvent();
        event7.setKey(KeyboardEvent.KEY_UP);
        event7.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(event7);

        KeyboardEvent event8 = new KeyboardEvent();
        event8.setKey(KeyboardEvent.KEY_DOWN);
        event8.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(event8);

        KeyboardEvent event9 = new KeyboardEvent();
        event9.setKey(KeyboardEvent.KEY_C);
        event9.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(event9);*/
    }
}



