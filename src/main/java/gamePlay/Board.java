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

        squares[0][7] = new Square(0, 0, new Rook(false));
        squares[1][7] = new Square(1, 0, new Knight(false));
        squares[2][7] = new Square(2, 0, new Bishop(false));
        squares[3][7] = new Square(3, 0, new Queen(false));
        squares[4][7] = new Square(4, 0, new King(false));
        squares[5][7] = new Square(5, 0, new Bishop(false));
        squares[6][7] = new Square(6, 0, new Knight(false));
        squares[7][7] = new Square(7, 0, new Rook(false));

        for (int i = 0; i <= 7; i++) {
            squares[i][6] = new Square(i, 6, new Pawn(false));
        }

        // Empty Squares

        for (int i = 2; i < 6; i++) {
            for (int j = 0; j <= 7; j++) {
                squares[i][j] = new Square(i, j, null);
            }
        }

    }
}
