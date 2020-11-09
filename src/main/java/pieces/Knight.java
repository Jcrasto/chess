package pieces;

import gamePlay.Board;
import gamePlay.Square;

public class Knight extends Piece {

    private final PieceType type = PieceType.KNIGHT;

    public Knight(boolean white) {
        super(white);
    }

    public PieceType getType(){
        return this.type;
    }

    @Override
    public boolean canMove(Square[][] squares,int x1, int y1, int x2, int y2) {
//        if (end.getPiece().isWhite() == this.isWhite()) {
////            return false;
////        }
////        int x = Math.abs(start.getX() - end.getX());
////        int y = Math.abs(start.getY() - end.getY());
////        return x * y == 2;
        return true;
    }
}
