package org.academiadecodigo.codewar.representable;

import org.academiadecodigo.codewar.Direction;
import org.academiadecodigo.codewar.RandomNumberGenerator;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 25/05/16.
 */
public class SimpleGfxGridPosition extends AbstractGridPosition {

    // TODO: 27/05/16  change to image
    private Picture representable;

    public SimpleGfxGridPosition (SimpleGfxGrid grid, Picture representable) {

        super(RandomNumberGenerator.get(0, grid.getCols()-1), 0, grid);

        this.representable = representable;
        this.representable.translate(this.getCol()*SimpleGfxGrid.CELL_SIZE, this.getRow()*SimpleGfxGrid.CELL_SIZE);
        representable.draw();

    }

    public SimpleGfxGridPosition (int col, int row, SimpleGfxGrid grid, Picture representable) {

        super (col, row, grid);

        this.representable = representable;
        this.representable.translate(this.getCol()*SimpleGfxGrid.CELL_SIZE, this.getRow()*SimpleGfxGrid.CELL_SIZE);
        representable.draw();

    }

    // TODO: 29/05/2016 switch instead of is elses
    @Override
    public void move (Direction direction, int dist) {

        if (direction == Direction.LEFT) {

            if (this.getCol() - dist < 0) {

               dist = this.getCol();
            }

            this.setCol(this.getCol() - dist);
            representable.translate(-(dist * SimpleGfxGrid.CELL_SIZE), 0);

        } else if (direction == Direction.RIGHT){

            if (this.getCol() + dist > getGrid().getCols()-1) {

                dist = (getGrid().getCols()-1) - this.getCol();
            }

            this.setCol(this.getCol() + dist);
            representable.translate(dist * SimpleGfxGrid.CELL_SIZE, 0);

        }else if(direction == Direction.DOWN){

            if(this.getRow() + dist > getGrid().getRows()){

                dist = (getGrid().getRows())- this.getRow();
            }

            this.setRow(this.getRow() + dist);
            representable.translate(0, dist * SimpleGfxGrid.CELL_SIZE);

        } else if(direction == Direction.UP){

            if(this.getRow() - dist < 0){
                dist =  this.getRow();
            }

            this.setRow(this.getRow()- dist);
            representable.translate(0, -dist * SimpleGfxGrid.CELL_SIZE);

        }
        else {

            System.out.println("error");
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

    public Picture getRepresentable(){
        return representable;
    }

    public boolean equals(Object obj) {

        if (obj instanceof GridPosition) {

            GridPosition position = (GridPosition)obj;
            return this.getCol() == position.getCol()
                    && this.getRow() == position.getRow();
        }
        return false;
    }
}
