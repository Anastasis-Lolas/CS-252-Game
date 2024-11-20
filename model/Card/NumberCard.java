package model.Card;

import model.Pawn.Pawn;
import model.Square.Square;

public class NumberCard extends Card{
    private int number;


    /**
     * Constructor:Constructs a normal card via Super()
     * and it also specifies the number
     * it also set the timesPlayed to 0
     * @param number
     * @param isP
     * @param info
     *
     */
    public NumberCard(boolean isP,String info,int number){
        super(isP,info,number);
    }

}
