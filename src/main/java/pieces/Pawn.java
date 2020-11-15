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
        } else if (squares[x2][y2].getPiece().isWhite() != this.isWhite() && y2 - y1 == 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean twoSquareMove(Square[][] squares, int x1, int y1, int x2, int y2) {
        if (this.isWhite()) {
            if (y1 == 1) {
                return true;
            }
        } else {
            if (y1 == 6) {
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
            } else if (y2 - y1 == 2) {
                return twoSquareMove(squares, x1, y1, x2, y2);
            } else if (y2 - y1 == 1) {
                return true;
            } else {
                return false;
            }
        } else if (Math.abs(x2 - x1) == 1) {
            return capturingMove(squares, x1, y1, x2, y2);
        }
        return false;
    }
}
