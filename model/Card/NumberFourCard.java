package model.Card;

import model.Pawn.Pawn;
import model.Square.Square;

public class NumberFourCard extends NumberCard{
    /**
     * Constructor:Creates a card with the number 4 and all the info for this card
     * Post-Condition:Number 4 has been created
     */
    public NumberFourCard(boolean isPlayed,String Info,int number){
        super(isPlayed,Info,number);
    }

    /**
     * Move a pawn 4 times backwards
     * @param pawn
     * @param table
     */
    public void Use4Card(Pawn pawn,Square[][] table){}
}
