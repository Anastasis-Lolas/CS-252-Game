package model.Square;

import model.Pawn.Pawn;

public class StartSlideSquare extends SlideSquare{
    /**
     * Constructor:Creates a slideSquare which signifies the start(In the graphic session it will have a triangle)
     * which only the starter square of the slide will have
     * @param pos
     * @param color
     */
    public StartSlideSquare(int pos1,int pos2){
        super(pos1, pos2);
    }

    /**
     *  Transformer:we take as parameters the color of the player the color of the slide
     *  and we check if they have the same color.If they do it cannot slide
     *  if they don't it slides through the end of the slide
     * @param pos1,pos2
     * @param pawn
     */
    public void SlideToTheEnd(Square[][] table,int pos1, int pos2, Pawn pawn){}

}

