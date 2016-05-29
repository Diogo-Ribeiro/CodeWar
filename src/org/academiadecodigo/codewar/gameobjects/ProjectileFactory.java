package org.academiadecodigo.codewar.gameobjects;
import org.academiadecodigo.codewar.Direction;
import org.academiadecodigo.codewar.representable.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Created by diogocodecadet on 23/05/16.
 */
public class ProjectileFactory {

    public static Projectile get(ProjectileType type, GridPosition position, Direction direction){

        position = position.getGrid().makeGridPosition(position.getCol(), position.getRow(), new Rectangle(0,0,5, 5));

        return new Projectile(type, position, direction);
    }
}
