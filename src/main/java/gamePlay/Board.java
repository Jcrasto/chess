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
                squares[j][i] = new Square(j, i, null);
            }
        }

        letterCoords.put('a', 0);
        letterCoords.put('b', 1);
        letterCoords.put('c', 2);
        letterCoords.put('d', 3);
        letterCoords.put('e', 4);
        letterCoords.put('f', 5);
        letterCoords.put('g', 6);
        letterCoords.put('h', 7);

    }

    public void move(Player player, String[] moveArray) throws Exception {
        String startString = moveArray[0];
        String endString = moveArray[1];
        boolean isWhite = player.isWhiteSide();
        PieceType pieceTypeToMove = null;
        if (startString.length() == 2) {
            pieceTypeToMove = PieceType.PAWN;
        } else {
            Character pieceChar = startString.charAt(0);
            if (pieceChar.equals('K')) {
                pieceTypeToMove = PieceType.KING;
            } else if (pieceChar.equals('Q')) {
                pieceTypeToMove = PieceType.QUEEN;
            } else if (pieceChar.equals('R')) {
                pieceTypeToMove = PieceType.ROOK;
            } else if (pieceChar.equals('B')) {
                pieceTypeToMove = PieceType.BISHOP;
            } else if (pieceChar.equals('N')) {
                pieceTypeToMove = PieceType.KNIGHT;
            } else {
                throw new Exception("Piece must be K,Q,R,B,N");
            }
            startString = startString.substring(1, 3);
            endString = endString.substring(1, 3);
        }
        Character startXCoord = startString.charAt(0);
        Character startYCoord = startString.charAt(1);
        int x1 = letterCoords.get(startXCoord);
        int y1 = Character.getNumericValue(startYCoord) - 1;
        Character endXCoord = endString.charAt(0);
        Character endYCoord = endString.charAt(1);
        int x2 = letterCoords.get(endXCoord);
        int y2 = Character.getNumericValue(endYCoord) - 1;

        Square startSquare = getSquare(x1,y1);
        Square endSquare = getSquare(x2,y2);

        if(startSquare.getPiece().equals(null)){
            throw new Exception(String.format("No piece on %s",startString));
        }
        if (startSquare.getPiece().getType() == pieceTypeToMove){
            if(startSquare.getPiece().canMove(squares,x1,y1,x2,y2)){
                Piece pieceToMove = startSquare.getPiece();
                squares[x1][y1].setPiece(null);
                squares[x2][y2].setPiece(pieceToMove);
            } else {
                throw new Exception (String.format("cant move %s on %s to %s", pieceTypeToMove, startString, endString));
            }
        }else{
            throw new Exception(String.format("No %s on %s", pieceTypeToMove,startString));
        }

    }

    public void move(Move move) throws Exception{
        String startString = move.moveArray[0];
        String endString = move.moveArray[1];
        boolean isWhite = move.player.isWhiteSide();
        PieceType pieceTypeToMove = null;
        if (startString.length() == 2) {
            pieceTypeToMove = PieceType.PAWN;
        } else {
            Character pieceChar = startString.charAt(0);
            if (pieceChar.equals('K')) {
                pieceTypeToMove = PieceType.KING;
            } else if (pieceChar.equals('Q')) {
                pieceTypeToMove = PieceType.QUEEN;
            } else if (pieceChar.equals('R')) {
                pieceTypeToMove = PieceType.ROOK;
            } else if (pieceChar.equals('B')) {
                pieceTypeToMove = PieceType.BISHOP;
            } else if (pieceChar.equals('N')) {
                pieceTypeToMove = PieceType.KNIGHT;
            } else {
                throw new Exception("Piece must be K,Q,R,B,N");
            }
            startString = startString.substring(1, 3);
            endString = endString.substring(1, 3);
        }
        Character startXCoord = startString.charAt(0);
        Character startYCoord = startString.charAt(1);
        int x1 = letterCoords.get(startXCoord);
        int y1 = Character.getNumericValue(startYCoord) - 1;
        Character endXCoord = endString.charAt(0);
        Character endYCoord = endString.charAt(1);
        int x2 = letterCoords.get(endXCoord);
        int y2 = Character.getNumericValue(endYCoord) - 1;

        Square startSquare = getSquare(x1,y1);
        Square endSquare = getSquare(x2,y2);

        if(startSquare.getPiece().equals(null)){
            throw new Exception(String.format("No piece on %s",startString));
        }
        if (startSquare.getPiece().getType() == pieceTypeToMove){
            if(startSquare.getPiece().canMove(squares,x1,y1,x2,y2)){
                Piece pieceToMove = startSquare.getPiece();
                squares[x1][y1].setPiece(null);
                squares[x2][y2].setPiece(pieceToMove);
            } else {
                throw new Exception (String.format("cant move %s on %s to %s", pieceTypeToMove, startString, endString));
            }
        }else{
            throw new Exception(String.format("No %s on %s", pieceTypeToMove,startString));
        }
    }
}

