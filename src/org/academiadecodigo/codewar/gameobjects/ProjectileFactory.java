package org.academiadecodigo.codewar.gameobjects;
import org.academiadecodigo.codewar.representable.*;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Created by diogocodecadet on 23/05/16.
 */
public class ProjectileFactory {

    /*public ProjectileFactory(ProjectileType type, SimpleGfxGrid grid, SimpleGfxGridPosition position){
        this.grid = grid;

    }*/

    public static Projectile get(ProjectileType type, SimpleGfxGridPosition position, Grid grid){

        return new Projectile(type, grid.makeGridPosition(position.getCol(),position.getRow(),new Rectangle(0,0,10,10)));
    }
}
