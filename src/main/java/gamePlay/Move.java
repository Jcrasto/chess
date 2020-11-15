package gamePlay;

import java.util.ArrayList;
import java.util.Arrays;

public class Move {
    public Player player;
    public String moveString;
    public String[] moveArray;
    public Character pieceChar = null;
    public int x1;
    public int y1;
    public int x2;
    public int y2;

    public Move(Player player, String moveString) throws Exception {
        this.player = player;
        this.moveString = moveString;
        this.moveArray = moveString.split(" ");
        try {
            checkMoveSyntax(moveString);
        } catch (Exception e) {
            throw e;
        }
        try {
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
        if (start.length() == 3) {
            if (start.charAt(0) != end.charAt(0)) {
                throw new Exception("Start and end piece must match");
            }
            ArrayList<Character> pieceList = new ArrayList<>(Arrays.asList('K', 'Q', 'R', 'N', 'B'));
            if (pieceList.contains(start.charAt(0))) {
                this.pieceChar = start.charAt(0);
            } else {
                throw new Exception("Piece must be K,Q,R,B,N");
            }

        }

        for (String move : moveArray) {
            Character xCoord = move.charAt(0);
            Character yCoord = move.charAt(1);
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

    }
}