package pieces;
import gamePlay.Board;
import gamePlay.Square;

public abstract class King extends Piece {
    private boolean castled = false;

    public King(boolean white){
        super(white);
    }

    public boolean isCastled(){
        return this.castled == true;
    }

    @Override
    public boolean canMove(Board board, Square start, Square end){
        if (end.getPiece().isWhite() == this.isWhite()){
            return false;
        }
        int x = Math.abs(start.getX() - end.getX());
        int y = Math.abs(start.getY() - end.getY());

        if (x + y ==1){
            //TODO if not moving into check
            return true;
        }
        return this.isValidCastling(board,start,end);
    }

    private boolean isValidCastling(Board board, Square start, Square end){
        //TODO check if any of own pieces are still in castling path
        //TODO check if any attacking piece is blocking castling squares
        return true;
    }

    public boolean isCastlingMove(){
        //TODO check if the start and end positions are correct?
        return false;
    }
}
