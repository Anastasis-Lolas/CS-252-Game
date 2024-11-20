package model.Card;

import model.Pawn.Pawn;
import model.Square.Square;

public class NumberSevenCard extends NumberCard{
    /**
     * Constructor:Creates a card with the number 7 (via Super() method)
     * and all the other info about the card
     * Post-Condition:Number 7 card has been created
     */
    public NumberSevenCard(boolean isPlayed,String Info,int number){
        super(isPlayed,Info,number);
    }

    /**
     * The player can either move 7 position forward
     * or split the moves between it's 2 pawns(3-4,2-5,1-6,4-3,5-2,6-1)
     * With this card the pawn cant be moved backwards neither can start from the Start Position
     * @param  pawn
     * @param  square
     */

    public void Use7Card(Pawn pawn, Square square, int s1, int s2){}

}
