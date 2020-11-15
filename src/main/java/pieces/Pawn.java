package pieces;

import gamePlay.Move;
import gamePlay.Square;

public class Pawn extends Piece {

    private final PieceType type = PieceType.PAWN;

    public Pawn(boolean white) {
        super(white);
    }

    public PieceType getType() {
        return this.type;
    }

    public boolean capturingMove(Square[][] squares, Move move) {
        if (squares[move.x2][move.y2].getPiece() == null) {
            return false;
        } else if (squares[move.x2][move.y2].getPiece().isWhite() != this.isWhite()) {
            Piece capturedPiece = squares[move.x2][move.y2].getPiece();
            if (this.isWhite()){
                //check if moving the right direction
                if (move.y2 - move.y1 == 1){
                    move.setPieceCaptured(capturedPiece);
                    return true;
                }
            } else {
                //check if moving the right direction
                if (move.y1 - move.y2 == 1){
                    move.setPieceCaptured(capturedPiece);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean twoSquareMove(Square[][] squares,Move move) {
        if (this.isWhite()) {
            if (move.y1 == 1) {
                //check if moving the right direction
                if (move.y2 - move.y1 == 2) {
                    //check if any piece is blocking
                    if(squares[move.x1][move.y1 + 1].getPiece() == null){
                        return true;
                    }
                }
            }
        } else {
            if (move.y1 == 6) {
                //check if moving the right direction
                if (move.y1 - move.y2 == 2) {
                    //check if any piece is blocking
                    if(squares[move.x1][move.y1 -1].getPiece() == null){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean oneSquareMove( Move move) {
        if (this.isWhite()) {
            //check if moving the right direction
            if (move.y2 > move.y1) {
                return true;
            }
        } else {
            //check if moving the right direction
            if (move.y1 > move.y2) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean canMove(Square[][] squares, Move move) {
        if (squares[move.x2][move.y2].getPiece() != null) {
            if (squares[move.x2][move.y2].getPiece().isWhite() == this.isWhite()) {
                return false;
            }
        }
        if (move.x2 - move.x1 == 0) {
            if (squares[move.x2][move.y2].getPiece() != null) {
                return false;
            } else if (Math.abs(move.y2 - move.y1) == 2) {
                return twoSquareMove(squares,move);
            } else if (Math.abs(move.y2 - move.y1) == 2) {
                return oneSquareMove(move);
            } else {
                return false;
            }
        } else if (Math.abs(move.x2 - move.x1) == 1) {
            return capturingMove(squares, move);
        }
        return false;
    }
}
