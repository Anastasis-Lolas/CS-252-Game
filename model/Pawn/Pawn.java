package model.Pawn;

import model.Square.Square;
import model.Square.SquareColor;

public class Pawn {
    private SquareColor color;
    private int positioni,positionj;
    private boolean isActive;

    /**
     * Constructor:Creates a pawn with a color,in a position that is a starting one
     * and set's the isActive value to true since it was just created and therefore it cannot have reached the end
     * Post-Condition:A pawn has been created
     * @param color
     * @param pos
     */
    public Pawn(SquareColor color,int pos1,int pos2){
        this.color=color;
        this.positioni=pos1;
        this.positionj=pos2;

    }

    /**
     * Transformer:set's the Pawns color
     * Post-Condition:Pawn's color has been set
     * @param color
     */
    void setColor(SquareColor color){
        this.color=color;
    }

    /**
     * Accessor:get's the color of the pawn
     * @return color
     */
    SquareColor getColor(){return color;}

    /**
     * Transformer:Set's the position of the pawn
     * Post-Condition:Pawn's position has been set
     * @param pos
     */
    void setPosition(int pos1,int pos2){
        this.positioni=pos1;
        this.positionj=pos2;
    }

    /**
     * Accessor:get's the position of the pawn
     * @return position
     */
    int getPositioni(){return positioni;}
    int getPositionj(){return positionj;}
    /**
     * Transformer:Check's if the pawn has reached the end and set's the value accordingly
     * Post-Condition:The value has been set
     * @param isActive
     */
    void setActive(boolean isActive){
        this.isActive=isActive;
    }

    /**
     * Accessor:get's the isActive value of the pawn
     * @return isActive
     */
    boolean getActive(){return isActive;}

}
