package pieces;

import gamePlay.Square;

public class Pawn extends Piece {

    private final PieceType type = PieceType.PAWN;

    public Pawn(boolean white) {
        super(white);
    }

    public PieceType getType() {
        return this.type;
    }

    public boolean capturingMove(Square[][] squares, int x1, int y1, int x2, int y2) {
        if (squares[x2][y2].getPiece() == null) {
            return false;
        } else if (squares[x2][y2].getPiece().isWhite() != this.isWhite()) {
            if (this.isWhite()){
                //check if moving the right direction
                if (y2 - y1 == 1){
                    return true;
                }
            } else {
                //check if moving the right direction
                if (y1 - y2 == 1){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean twoSquareMove(Square[][] squares,int x1, int y1, int y2) {
        if (this.isWhite()) {
            if (y1 == 1) {
                //check if moving the right direction
                if (y2 - y1 == 2) {
                    //check if any piece is blocking
                    if(squares[x1][y1 + 1].getPiece() == null){
                        return true;
                    }
                }
            }
        } else {
            if (y1 == 6) {
                //check if moving the right direction
                if (y1 - y2 == 2) {
                    //check if any piece is blocking
                    if(squares[x1][y1 -1].getPiece() == null){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean oneSquareMove(Square[][] squares, int y1, int y2) {
        if (this.isWhite()) {
            //check if moving the right direction
            if (y2 > y1) {
                return true;
            }
        } else {
            //check if moving the right direction
            if (y1 > y2) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean canMove(Square[][] squares, int x1, int y1, int x2, int y2) {
        if (squares[x2][y2].getPiece() != null) {
            if (squares[x2][y2].getPiece().isWhite() == this.isWhite()) {
                return false;
            }
        }
        if (x2 - x1 == 0) {
            if (squares[x2][y2].getPiece() != null) {
                return false;
            } else if (Math.abs(y2 - y1) == 2) {
                return twoSquareMove(squares, x1, y1, y2);
            } else if (Math.abs(y2 - y1) == 2) {
                return oneSquareMove(squares, y1, y2);
            } else {
                return false;
            }
        } else if (Math.abs(x2 - x1) == 1) {
            return capturingMove(squares, x1, y1, x2, y2);
        }
        return false;
    }
}
