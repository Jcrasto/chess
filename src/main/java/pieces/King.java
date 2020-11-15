package pieces;

import gamePlay.Board;
import gamePlay.Move;
import gamePlay.Square;

public class King extends Piece {

    private final PieceType type = PieceType.KING;

    public King(boolean white) {
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
//
//        if (x + y == 1) {
//            //TODO if not moving into check
//            return true;
//        }
//        return this.isValidCastling(board, start, end);
        return true;
    }

    private boolean isValidCastling(Board board, Square start, Square end) {
        //TODO check if any of own pieces are still in castling path
        //TODO check if any attacking piece is blocking castling squares
        return true;
    }

}
