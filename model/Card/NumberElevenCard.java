package model.Card;

import model.Pawn.Pawn;
import model.Square.Square;

public class NumberElevenCard extends NumberCard{
    /**
     * Constructor:Creates a card with the number 11 (via Super()) and includes all the info for the card
     * Post-condition:Number 11 card has been created
     */
    public NumberElevenCard(boolean isPlayed,String Info,int number){
        super(isPlayed,Info,number);
    }

    /**
     * With this card the player can move 11 times forwards(clockwise) or switch place
     * with the enemy pawn.This card cannot be used for:change with an enemy pawn when it is in Start position
     * or in Home position
     * If the pawn can't move 11 times we don't have to change places with the enemy pawn
     * The turn just changes and the next Player plays
     * @param pawn
     * @param  table
     */
    public void Use11Card(Pawn pawn,Square[][] table,Pawn adversary,int i,int j){
        if(table[i+11][j]!=null){

        }
    }

}
