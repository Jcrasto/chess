package gamePlay;

import pieces.*;

import java.util.HashMap;

public class Board {

    Square[][] squares;
    HashMap<Character, Integer> letterCoords = new HashMap<>();

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
                squares[i][j] = new Square(i, j, null);
            }
        }

        letterCoords.put('a', 1);
        letterCoords.put('b', 2);
        letterCoords.put('c', 3);
        letterCoords.put('d', 4);
        letterCoords.put('e', 5);
        letterCoords.put('f', 6);
        letterCoords.put('g', 7);
        letterCoords.put('h', 8);

    }

    public void move(Player player, String[] moveArray) throws Exception {
        String startString = moveArray[0];
        String endString = moveArray[1];
        boolean isWhite = player.isWhiteSide();
        PieceType pieceToMove = null;
        if (startString.length() == 3) {
            Character pieceChar = startString.charAt(0);
            if (pieceChar.equals('K')) {
                pieceToMove = PieceType.KING;
            } else if (pieceChar.equals('Q')) {
                pieceToMove = PieceType.QUEEN;
            } else if (pieceChar.equals('R')) {
                pieceToMove = PieceType.ROOK;
            } else if (pieceChar.equals('B')) {
                pieceToMove = PieceType.BISHOP;
            } else if (pieceChar.equals('N')) {
                pieceToMove = PieceType.KNIGHT;
            } else {
                throw new Exception("Piece must be K,Q,R,B,N");
            }
            startString = startString.substring(1, 3);
            endString = endString.substring(1, 3);
        } else {
            pieceToMove = PieceType.PAWN;
        }
        Character startXCoord = startString.charAt(0);
        Character startYCoord = endString.charAt(1);
        int x1 = letterCoords.get(startXCoord);
        int y1 = Character.getNumericValue(startYCoord);
        Character endXCoord = startString.charAt(0);
        Character endYCoord = endString.charAt(1);
        int x2 = letterCoords.get(endXCoord);
        int y2 = Character.getNumericValue(endYCoord);

        if (squares[x1][y1].getPiece().getType() == pieceToMove){

        }else{
            throw new Exception();
        }

    }
}

