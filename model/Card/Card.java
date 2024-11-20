package model.Card;


import model.Pawn.Pawn;
import model.Square.Square;

/**
 * this is the abstract Card class which all of the cards will be extended
 * but here we will ride the prototypes and most of them
 * will be overridden
 * by the
 */
public abstract class Card {
    private boolean isPlayed;
    private String CardInfo;
    private int number;

    /**
     * Constructor:Creates a new instance of a Card and set's
     * the is played and the  cardInfo to it's parameters
     * @param  isPlayed
     * @param  Info
     */
    public Card(boolean isPlayed,String Info,int number){
        this.isPlayed=isPlayed;
        this.CardInfo=Info;
        this.number=number;

    }




    /**
     * Transformer: set's the isPlayed value which checks if the card is played or not
     * Post-condition:isPlayed value has been set
     * @param  isPlayed
     */
    public void setPlayed(boolean isPlayed){
        this.isPlayed=isPlayed;
    }



    /**
     * Accessor:gets the isPlayed value(true or false)
     * Post-condition:gets the isPlayed value
     * @return isPlayed
     */
    public boolean getPlayed(){return isPlayed;}



    /**
     * Transformer:sets the info of a card to a String
     * Post-condition:The info has been set
     * @param  Cinfo
     */
    public void setCardInfo(String Cinfo){
        this.CardInfo=Cinfo;
    }



    /**
     * Accessor:gets the Info for the Card
     * Post-condition:gets the Info for the card
     * @return String CardInfo
     */
    public String getCardInfo(){return CardInfo;}

    public void setNumber(int n){this.number=n;}
    public int getNumber(){return  number;}
}
