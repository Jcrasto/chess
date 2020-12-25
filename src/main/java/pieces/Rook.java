package pieces;

import gamePlay.Board;
import gamePlay.Move;
import gamePlay.Square;

public class Rook extends Piece {

    private final PieceType type = PieceType.ROOK;

    public Rook(boolean white) {
        super(white);
    }

    public PieceType getType(){
        return this.type;
    }

    @Override
    public boolean canMove(Square[][] squares, Move move) {
        Piece pieceToCapture = null;
        if (squares[move.x2][move.y2].getPiece() != null) {
            if (squares[move.x2][move.y2].getPiece().isWhite() == this.isWhite()) {
                return false;
            }
            pieceToCapture = squares[move.x2][move.y2].getPiece();
        }
        int x = move.x2 - move.x1;
        int y = move.y2 - move.y1;
        if (Math.abs(x) > 0 && y == 0) {
            if (x > 0){
                for (int xcheck = move.x1 + 1; xcheck < move.x2; xcheck++){
                    if (squares[xcheck][move.y1].getPiece() != null){
                        return false;
                    }
                }
            } else {
                for (int xcheck = move.x2 - 1; xcheck > move.x1; xcheck--){
                    if (squares[xcheck][move.y1].getPiece() != null){
                        return false;
                    }
                }
            }
            move.setPieceCaptured(pieceToCapture);
            return true;
        }
        if (Math.abs(y) > 0 && y == 0) {
            if (y > 0){
                for (int xcheck = move.y1 + 1; xcheck < move.y2; xcheck++){
                    if (squares[xcheck][move.x1].getPiece() != null){
                        return false;
                    }
                }
            } else {
                for (int xcheck = move.y2 - 1; xcheck > move.y1; xcheck--){
                    if (squares[xcheck][move.x1].getPiece() != null){
                        return false;
                    }
                }
            }
            move.setPieceCaptured(pieceToCapture);
            return true;
        }
        return false;
    }
}
