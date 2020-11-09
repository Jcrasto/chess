package pieces;

import gamePlay.Board;
import gamePlay.Square;

public class Pawn extends Piece {

    private final PieceType type = PieceType.PAWN;

    public Pawn(boolean white) {
        super(white);
    }

    public PieceType getType(){
        return this.type;
    }

    @Override
    public boolean canMove(Square[][] squares,int x1, int y1, int x2, int y2) {
//        if (end.getPiece().isWhite() == this.isWhite()) {
//            return false;
//        }
//        int x = end.getX() - start.getX();
//        int y = Math.abs(start.getY() - end.getY());
//
//        //TODO if can take return true
//        return x == 1 && y == 0;
        return true;
    }
}
