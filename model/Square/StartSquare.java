package model.Square;

import model.Player.Player;

public class StartSquare extends Square{
    private Player owner;
    /**
     * Constructor:Creates(with Super()) a Start square in which indicates that the game is at starter positions
     * it also belongs to only one Player so the enemy Player can't have acces to them
     * Post-Condition:Creates a Start square and assigns the owner
     */
    public StartSquare(int pos1,int pos2,Player owner){
        super(pos1,pos2);
        this.owner=owner;
    }

    /**
     * Transformer:Set's the owner of the Start square depending on the color
     * Post-condition:The owner has been set
     * @param owner
     */
    void setOwner(Player owner){
        this.owner=owner;
    }

    /**
     * Accessor:gets the owner of the square
     * @return owner
     */
    Player getOwner(){
        return owner;
    }


}
