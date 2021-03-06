package org.academiadecodigo.codewar.representable;

import org.academiadecodigo.codewar.Direction;
import org.academiadecodigo.codewar.RandomNumberGenerator;
import org.academiadecodigo.codewar.gameobjects.Char;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 25/05/16.
 */
public class SimpleGfxGridPosition extends AbstractGridPosition {

    private Picture representable;

    /**
     * creates a random grid position
     * @param grid simple-graphics grid
     * @param representable picture representing a game object
     */
    public SimpleGfxGridPosition (SimpleGfxGrid grid, Picture representable) {

        super(RandomNumberGenerator.get(0, grid.getCols() - representable.getWidth()/grid.getCellSize()), 0, grid);

        this.representable = representable;
        this.representable.translate(this.getCol()*SimpleGfxGrid.CELL_SIZE, this.getRow()*SimpleGfxGrid.CELL_SIZE);
        representable.draw();

    }

    /**
     * creates a fixed grid position
     * @param col position column
     * @param row position row
     * @param grid simple-graphics grid
     * @param representable picture representing a game object
     */
    public SimpleGfxGridPosition (int col, int row, SimpleGfxGrid grid, Picture representable) {

        super (col, row, grid);

        this.representable = representable;
        this.representable.translate(this.getCol()*SimpleGfxGrid.CELL_SIZE, this.getRow()*SimpleGfxGrid.CELL_SIZE);
        representable.draw();
    }

    @Override
    public int getMaxX() {
        return getCol() + representable.getWidth()/getGrid().getCellSize();
    }

    @Override
    public int getMaxY() {
        return getRow() + representable.getHeight()/getGrid().getCellSize();
    }

    @Override
    public void move (Direction direction, int dist) {

        switch (direction) {

            case LEFT:

                if (this.getCol() - dist < 0) {

                    dist = this.getCol();
                }

                this.setCol(this.getCol() - dist);
                representable.translate(-(dist * SimpleGfxGrid.CELL_SIZE), 0);
                break;

            case RIGHT:

                if (this.getCol() + dist > getGrid().getCols() - Char.AVATAR_DIMENSION) {

                    dist = (getGrid().getCols() - Char.AVATAR_DIMENSION) - this.getCol();
                }

                this.setCol(this.getCol() + dist);
                representable.translate(dist * SimpleGfxGrid.CELL_SIZE, 0);
                break;

            case UP:

                if (this.getRow() - dist < 0) {

                    dist = this.getRow();
                }

                this.setRow(this.getRow() - dist);
                representable.translate(0, -dist * SimpleGfxGrid.CELL_SIZE);
                break;

            case DOWN:

                if (this.getRow() + dist > getGrid().getRows()) {

                    dist = (getGrid().getRows()) - this.getRow();
                }

                this.setRow(this.getRow() + dist);
                representable.translate(0, dist * SimpleGfxGrid.CELL_SIZE);
                break;
        }
    }

    @Override
    public void show() {

        representable.draw();
    }

    @Override
    public void hide() {

        representable.delete();
    }

    /**
     * gets the picture representing a game object.
     * @return picture of game object
     */
    public Picture getRepresentable(){
        return representable;
    }

    /**
     * compares the position of two game objects
     * @param obj the object position we want to compare
     * @return true if the objects would collide
     */
    @Override
    public boolean equals(Object obj) {

        if (obj instanceof GridPosition) {

            GridPosition position = (GridPosition)obj;

            return (this.getCol() >= position.getCol() && this.getCol() <= position.getMaxX()
                    || position.getCol() >= this.getCol() && position.getCol() < this.getMaxX())

                    && (this.getRow() >= position.getRow() && this.getRow() < position.getMaxY()
                    || position.getRow() >= this.getRow() && position.getRow() < this.getMaxY());
        }

        return false;
    }
}
