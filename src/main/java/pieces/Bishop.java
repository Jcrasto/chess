package pieces;

import gamePlay.Board;
import gamePlay.Square;


public class Bishop extends Piece {

    private final PieceType type = PieceType.BISHOP;

    public Bishop(boolean white) {
        super(white);
    }

    @Override
    public boolean canMove(Board board, Square start, Square end) {
        if (end.getPiece().isWhite() == this.isWhite()) {
            return false;
        }
        int x = Math.abs(start.getX() - end.getX());
        int y = Math.abs(start.getY() - end.getY());

        if (x != 0 && y != 0) {
            return x / y == 1;
        }
        return false;
    }
}
