package model.Square;

/**
 * Here we have the implementation of the Class square
 * We have as private values the position of the square in the board
 * The color of the square
 * and if the Square is empty or it has a pawn
 * Post-condition:The square has been created
 */
public class Square {
    private int positioni,positionj;

    private boolean IsEmptySquare;

    /**
     * Constructor:Creates a square in a certain position and sets the Empty value to false
     * Because it was just created.Therefore the game hasn't even started
     * @param pos1
     * @param pos2
     */
    public Square(int pos1,int pos2){
        this.positioni=pos1;
        this.positionj=pos2;
    }

    /**
     * Transformer:Sets the position of the square in the board
     * Post-condition:the square has been placed in the specific position
     * @param pos1,2
     */
    public void setPosition(int pos1,int pos2){
        this.positioni=pos1;
        this.positionj=pos2;
    }

    /**
     * Gets the position of the square
     * @return position
     */
    public int getPositioni(){return positioni;}
    public int getPositionj(){return positionj;}

    /**
     * check if the square has a pawn on it and set's the value
     * depending on this ocasion
     * Post-Conditon:IsEmptySquare has been set
     * @param Empty
     */
    public void setEmptySquare(boolean Empty){
        this.IsEmptySquare=Empty;
    }

    /**
     * get's the IsEmptySquare value
     * @return IsEmptySquare
     */
    public boolean getEmptySquare(){
        return IsEmptySquare;
    }

}
