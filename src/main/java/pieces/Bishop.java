package pieces;

import gamePlay.Move;
import gamePlay.Square;


public class Bishop extends Piece {

    private final PieceType type = PieceType.BISHOP;

    public Bishop(boolean white) {
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
        if (x != 0 && y != 0) {
            int xcheck;
            int ycheck;
            if(Math.abs(x/y) == 1){
                if (x > 0){
                    if (y > 0){
                        xcheck = move.x1 + 1;
                        ycheck = move.y1 + 1;
                        while (xcheck <= move.x2 && ycheck <= move.y2){
                            if (squares[xcheck][ycheck].getPiece() != null){
                                return false;
                            }
                            xcheck += 1;
                            ycheck += 1;
                        }
                        move.setPieceCaptured(pieceToCapture);
                        return true;
                    } else {
                        xcheck = move.x1 + 1;
                        ycheck = move.y1 - 1;
                        while (xcheck <= move.x2 && ycheck >= move.y2){
                            if (squares[xcheck][ycheck].getPiece() != null){
                                return false;
                            }
                            xcheck += 1;
                            ycheck -= 1;
                        }
                        move.setPieceCaptured(pieceToCapture);
                        return true;
                    }

                } else {
                    if (y > 0){
                        xcheck = move.x1 - 1;
                        ycheck = move.y1 + 1;
                        while (xcheck >= move.x2 && ycheck <= move.y2){
                            if (squares[xcheck][ycheck].getPiece() != null){
                                return false;
                            }
                            xcheck -= 1;
                            ycheck += 1;
                        }
                        move.setPieceCaptured(pieceToCapture);
                        return true;
                    } else {
                        xcheck = move.x1 - 1;
                        ycheck = move.y1 - 1;
                        while (xcheck >= move.x2 && ycheck >= move.y2){
                            if (squares[xcheck][ycheck].getPiece() != null){
                                return false;
                            }
                            xcheck -= 1;
                            ycheck -= 1;
                        }
                        move.setPieceCaptured(pieceToCapture);
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
