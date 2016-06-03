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
class Game implements KeyboardHandler {

    private static final int MAX_PLAYERS_PROJECTILES = 5;
    private static final int MAX_MC_PROJECTILES = 15;

    private Keyboard k;
    private Codecadet player;
    private MasterCoder[] masterCoders;
    private LinkedList<Projectile> playerProjectiles;
    private LinkedList<Projectile> masterCoderProjectiles;
    private Grid grid = new SimpleGfxGrid(40, 45);
    private Menu menu;
    private Clip clip;

    /**
     * instantiates a new game and starts the sound.
     */
    Game () {

        playSound();
        menu = new Menu(grid);
    }

    /**
     * initializes the lists and the menu. after the character selection starts the game.
     * @throws InterruptedException
     */
    void init () throws InterruptedException {

        playerProjectiles = new LinkedList<>();
        masterCoderProjectiles = new LinkedList<>();
        menu.init();
        registerKeyboardInput();
        player = CodeCadetFactory.make(grid, menu.choose());

        start();
    }

    /**
     * manages the turns.
     * @throws InterruptedException
     */
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
            CollisionChecker.checkCollisions(masterCoderProjectiles, playerProjectiles, masterCoders, player);

            Thread.sleep(100);
        }

        gameOver();
    }

    /**
     * iterates over the MasterCoders array to check if any of them is still in play.
     * @return
     */
    private boolean allMasterCodersDead() {

        for (MasterCoder mc : masterCoders) {

            if (!mc.isDead()) {

                return false;
            }
        }

        return true;
    }

    /**
     * gets a projectile from the player and stores it in a projectile list.
     * @param type
     */
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

    /**
     * iterates over the array of MasterCoders and calls the method shoot().
     */
    private void masterCodersShoot () {

        Projectile currentProjectile;
        for (MasterCoder mc : masterCoders) {

            if (masterCoderProjectiles.size() < MAX_MC_PROJECTILES) {

                currentProjectile = mc.shoot();

                if (currentProjectile != null) {

                    masterCoderProjectiles.add(currentProjectile);
                }
            }
        }
    }

    /**
     * updates the projectile lists, removing those which have reached targets and moving those which are still in play.
     * @param projectiles
     */
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

    /**
     * stops the music and shows the final screens.
     */
    private void gameOver () {

        clip.close();

        if (player.isDead()) {

            grid.stackOverflow();

        } else {

            grid.win();
        }
    }

    /**
     * part of the keyboard logic.
     * @param e
     */
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

    /**
     * part of the keyboard logic.
     * @param e
     */
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

    /**
     * register the keyboard events.
     */
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

    /**
     * plays the background music.
     */
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



