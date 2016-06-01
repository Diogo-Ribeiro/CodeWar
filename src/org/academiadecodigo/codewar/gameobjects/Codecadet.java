package org.academiadecodigo.codewar.gameobjects;

import org.academiadecodigo.codewar.Direction;
import org.academiadecodigo.codewar.representable.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

/**
 * Created by diogocodecadet on 23/05/16.
 */
public class Codecadet extends Char {

    // TODO: 24/05/16 one char for each codecadet and associated game mode

    private static final int KISSIES_TO_BUG = 4;
    private int kissyCounter;
    private Rectangle kissyBar;
    private Rectangle kissyBarFill;

    public Codecadet(GridPosition position) {

        super(position);
        kissyBar = new Rectangle(0, getPosition().getGrid().getRows()*getPosition().getGrid().getCellSize() - 20, 80, 20);
        kissyBarFill = new Rectangle(0, getPosition().getGrid().getRows()*getPosition().getGrid().getCellSize() - 20, 0, 0);
        kissyBarFill.setColor(Color.MAGENTA);
        kissyBar.setColor(Color.MAGENTA);
        kissyBar.draw();
    }

    @Override
    public void move() {

        if (isMoving()) {

            getPosition().move(getCurrentDirection(), 1);

        }
    }

    @Override
    public void getHit(Projectile projectile) {

        if (projectile.getType() == ProjectileType.KISSY) {

            if (kissyCounter < 4) {

                kissyCounter++;
                kissyBarFill.delete();
                kissyBarFill = new Rectangle(0, getPosition().getGrid().getRows() * getPosition().getGrid().getCellSize() - 20, kissyBarFill.getWidth() + 20, 20);
                kissyBarFill.setColor(Color.MAGENTA);
                kissyBarFill.fill();
            }

        } else if (projectile.getType() == ProjectileType.DICKY) {

            lowerHP();
        }
    }

    public Projectile shoot() {

        return ProjectileFactory.get(ProjectileType.QUESTION, getPosition(), Direction.UP);
    }

    public Projectile specialShoot() {

        //// TODO: 30/05/16 barrinha de kissy || kissycounter
        // TODO: 31/05/16 barrinha hp

        System.out.println(kissyCounter);

        if (kissyCounter >= KISSIES_TO_BUG) {

            kissyCounter = 0;
            kissyBarFill.delete();
            kissyBarFill = new Rectangle(0, getPosition().getGrid().getRows() * getPosition().getGrid().getCellSize() - 20, 0, 0);
            return ProjectileFactory.get(ProjectileType.BUG, this.getPosition(), Direction.UP);

        }
        // TODO: 31/05/16 exception
        return null;
    }
}