package model.Card;

import model.Pawn.Pawn;
import model.Square.Square;

public class SimpleNumberCard extends NumberCard {
    /**
     * Constructor:Construct a card with a number via Super()
     * but in this one we will check whether the number is
     * simple(3,5,8,12) or not simple
     *
     */
    public SimpleNumberCard(boolean isPlayed,String Info,int number){
        super(isPlayed,Info,number);
    }

    /**
     * Transformer:Takes the pawn and checks for the number
     * if it is 3 it moves it 3,if it is 8 than 8 etc
     * we override the initial abstract method from
     * the Card Class
     * @param  pawn
     * @param square
     */

    public void MovePawn(Pawn pawn, Square[][] table){}

}
