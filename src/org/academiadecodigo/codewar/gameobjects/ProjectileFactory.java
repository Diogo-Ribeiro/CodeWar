package org.academiadecodigo.codewar.gameobjects;
import org.academiadecodigo.codewar.representable.GridPosition;

/**
 * Created by diogocodecadet on 23/05/16.
 */
public class ProjectileFactory {

    public static Projectile get(ProjectileType type, GridPosition position){

        return new Projectile(type, position);
    }
}
