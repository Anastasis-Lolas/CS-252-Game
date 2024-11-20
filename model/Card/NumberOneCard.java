package model.Card;

import model.Pawn.Pawn;
import model.Square.Square;

public class NumberOneCard extends NumberCard{

    /**
     * Constructor:Constructs a card with number 1
     * Post-condition:Constructs a card with the number 1
     * and with the Info
     */
    public NumberOneCard(boolean isPlayed,String Info,int number){
        super(isPlayed,Info,number);
    }


    /**
     * With this carda pawn can begin from the starting position.Otherwise the player can move it pawn bu 1 forward
     * @param pawn
     * @param table
     */
    public void Use1Card(Pawn pawn, Square[][] table){}
}
