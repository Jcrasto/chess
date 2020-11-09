package pieces;

import gamePlay.Board;
import gamePlay.Square;


public class Bishop extends Piece {

    private final PieceType type = PieceType.BISHOP;

    public Bishop(boolean white) {
        super(white);
    }

    public PieceType getType(){
        return this.type;
    }

    @Override
    public boolean canMove(Square[][] squares,int x1, int y1, int x2, int y2) {

//        if (squares[x2][y2].getPiece().isWhite() == this.isWhite()) {
//            return false;
//        }
//        int x = Math.abs(start.getX() - end.getX());
//        int y = Math.abs(start.getY() - end.getY());
//
//        if (x != 0 && y != 0) {
//            return x / y == 1;
//        }
//        return false;
        return true;
    }
}
