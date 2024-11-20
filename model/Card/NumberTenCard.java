package model.Card;

import model.Pawn.Pawn;
import model.Square.Square;

public class NumberTenCard extends NumberCard{
    /**
     * Constructor:Creates a Card with the Super() which will have the number 10
     * and also all the info for the card
     * Post-condition:Number 10 card has been created
     */
    public NumberTenCard(boolean isPlayed,String Info,int number){
        super(isPlayed,Info,number);
    }

    /**
     * Move a pawn 10 times forward or 1 backawrds.If non of the pawn of player cant move 10 positions forward tha
     * it has to move backwards only if possible.
     * @param pawn
     * @param table
     */
    public void Use10Card(Pawn pawn,Square[][] table){}
}
