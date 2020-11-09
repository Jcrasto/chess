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
    public boolean canMove(Board board, Square start, Square end) {
        if (end.getPiece().isWhite() == this.isWhite()) {
            return false;
        }
        int x = Math.abs(start.getX() - end.getX());
        int y = Math.abs(start.getY() - end.getY());
        return x * y == 2;
    }
}
