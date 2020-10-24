package gamePlay;

import pieces.Piece;

public class Move {
    private final Player player;
    private final Square start;
    private final Square end;
    private final Piece pieceMoved;
    private Piece pieceCaptured;
    private boolean castlingMove = false;

    public Move(Player player, Square start, Square end) {
        this.player = player;
        this.start = start;
        this.end = end;
        this.pieceMoved = start.getPiece();
    }

    public boolean isCastlingMove() {
        return this.castlingMove == true;
    }

    public void setCastlingMove(boolean castlingMove) {
        this.castlingMove = castlingMove;
    }

    public Square getStart() {
        return this.start;
    }

    public Square getEnd() {
        return this.end;
    }

}
