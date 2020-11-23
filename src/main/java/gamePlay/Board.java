package gamePlay;

import pieces.*;

public class Board {

    Square[][] squares;

    public Board() {
        this.resetBoard();
    }

    public Square getSquare(int x, int y) throws Exception {
        if (x < 0 || x > 7 || y < 0 || y > 7) {
            throw new Exception("Index out of bounds");
        }
        return squares[x][y];
    }

    public void resetBoard() {

        this.squares = new Square[8][8];

        //White Pieces

        squares[0][0] = new Square(0, 0, new Rook(true));
        squares[1][0] = new Square(1, 0, new Knight(true));
        squares[2][0] = new Square(2, 0, new Bishop(true));
        squares[3][0] = new Square(3, 0, new Queen(true));
        squares[4][0] = new Square(4, 0, new King(true));
        squares[5][0] = new Square(5, 0, new Bishop(true));
        squares[6][0] = new Square(6, 0, new Knight(true));
        squares[7][0] = new Square(7, 0, new Rook(true));

        for (int i = 0; i <= 7; i++) {
            squares[i][1] = new Square(i, 1, new Pawn(true));
        }

        //Black Pieces

        squares[0][7] = new Square(0, 7, new Rook(false));
        squares[1][7] = new Square(1, 7, new Knight(false));
        squares[2][7] = new Square(2, 7, new Bishop(false));
        squares[3][7] = new Square(3, 7, new Queen(false));
        squares[4][7] = new Square(4, 7, new King(false));
        squares[5][7] = new Square(5, 7, new Bishop(false));
        squares[6][7] = new Square(6, 7, new Knight(false));
        squares[7][7] = new Square(7, 7, new Rook(false));

        for (int i = 0; i <= 7; i++) {
            squares[i][6] = new Square(i, 6, new Pawn(false));
        }

        // Empty Squares

        for (int i = 2; i < 6; i++) {
            for (int j = 0; j <= 7; j++) {
                squares[j][i] = new Square(j, i, null);
            }
        }

    }


    public void move(Move move) throws Exception {

        Square startSquare = getSquare(move.x1, move.y1);

        if (startSquare.getPiece().equals(null)) {
            throw new Exception(String.format("No piece on %s", move.moveArray[0]));
        }
        if (startSquare.getPiece().getType() == move.pieceToMoveType) {
            if (move.player.isWhiteSide() != startSquare.getPiece().isWhite()){
                throw new Exception("Piece is not player's to move");
            }
            if (startSquare.getPiece().canMove(squares, move)) {
                Piece pieceToMove = startSquare.getPiece();
                squares[move.x1][move.y1].setPiece(null);
                squares[move.x2][move.y2].setPiece(pieceToMove);
            } else {
                throw new Exception(String.format("cant move %s on %s to %s", move.pieceToMoveType, move.moveArray[0], move.moveArray[1]));
            }
        } else {
            throw new Exception(String.format("No %s on %s", move.pieceToMoveType, move.moveArray[0]));
        }
    }
}

