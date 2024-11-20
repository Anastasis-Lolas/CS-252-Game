package controller;

import model.Card.*;
import model.Deck.Deck;
import model.Pawn.Pawn;
import model.Player.Player;
import model.Square.Square;
import model.Square.SquareColor;
import view.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class Controller implements ActionListener {
    private int finished_game,counter,RedCounter,YellowCounter,RedX,RedY,YellowX,YellowY,RCr,YCr,RedChoice,YellowChoice,CardCounter, prev=0,sum=0,position=0,yprev=0;
    private int[] countPawns;
    private boolean notstarted,empty_tableau,new_round,isRightMove,circle,EndButton,Rstarted,Ystarted;
    private Player P1,P2,winner;
    private Card Crd;
    private ArrayList<Card> cards;
    private Deck deck;
    private Pawn p1,p2,p3,p4;
    private Square[][] tableau;
    private View view;


    /**
     * Constructor:We first assign a (temporary) color and a (temporary) position { it will be changed in the Phase B
     * now we just want to initialize the basic pawns so we can initialize the rest}.We give 2 to Red and 2 to blue
     * We than create 2 new Players with String names and one has the color Red and the other the Blue
     * we than use a function to intialize and create the 11 cards of 4 sets each
     * and we set false to value that says the game has started,true to the value that says that the tableau is empty
     * and false to new round.We also put 0 in fold and in finished game(since it hasn't even started) and we have
     * created an extra array that counts the number of pawns that have reached the destination for each player
     * we will also create a function that takes this array and checks if both of the players pawns have reached
     * the destination.If so we put the winner on the Player if not we return null.That's why we set the winner to null
     * at the moment since the game hasn't started
     * Post-Condition:Creates the game
     */
    public Controller()  {
        view=new View();
        view.getYellowPawn2().addActionListener(this);
        view.getRedPawn2().addActionListener(this);
        view.getYellowPawn1().addActionListener(this);
        view.getRedPawn1().addActionListener(this);
        view.getLeftDeck().addActionListener(this);
        p1=new Pawn(SquareColor.RED,0,0);
        p2=new Pawn(SquareColor.RED,0,0);
        p3=new Pawn(SquareColor.BLUE,0,0);
        p4=new Pawn(SquareColor.BLUE,0,0);
        P1=new Player("Name1",p1,p2, SquareColor.RED,true);
        P2=new Player("Player2",p3,p4,SquareColor.BLUE,false);
        Square[][] tableau= new Square[15][4];
        deck=new Deck();
        cards=deck.CreateNewRandomDeck();
        this.notstarted=true;
        this.empty_tableau=true;
        this.new_round=false;
        this.isRightMove=true;
        this.winner=null;
        this.finished_game=0;
        countPawns=new int[2];
        counter=0;
        RedCounter=0;
        YellowCounter=0;
        RedX=46;
        RedY=5;
        YellowX=646;
        YellowY=724;
        RedChoice=0;
        YellowChoice=0;
        RCr=0;
        YCr=0;
        circle=false;
        EndButton=false;
        Rstarted=false;
        Ystarted=false;
        CardCounter=44;
    }

    /**
     * Transformer:set's the value of the finished game based of if we have a winner
     * Post-Condition:We get the value
     * @param fg
     */
    void setFinished_game(int fg){
        if(countPawns[0]==2 || countPawns[1]==2){
            fg=1;
        }
    }

    /**
     * Accessor:gets the finished game value
     * @return finished_game
     */
    int getFinished_game(){
        return finished_game;
    }


    /**
     * Transformer:Set's the value true or false based of the fact if the game has started
     * Post-Condition:The value has been set accordingly
     * @param notstarted
     */
    void setNotstarted(boolean notstarted){
        this.notstarted=notstarted;
    }

    /**
     * Accessor:gets the value
     * Post-Condition:gets the value
     * @return notstarted0
     */
    boolean getNotStarted(){
        return notstarted;
    }

    /**
     * Transformer:sets the value depending if the tableau is empty or not
     * Post-Condition:The value has been set
     * @param tableau
     */
    void setEmpty_tableau(boolean tableau){
        this.empty_tableau=tableau;
    }

    /**
     * Gets the value of the EmptyTableau
     * @return empty_tableau
     */
    boolean getEmptyTableau(){
        return empty_tableau;
    }



    /**
     * Transformer:set's the Player accordingly
     * Post-Condition:Player value has been set
     * @param P1,P2
     */
    public void setPlayer(Player P1,Player P2){
        this.P1=P1;
        this.P2=P2;
    }

    /**
     * Accessor:gets the Player
     * Post-Condition:gets the player
     * @return player
     */
    Player getPlayer(Player P){return P;}


    @Override
    public void actionPerformed(ActionEvent e) {

        ImageIcon icon=new ImageIcon();
        Crd= deck.getNewCard(CardCounter, cards);
         if(e.getSource()==view.getLeftDeck()){
            if (Crd.getNumber() == 0) {
                icon = new ImageIcon("cardSorry.png");
                CardCounter--;
                view.getRightDeck().setIcon(icon);
            } else if (Crd.getNumber() == 1) {
                icon = new ImageIcon("card1.png");
                CardCounter--;
                view.getRightDeck().setIcon(icon);
                if(P1.getTurn()) {
                    if(!Rstarted) {
                        view.getRedPawn1().setBounds(RedX, RedY, 40, 40);
                        P1.setMyTurn(false, P2);
                        Rstarted = true;
                    }else{
                        prev=RCr;
                        sum=15-prev;
                        if(RCr<15) {
                            RedX += 46;
                            view.getRedPawn1().setBounds(RedX, RedY, 40, 40);
                        }else if(prev <= 15 && RCr>=15) {
                            RedX += sum * 46;
                            view.getRedPawn1().setBounds(RedX, RedY, 40, 40);
                            position = RCr - 15;
                            RedY += position * 48;
                            view.getRedPawn1().setBounds(RedX, RedY, 40, 40);
                        }
                        P1.setMyTurn(false, P2);
                    }
                    RCr++;
                }else {
                    if (!Ystarted) {
                        view.getYellowPawn1().setBounds(YellowX, YellowY, 40, 40);
                        P2.setMyTurn(false, P1);
                        Ystarted=true;
                    }else{
                        yprev=YCr;
                        sum=15-yprev;
                        if(YCr<15) {
                            YellowX -= 46;
                            view.getYellowPawn1().setBounds(YellowX, YellowY, 40, 40);
                        }else if(prev<=15 && YCr>=15){
                            YellowX-=sum*46;
                            view.getYellowPawn1().setBounds(YellowX,YellowY,40,40);
                            position=YCr-15;
                            YellowY-=position*48;
                            view.getYellowPawn1().setBounds(YellowX,YellowY,40,40);
                        }
                        P2.setMyTurn(false, P1);
                        view.getinfo().setText("Y1 moved + " + Crd.getNumber());
                    }
                    YCr++;
                }

            } else if (Crd.getNumber() == 2) {
                icon = new ImageIcon("card2.png");
                CardCounter--;
                view.getRightDeck().setIcon(icon);
                if(P1.getTurn()){
                    if(!Rstarted) {
                        view.getRedPawn1().setBounds(RedX,RedY,40,40);
                        P1.setMyTurn(false,P2);
                        Rstarted=true;
                        RCr++;
                    }else{
                        prev=RCr;
                        sum=15-prev;
                        RCr+=Crd.getNumber();
                        if(RCr<15) {
                            RedX += Crd.getNumber() * 46;
                            view.getRedPawn1().setBounds(RedX, RedY, 40, 40);
                        }else if(prev<15 && RCr>=15) {
                            RedX += sum * 46;
                            view.getRedPawn1().setBounds(RedX, RedY, 40, 40);
                            int position = RCr - 15;
                            RedY += position * 48;
                            view.getRedPawn1().setBounds(RedX, RedY, 40, 40);
                        }
                        P1.setMyTurn(false, P2);
                    }

                }else {
                    if (!Ystarted) {
                        view.getYellowPawn1().setBounds(YellowX, YellowY, 40, 40);
                        P2.setMyTurn(false, P1);
                        Ystarted = true;
                    } else {
                        yprev = YCr;
                        sum = 15 - yprev;
                        YCr += Crd.getNumber();
                        if (YCr < 15) {
                            YellowX -= 46;
                            view.getYellowPawn1().setBounds(YellowX, YellowY, 40, 40);
                        } else if (prev <= 15 && YCr >= 15) {
                            YellowX -= sum * 46;
                            view.getYellowPawn1().setBounds(YellowX, YellowY, 40, 40);
                            position = YCr - 15;
                            YellowY -= position * 48;
                            view.getYellowPawn1().setBounds(YellowX, YellowY, 40, 40);
                        }
                    }
                    P2.setMyTurn(false, P1);
                }
            }else if(Crd.getNumber() == 3) {
                icon = new ImageIcon("card3.png");
                CardCounter--;
                view.getRightDeck().setIcon(icon);
                if(P1.getTurn()){
                    if(Rstarted) {
                        prev=RCr;
                        sum=15-prev;
                        RCr+=Crd.getNumber();
                        if(RCr<15) {
                            RedX += Crd.getNumber() * 46;
                            view.getRedPawn1().setBounds(RedX, RedY, 40, 40);
                        }else if(prev<15 && RCr>=15) {
                            RedX += sum * 46;
                            view.getRedPawn1().setBounds(RedX, RedY, 40, 40);
                            position = RCr - 15;
                            RedY += position * 48;
                            view.getRedPawn1().setBounds(RedX, RedY, 40, 40);
                        }
                        P1.setMyTurn(false, P2);
                    }else{
                        P1.setMyTurn(true,P2);
                    }

                }else{
                    if(Ystarted) {
                        yprev = YCr;
                        sum = 15 - yprev;
                        if (YCr < 15) {
                            YellowX -= 46;
                            view.getYellowPawn1().setBounds(YellowX, YellowY, 40, 40);
                        } else if (prev <= 15 && YCr >= 15) {
                            YellowX -= sum * 46;
                            view.getYellowPawn1().setBounds(YellowX, YellowY, 40, 40);
                            position = YCr - 15;
                            YellowY -= position * 48;
                            view.getYellowPawn1().setBounds(YellowX, YellowY, 40, 40);
                            P2.setMyTurn(false, P1);
                        } else {
                            P2.setMyTurn(true, P1);
                        }
                    }
                }
            } else if (Crd.getNumber() == 4) {
                icon = new ImageIcon("card4.png");
                CardCounter--;
                view.getRightDeck().setIcon(icon);
                if(P1.getTurn()){
                    if(Rstarted) {
                        prev=RCr;
                        sum=15-prev;
                        RCr+=Crd.getNumber();
                        if(RCr<15) {
                            RedX += Crd.getNumber() * 46;
                            view.getRedPawn1().setBounds(RedX, RedY, 40, 40);
                        }else if(prev<15 && RCr>=15) {
                            RedX += sum * 46;
                            view.getRedPawn1().setBounds(RedX, RedY, 40, 40);
                            int position = RCr - 15;
                            RedY += position * 48;
                            view.getRedPawn1().setBounds(RedX, RedY, 40, 40);
                        }
                        P1.setMyTurn(false, P2);
                    }else{
                        P1.setMyTurn(true,P2);
                    }

                }else{
                    if(Ystarted) {
                        yprev = YCr;
                        sum = 15 - yprev;
                        if (YCr < 15) {
                            YellowX -= 46;
                            view.getYellowPawn1().setBounds(YellowX, YellowY, 40, 40);
                        } else if (prev <= 15 && YCr >= 15) {
                            YellowX -= sum * 46;
                            view.getYellowPawn1().setBounds(YellowX, YellowY, 40, 40);
                            position = YCr - 15;
                            YellowY -= position * 48;
                            view.getYellowPawn1().setBounds(YellowX, YellowY, 40, 40);
                            P2.setMyTurn(false, P1);
                        } else {
                            P2.setMyTurn(true, P1);
                        }
                    }
                }
            } else if (Crd.getNumber() == 5) {
                icon = new ImageIcon("card5.png");
                CardCounter--;
                view.getRightDeck().setIcon(icon);
                if(P1.getTurn()){
                    if(Rstarted) {
                        prev=RCr;
                        sum=15-prev;
                        RCr+=Crd.getNumber();
                        if(RCr<15) {
                            RedX += Crd.getNumber() * 46;
                            view.getRedPawn1().setBounds(RedX, RedY, 40, 40);
                        }else if(prev<15 && RCr>=15) {
                            RedX += sum * 46;
                            view.getRedPawn1().setBounds(RedX, RedY, 40, 40);
                            int position = RCr - 15;
                            RedY += position * 48;
                            view.getRedPawn1().setBounds(RedX, RedY, 40, 40);
                        }
                        P1.setMyTurn(false, P2);
                    }else{
                        P1.setMyTurn(true,P2);
                    }

                }else{
                    if(Ystarted) {
                        yprev = YCr;
                        sum = 15 - yprev;
                        if (YCr < 15) {
                            YellowX -= 46;
                            view.getYellowPawn1().setBounds(YellowX, YellowY, 40, 40);
                        } else if (prev <= 15 && YCr >= 15) {
                            YellowX -= sum * 46;
                            view.getYellowPawn1().setBounds(YellowX, YellowY, 40, 40);
                            position = YCr - 15;
                            YellowY -= position * 48;
                            view.getYellowPawn1().setBounds(YellowX, YellowY, 40, 40);
                            P2.setMyTurn(false, P1);
                        } else {
                            P2.setMyTurn(true, P1);
                        }
                    }
                }
            } else if (Crd.getNumber() == 7) {
                icon = new ImageIcon("card7.png");
                CardCounter--;
                view.getRightDeck().setIcon(icon);
                if(P1.getTurn()){
                    if(Rstarted) {
                        prev=RCr;
                        sum=15-prev;
                        RCr+=Crd.getNumber();
                        if(RCr<15) {
                            RedX += Crd.getNumber() * 46;
                            view.getRedPawn1().setBounds(RedX, RedY, 40, 40);
                        }else if(prev<15 && RCr>=15) {
                            RedX += sum * 46;
                            view.getRedPawn1().setBounds(RedX, RedY, 40, 40);
                            int position = RCr - 15;
                            RedY += position * 48;
                            view.getRedPawn1().setBounds(RedX, RedY, 40, 40);
                        }
                        P1.setMyTurn(false, P2);
                    }else{
                        P1.setMyTurn(true,P2);
                    }

                }else {
                    if(Ystarted) {
                        yprev = YCr;
                        sum = 15 - yprev;
                        if (YCr < 15) {
                            YellowX -= 46;
                            view.getYellowPawn1().setBounds(YellowX, YellowY, 40, 40);
                        } else if (prev <= 15 && YCr >= 15) {
                            YellowX -= sum * 46;
                            view.getYellowPawn1().setBounds(YellowX, YellowY, 40, 40);
                            position = YCr - 15;
                            YellowY -= position * 48;
                            view.getYellowPawn1().setBounds(YellowX, YellowY, 40, 40);
                            P2.setMyTurn(false, P1);
                        } else {
                            P2.setMyTurn(true, P1);
                        }
                    }
                }
            }else if (Crd.getNumber() == 8) {
                icon = new ImageIcon("card8.png");
                CardCounter--;
                view.getRightDeck().setIcon(icon);
                if(P1.getTurn()){
                    if(Rstarted) {
                        prev=RCr;
                        sum=15-prev;
                        RCr+=Crd.getNumber();
                        if(RCr<15) {
                            RedX += Crd.getNumber() * 46;
                            view.getRedPawn1().setBounds(RedX, RedY, 40, 40);
                        }else if(prev<15 && RCr>=15) {
                            RedX += sum * 46;
                            view.getRedPawn1().setBounds(RedX, RedY, 40, 40);
                            int position = RCr - 15;
                            RedY += position * 48;
                            view.getRedPawn1().setBounds(RedX, RedY, 40, 40);
                        }
                        P1.setMyTurn(false, P2);
                    }else{
                        P1.setMyTurn(true,P2);
                    }
                }else{
                    if(Ystarted) {
                        yprev = YCr;
                        sum = 15 - yprev;
                        if (YCr < 15) {
                            YellowX -= 46;
                            view.getYellowPawn1().setBounds(YellowX, YellowY, 40, 40);
                        } else if (prev <= 15 && YCr >= 15) {
                            YellowX -= sum * 46;
                            view.getYellowPawn1().setBounds(YellowX, YellowY, 40, 40);
                            position = YCr - 15;
                            YellowY -= position * 48;
                            view.getYellowPawn1().setBounds(YellowX, YellowY, 40, 40);
                            P2.setMyTurn(false, P1);
                        } else {
                            P2.setMyTurn(true, P1);
                        }
                    }
                }
            } else if (Crd.getNumber() == 10) {
                icon = new ImageIcon("card10.png");
                CardCounter--;
                view.getRightDeck().setIcon(icon);
                if(P1.getTurn()){
                    if(Rstarted) {
                        prev=RCr;
                        sum=15-prev;
                        RCr+=Crd.getNumber();
                        if(RCr<15) {
                            RedX += Crd.getNumber() * 46;
                            view.getRedPawn1().setBounds(RedX, RedY, 40, 40);
                        }else if(prev<15 && RCr>=15) {
                            RedX += sum * 46;
                            view.getRedPawn1().setBounds(RedX, RedY, 40, 40);
                            int position = RCr - 15;
                            RedY += position * 48;
                            view.getRedPawn1().setBounds(RedX, RedY, 40, 40);
                        }
                        P1.setMyTurn(false, P2);
                    }else {
                        P1.setMyTurn(true, P2);
                    }
                }else{
                    if(Ystarted) {
                        yprev = YCr;
                        sum = 15 - yprev;
                        if (YCr < 15) {
                            YellowX -= 46;
                            view.getYellowPawn1().setBounds(YellowX, YellowY, 40, 40);
                        } else if (prev <= 15 && YCr >= 15) {
                            YellowX -= sum * 46;
                            view.getYellowPawn1().setBounds(YellowX, YellowY, 40, 40);
                            position = YCr - 15;
                            YellowY -= position * 48;
                            view.getYellowPawn1().setBounds(YellowX, YellowY, 40, 40);
                            P2.setMyTurn(false, P1);
                        } else {
                            P2.setMyTurn(true, P1);
                        }
                    }
                }
            } else if (Crd.getNumber() == 11) {
                icon = new ImageIcon("card11.png");
                CardCounter--;
                view.getRightDeck().setIcon(icon);
                if(P1.getTurn()){
                    if(Rstarted) {
                        prev=RCr;
                        sum=15-prev;
                        RCr+=Crd.getNumber();
                        if(RCr<15) {
                            RedX += Crd.getNumber() * 46;
                            view.getRedPawn1().setBounds(RedX, RedY, 40, 40);
                        }else if(prev<15 && RCr>=15) {
                            RedX += sum * 46;
                            view.getRedPawn1().setBounds(RedX, RedY, 40, 40);
                            int position = RCr - 15;
                            RedY += position * 48;
                            view.getRedPawn1().setBounds(RedX, RedY, 40, 40);
                        }else if(RCr<30){
                            view.getRedPawn1().setBounds(RedX,RedY,40,40);
                        }
                        P1.setMyTurn(false, P2);
                    }else{
                        P1.setMyTurn(true,P2);
                    }
                }else{
                    if(Ystarted) {
                        yprev = YCr;
                        sum = 15 - yprev;
                        if (YCr < 15) {
                            YellowX -= 46;
                            view.getYellowPawn1().setBounds(YellowX, YellowY, 40, 40);
                        } else if (prev <= 15 && YCr >= 15) {
                            YellowX -= sum * 46;
                            view.getYellowPawn1().setBounds(YellowX, YellowY, 40, 40);
                            position = YCr - 15;
                            YellowY -= position * 48;
                            view.getYellowPawn1().setBounds(YellowX, YellowY, 40, 40);
                            P2.setMyTurn(false, P1);
                        } else {
                            P2.setMyTurn(true, P1);
                        }
                    }
                }
            } else if (Crd.getNumber() == 12) {
                icon = new ImageIcon("card12.png");
                CardCounter--;
                view.getRightDeck().setIcon(icon);
                if(P1.getTurn()){
                    if(Rstarted) {
                        prev=RCr;
                        sum=15-prev;
                        RCr+=Crd.getNumber();
                        if(RCr<15) {
                            RedX += Crd.getNumber() * 46;
                            view.getRedPawn1().setBounds(RedX, RedY, 40, 40);
                        }else if(prev<15 && RCr>=15) {
                            RedX += sum * 46;
                            view.getRedPawn1().setBounds(RedX, RedY, 40, 40);
                            int position = RCr - 15;
                            RedY += position * 48;
                            view.getRedPawn1().setBounds(RedX, RedY, 40, 40);
                        }
                        P1.setMyTurn(false, P2);
                    }else{
                        P1.setMyTurn(true,P2);
                    }
                }else{
                    if(Ystarted) {
                        yprev = YCr;
                        sum = 15 - yprev;
                        if (YCr < 15) {
                            YellowX -= 46;
                            view.getYellowPawn1().setBounds(YellowX, YellowY, 40, 40);
                        } else if (prev <= 15 && YCr >= 15) {
                            YellowX -= sum * 46;
                            view.getYellowPawn1().setBounds(YellowX, YellowY, 40, 40);
                            position = YCr - 15;
                            YellowY -= position * 48;
                            view.getYellowPawn1().setBounds(YellowX, YellowY, 40, 40);
                            P2.setMyTurn(false, P1);
                        } else {
                            P2.setMyTurn(true, P1);
                        }
                    }
                }
            }
         }

    }

}
