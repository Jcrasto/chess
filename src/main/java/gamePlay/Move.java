package gamePlay;

import pieces.Piece;
import pieces.PieceType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Move {
    public Player player;
    public String moveString;
    public String[] moveArray;
    public PieceType pieceToMoveType;
    public int x1;
    public int y1;
    public int x2;
    public int y2;
    public HashMap<Character, Integer> letterCoords = new HashMap<>();

    public Move(Player player, String moveString) throws Exception {
        letterCoords.put('a', 0);
        letterCoords.put('b', 1);
        letterCoords.put('c', 2);
        letterCoords.put('d', 3);
        letterCoords.put('e', 4);
        letterCoords.put('f', 5);
        letterCoords.put('g', 6);
        letterCoords.put('h', 7);

        this.player = player;
        this.moveString = moveString;
        this.moveArray = moveString.split(" ");
        try {
            checkMoveSyntax(moveString);
            setPieceToMove();
            setMoveCoordinates();
        } catch (Exception e) {
            throw e;
        }
    }

    private void checkMoveSyntax(String moveString) throws Exception {
        if (moveArray.length != 2) {
            throw new Exception("Enter start and end positions separated by a space");
        }

        String start = moveArray[0];
        String end = moveArray[1];

        if (start.length() != end.length()) {
            throw new Exception("Move lengths must match");
        }

        if (start.length() < 2 || start.length() > 3) {
            throw new Exception("Enter a valid length move");
        }

        for (String move : moveArray) {
            Character xCoord;
            Character yCoord;
            if (move.length() == 3){
                xCoord = move.charAt(1);
                yCoord = move.charAt(2);
            } else {
                xCoord = move.charAt(0);
                yCoord = move.charAt(1);
            }


            if (xCoord >= 'a' && xCoord <= 'h') {
                if (Character.isDigit(yCoord)) {
                    int y = Character.getNumericValue(yCoord);
                    ;
                    if (y < 1 || y > 8) {
                        System.out.println(y);
                        throw new Exception("Second character should be a number between 1 and 8");
                    }
                } else {
                    throw new Exception("Second character should be a number between 1 and 8");
                }
            } else {
                throw new Exception("First letter of square should be between a and h");
            }
        }

    }

    private void setMoveCoordinates() {
        String startString = new String();
        String endString = new String();
        if (moveArray[0].length() == 3) {
            startString = moveArray[0].substring(1, 3);
            endString = moveArray[1].substring(1, 3);
        } else {
            startString = moveArray[0];
            endString = moveArray[1];
        }
        Character startXCoord = startString.charAt(0);
        Character startYCoord = startString.charAt(1);
        this.x1 = letterCoords.get(startXCoord);
        this.y1 = Character.getNumericValue(startYCoord) - 1;
        Character endXCoord = endString.charAt(0);
        Character endYCoord = endString.charAt(1);
        this.x2 = letterCoords.get(endXCoord);
        this.y2 = Character.getNumericValue(endYCoord) - 1;

    }

    private void setPieceToMove() throws Exception {
        String start = moveArray[0];
        String end = moveArray[1];
        if (start.length() == 3) {
            if (start.charAt(0) != end.charAt(0)) {
                throw new Exception("Start and end piece must match");
            }
            Character pieceChar = start.charAt(0);
            if (pieceChar.equals('K')) {
                pieceToMoveType = PieceType.KING;
            } else if (pieceChar.equals('Q')) {
                pieceToMoveType = PieceType.QUEEN;
            } else if (pieceChar.equals('R')) {
                pieceToMoveType = PieceType.ROOK;
            } else if (pieceChar.equals('B')) {
                pieceToMoveType = PieceType.BISHOP;
            } else if (pieceChar.equals('N')) {
                pieceToMoveType = PieceType.KNIGHT;
            } else {
                throw new Exception("Piece must be K,Q,R,B,N");
            }

        } else {
            pieceToMoveType = PieceType.PAWN;
        }

    }

}