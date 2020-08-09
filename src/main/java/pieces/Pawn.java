package pieces;

import gamePlay.Board;
import gamePlay.Square;

public class Pawn extends Piece{
    public Pawn(boolean white){
        super(white);
    }
    @Override
    public boolean canMove(Board board, Square start, Square end){
        if (end.getPiece().isWhite() == this.isWhite()){
            return false;
        }
        int x = end.getX() - start.getX();
        int y = Math.abs(start.getY() - end.getY());

        if (x == 1 && y == 0){
            return true;
        }
        else{
            //TODO if can take return true
            return false;
        }
    }
}
