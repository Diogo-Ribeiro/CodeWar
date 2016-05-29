package org.academiadecodigo.codewar.gameobjects;
import org.academiadecodigo.codewar.Direction;
import org.academiadecodigo.codewar.representable.GridPosition;
import org.academiadecodigo.codewar.representable.SimpleGfxGridPosition;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Created by diogocodecadet on 23/05/16.
 */
public class ProjectileFactory {

    public static Projectile get(ProjectileType type, GridPosition position, Direction direction){

        if (type == ProjectileType.KISSY || type == ProjectileType.DICKY) {

            position = position.getGrid().makeGridPosition(position.getCol(), position.getRow()+1,type.getRepresentable());

        } else {

            position = position.getGrid().makeGridPosition(position.getCol(), position.getRow(), type.getRepresentable());
        }

        return new Projectile(type, position, direction);
    }
}
