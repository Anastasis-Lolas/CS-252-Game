package model.Square;

public class SafetyZoneSquare extends Square{
    /**
     * Constructor:Creates a safetyZone square which can only contain 5 of them and than it leads to the Home square
     * Post-condition:Creates a SafetyZone square
     * @param pos1
     * @param pos2
     */
    public SafetyZoneSquare(int pos1,int pos2){
        super(pos1,pos2);
    }
}
