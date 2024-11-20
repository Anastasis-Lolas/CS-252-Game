package model.Deck;

import model.Card.*;
import model.Player.Player;
import model.Square.Square;
import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> cards;
    private Card DrawnCard,card;
    private int notPlayedCards;

    /**
     * Constructor:Creates a Deck with an ArrayList of cards
     * Post-Condition:A Deck has been Created
     */
    public Deck(){

        notPlayedCards=39;
    }


    void setCards(ArrayList<Card> cards){
        this.cards=cards;
    }

    /**
     * Accessor:Gets the deck of cards
     * Post-Condition:Gets the deck of cards
     * @return this.cards
     */
    ArrayList<Card> getCards(){
        return cards;
    }

    public Card get(int index){
        return cards.get(index);
    }


    /**
     * Transformer:This method gets a new card for the player
     * Basically we get the Array of Players and the position of the array which signifies the certain player
     * also we take as a parameter the Cards in order to:
     * Check if the List is Empty.If it is we take all the cards and we call a function in which the Cards are
     * Being added to the list randomly.If it is not empty than it removes the card from the list and "sends" it to the
     * player.
     * Post-Condition:The player either drew a card or at first the cards got putted randomly and than he drew
     * @param pos1,pos2
     * @param cards
     */
    public Card getNewCard(int pos1,ArrayList<Card> cards){
        if(pos1==0) {
            Collections.shuffle(cards);
            pos1=44;
        }
        cards.get(pos1).setPlayed(true);
        DrawnCard = cards.get(pos1 - 1);

        return DrawnCard;
    }

    /**
     * Trasnformer:Takes all the Played Cards and :
     * It changes the IsPlayed value for each card to false
     * and through random positioning it returns the new Deck of cards
     * Post-Condition:A new Random Deck has been created
     * @param cards
     */
    public ArrayList<Card> CreateNewRandomDeck(){
        cards=new ArrayList<Card>(43);
        for(int i=0;i<45;i++){
            if(i>=0 && i<4){
                card= new SorryCard(false,"SorryCard",0);
            }else if(i>=4 && i<8){
                card=new NumberOneCard(false,"One",1);
            }else if(i>=8 && i<12){
                card=new NumberTwoCard(false,"Two",2);
            }else if(i>=12 && i<16){
                card=new SimpleNumberCard(false,"Three",3);
            }else if(i>=16 && i<20){
                card=new NumberFourCard(false,"Four",4);
            }else if(i>=20 && i<24){
                card=new SimpleNumberCard(false,"Five",5);
            }else if(i>=24 && i<28){
                card=new NumberSevenCard(false,"Seven",7);
            }else if(i>=28 && i<32){
                card=new SimpleNumberCard(false,"Eight",8);
            }else if(i>=32 && i<36){
                card=new NumberTenCard(false,"Ten",10);
            }else if(i>=36 && i<40){
                card=new NumberElevenCard(false,"Eleven",11);
            }else if(i>=40 && i<44){
                card=new SimpleNumberCard(false,"Twelve",12);
            }
            cards.add(card);
        }
        Collections.shuffle(cards);
        return cards;
    }



}
