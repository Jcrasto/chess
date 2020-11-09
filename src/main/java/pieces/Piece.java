package pieces;

import gamePlay.Board;
import gamePlay.Square;

public abstract class Piece {
    private boolean captured = false;
    private boolean white = false;
    private PieceType type = null;

    public Piece(boolean white) {
        this.setWhite(white);
    }

    public boolean isWhite() {
        return this.white;
    }

    public void setWhite(boolean white) {
        this.white = white;
    }

    public boolean isCaptured() {
        return this.captured;
    }

    public void setCaptured(boolean captured) {
        this.captured = captured;
    }

    public abstract boolean canMove(Square[][] squares,int x1, int y1, int x2, int y2);

    public PieceType getType(){
        return type;
    }

}
