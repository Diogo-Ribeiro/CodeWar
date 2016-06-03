package org.academiadecodigo.codewar;

import org.academiadecodigo.codewar.gameobjects.*;
import org.academiadecodigo.codewar.representable.Grid;
import org.academiadecodigo.codewar.representable.SimpleGfxGrid;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by diogocodecadet on 23/05/16.
 */
public class Game implements KeyboardHandler {

    public static final int MAX_PLAYERS_PROJECTILES = 5;
    public static final int MAX_MC_PROJECTILES = 15;

    private Keyboard k;
    private Codecadet player;
    private MasterCoder[] masterCoders;
    private LinkedList<Projectile> playerProjectiles;
    private LinkedList<Projectile> masterCoderProjectiles;
    private Grid grid = new SimpleGfxGrid(40, 45);


    private Menu menu;
    private Clip clip;

    public Game () {

        playSound();
        menu = new Menu(grid);
    }

    public void init () throws InterruptedException {

        playerProjectiles = new LinkedList<>();
        masterCoderProjectiles = new LinkedList<>();
        menu.init();
        registerKeyboardInput();
        player = CodeCadetFactory.make(grid, menu.choose());

        start();
    }

    private void start () throws InterruptedException {

        masterCoders = MasterCoderFactory.maker(grid);

        while (!player.isDead() && !allMasterCodersDead()) {

            for (MasterCoder mc : masterCoders) {

                mc.move();
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

        for (int j = 0; j < mcProjectiles.size(); j++) {
            CollisionChecker.check(mcProjectiles.get(j), player);

            for (int i = 0; i < playerProjectiles.size(); i++) {

                for (MasterCoder mc : masterCoders) {

                    CollisionChecker.check(playerProjectiles.get(i), mc);
                }

                if (playerProjectiles.get(i).getType().equals(ProjectileType.QUESTION)) {

                    CollisionChecker.check(playerProjectiles.get(i), mcProjectiles.get(j));
                }
            }
        }
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

        clip.close();

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
    }

    private void playSound() {

        AudioInputStream in;

        File soundFile = new File("resources/music.wav");

        try {

            in = AudioSystem.getAudioInputStream(soundFile);
            AudioSystem.getAudioFileFormat(soundFile);
            clip = AudioSystem.getClip();
            clip.open(in);
            clip.start();

        } catch (UnsupportedAudioFileException e) {

            e.printStackTrace();

        } catch (LineUnavailableException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}



