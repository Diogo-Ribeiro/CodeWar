package org.academiadecodigo.codewar.gameobjects;
import org.academiadecodigo.codewar.Direction;
import org.academiadecodigo.codewar.representable.GridPosition;

/**
 * Factory design. Instantiate all projectiles in the game.
 */
public class ProjectileFactory {

    /**
     * Calls method from Grid to create a position and draw its representation on the screen.
     * @param type
     * @param position
     * @param direction
     * @return Projectile object
     */
    public static Projectile get(ProjectileType type, GridPosition position, Direction direction){

        if (type == ProjectileType.KISSY || type == ProjectileType.DICKY) {

            //Projectiles from MasterCoder are drawn down the MasterCoder picture.
            position = position.getGrid().makeGridPosition(position.getCol(), position.getRow() + Char.AVATAR_DIMENSION,type.getRepresentable());

        } else {

            //Projectiles from CodeCadet are drawn up the CodeCadet picture.
            position = position.getGrid().makeGridPosition(position.getCol(), position.getRow() - Char.AVATAR_DIMENSION, type.getRepresentable());
        }
        return new Projectile(type, position, direction);
    }
}
