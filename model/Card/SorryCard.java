package model.Card;

import model.Pawn.Pawn;

public class SorryCard extends Card{


    /**
     * Constructor:it constructs a card with the super() phrase
     * also it adds a String name to specify it is the Sorry Card
     * @param   name
     */
    public SorryCard(boolean isPlayed,String Info,int number)
    {
        super(isPlayed,Info,number);
    }

    /**
     * Transformner:Takes as a parameter the pawn of the player
     * also a pawn of the other player and checks if
     * it can change it's position or not
     * Post-condition:Depends if the player has a pawn at the start
     * or if the enemy is not at Home etc
     * @param  pawn
     * @param   enemypawn
     */
    public void UseSorryCard(Pawn pawn, Object   enemypawn){}

}
