package pieces;

import gamePlay.Board;
import gamePlay.Move;
import gamePlay.Square;

public class Queen extends Piece {

    private PieceType type = PieceType.QUEEN;

    public Queen(boolean white) {
        super(white);
    }

    public PieceType getType(){
        return this.type;
    }

    @Override
    public boolean canMove(Square[][] squares, Move move) {
//        if (end.getPiece().isWhite() == this.isWhite()) {
//            return false;
//        }
//        int x = Math.abs(start.getX() - end.getX());
//        int y = Math.abs(start.getY() - end.getY());
//        if (x > 0 && x < 8 && y == 0) {
//            return true;
//        } else if (x == 0 && y > 0 && y < 8) {
//            return true;
//        } else if (x != 0 && y != 0) {
//            return x / y == 1;
//        }
//
        return true;
    }
}
