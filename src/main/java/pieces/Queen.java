package pieces;

import gamePlay.Board;
import gamePlay.Square;

public class Queen extends Piece{

    public Queen(boolean white){ super(white); }

    @Override
    public boolean canMove(Board board, Square start, Square end) {
        if (end.getPiece().isWhite() == this.isWhite()){
            return false;
        }
        int x = Math.abs(start.getX() - end.getX());
        int y = Math.abs(start.getY() - end.getY());
        if (x > 0 && x < 8 && y ==0){
            return true;
        }
        else if (x == 0 && y > 0 && y < 8){
            return true;
        }
        else if ( x != 0 && y != 0){
            if(x/y == 1){
                return true;
            }
        }

        return false;
    }
}
