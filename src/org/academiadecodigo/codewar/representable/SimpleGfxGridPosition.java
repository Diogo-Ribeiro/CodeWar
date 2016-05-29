package org.academiadecodigo.codewar.representable;

import org.academiadecodigo.codewar.Direction;
import org.academiadecodigo.codewar.RandomNumberGenerator;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Created by codecadet on 25/05/16.
 */
public class SimpleGfxGridPosition extends AbstractGridPosition {

    // TODO: 27/05/16  change to image
    Rectangle representable;

    public SimpleGfxGridPosition (SimpleGfxGrid grid, Rectangle representable) {

        super(RandomNumberGenerator.get(0, grid.getCols()-1), 0, grid);

        this.representable = representable;
        this.representable.translate(this.getCol()*SimpleGfxGrid.CELL_SIZE, this.getRow()*SimpleGfxGrid.CELL_SIZE);
        representable.fill();

    }

    public SimpleGfxGridPosition (int col, int row, SimpleGfxGrid grid, Rectangle representable) {

        super (col, row, grid);

        this.representable = representable;
        this.representable.translate(this.getCol()*SimpleGfxGrid.CELL_SIZE, this.getRow()*SimpleGfxGrid.CELL_SIZE);
        representable.fill();

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

            if (this.col + dist > grid.getCols()-1) {

                dist = (grid.getCols()-1) - this.col;
            }

            this.setCol(this.getCol() + dist);
            representable.translate(dist * SimpleGfxGrid.CELL_SIZE, 0);

        } else if (direction == Direction.UP){

            row--;
            representable.translate(0, -dist * SimpleGfxGrid.CELL_SIZE);

        }else if(direction == Direction.DOWN){
            if(this.getRow() + dist > grid.getRows()){
                dist = (grid.getRows())- this.getRow();
            }
            this.setRow(this.getRow()+dist);
            representable.translate(0,dist * SimpleGfxGrid.CELL_SIZE);

        }
        else if(direction == Direction.UP){
            if(this.getRow() - dist < 0){
                dist =  this.getRow();
            }
            this.setRow(this.getRow()- dist);
            representable.translate(0,dist * SimpleGfxGrid.CELL_SIZE);

        }
        else {

            System.out.println("error");
        }
    }

    @Override
    public void show() {

        representable.fill();

    }

    @Override
    public void hide() {

        representable.delete();
    }

    @Override
    public int getCol() {
        return col;
    }

    @Override
    public int getRow() {
        return row;
    }
}
