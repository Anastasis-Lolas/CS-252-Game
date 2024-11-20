package model.Square;

public class HomeSquare extends Square{
    /**
     * Constructor:For each player there is only one HomeSuare for this so we have to check if already one exists
     * @param pos1
     * @param pos2
     */
    public HomeSquare(int pos1,int pos2){
        super(pos1, pos2);
    }
}
