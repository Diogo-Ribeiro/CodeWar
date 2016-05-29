package org.academiadecodigo.codewar.gameobjects;
import org.academiadecodigo.codewar.Direction;
import org.academiadecodigo.codewar.representable.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Created by diogocodecadet on 23/05/16.
 */
public class ProjectileFactory {

    public static Projectile get(ProjectileType type, GridPosition position, Direction direction){

        if (type == ProjectileType.KISSY || type == ProjectileType.DICKY) {

            position = position.getGrid().makeGridPosition(position.getCol(), position.getRow()+1, new Rectangle(0, 0, 5, 5));

        } else {

            position = position.getGrid().makeGridPosition(position.getCol(), position.getRow(), new Rectangle(0, 0, 5, 5));
        }

        return new Projectile(type, position, direction);
    }
}
