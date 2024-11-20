package model.Player;

import model.Pawn.Pawn;
import model.Square.Square;
import model.Square.SquareColor;

public class Player {
    private String name;
    private Pawn Pa1,Pa2;
    private SquareColor color;
    private boolean MyTurn;

    /**
     * Constructor:Creates a player with a name,2 pawns and a color
     * We don't put the MyTurn Value because will go through that through random starting on which player can begin
     * Post-Condition:Creates the Player
     * @param name
     * @param pa1
     * @param pa2
     * @param color
     */
    public Player(String name, Pawn pa1, Pawn pa2, SquareColor color,boolean Turn){
        this.name=name;
        this.Pa1=pa1;
        this.Pa2=pa2;
        this.MyTurn=Turn;
    }

    /**
     * Transformer:set's the name of the player
     * Post-Condition:Set's the name of the player
     * @param Name
     */
    public void setName(String Name){
        this.name=Name;
    }

    /**
     * Accesor: get's the name of the Player
     * @return name
     */
    public String getName(){return name;}

    /**
     * Transformer:set's 2 pawn's for this player
     * Post-condition:Player has now 2 pawn's to play
     * @param pa1
     * @param pa2
     */
    public void setPawns(Pawn pa1,Pawn pa2){
        this.Pa1=pa1;
        this.Pa2=pa2;
    }

    /**
     * Accessor:get's the pawns of the Player
     * Post-Conditon:Get's the 2 pawns of the player
     * @return
     */
   public  Pawn getPawn1(){return Pa1;}
   public  Pawn getPawn2(){return Pa2;}

    /**
     * Transformer:set's the color of the player which will pass to the color of the pawns
     * We could use another enumerate with only 2 colors for the Players but we can modify the SquareColor
     * in the setColor Method to accept only the 2 of the 4-5 colors
     * We also have to check for both Players not to have the same color
     * Post-Conditions:Player now has a color
     * @param color
     */
    public void setColor(SquareColor color){
        this.color=color;
    }

    /**
     * Accessor:get's the color of the player
     * @return color
     */
    public SquareColor getColor(){
        return color;
    }

    /**
     * Transformer:Set's the Turn of the Player base on the MyTurn Value of the Adversary
     * If the enemy's value is True than we set this player's value to false
     * and counterclockwise
     * Post-Condition:Either it's this players turn or the opponent's
     * @param Turn
     * @param adversary
     */
    public void setMyTurn(boolean Turn,Player adversary){
        this.MyTurn=Turn;
        adversary.MyTurn=!Turn;
    }

    /**
     * Accessor:get's the value for the players Turn
     * @return MyTurn
     */
    public boolean getTurn(){
        return MyTurn;
    }






}
