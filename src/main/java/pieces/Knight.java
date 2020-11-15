package pieces;

import gamePlay.Board;
import gamePlay.Move;
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
    public boolean canMove(Square[][] squares, Move move) {
        if (squares[move.x2][move.y2].getPiece() != null) {
            if (squares[move.x2][move.y2].getPiece().isWhite() == this.isWhite()) {
                return false;
            }
        }
        int x = Math.abs(move.x2 - move.x1);
        int y = Math.abs(move.y2 - move.y1);
        if ( x * y == 2 ){
            move.setPieceCaptured(squares[move.x2][move.y2].getPiece());
            return true;
        }
        return false;
    }
}
