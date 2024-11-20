package model.Card;

import model.Pawn.Pawn;
import model.Square.Square;

public class NumberTwoCard extends NumberCard{
    /**
     * Constructor:Constructs a card(with Super()) with the number 2
     * and adds all the info for the card
     * Post-Condition:The card with the number 2 has been created
     */
    public NumberTwoCard(boolean isPlayed,String Info,int number){
        super(isPlayed,Info,number);
    }

    /**
     * with this card a pawn can begin from the start or move 2 positions forward(clock-accordingly).Also with this
     * card the player has to play again
     * @param pawn
     * @param table
     */
    public void Use2Card(Pawn pawn, Square[][] table){}



}
