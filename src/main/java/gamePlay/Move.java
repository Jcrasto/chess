package gamePlay;

import pieces.*;

public class Move {
    private Player player;
    private Square start;
    private Square end;
    private Piece pieceMoved;
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

}
