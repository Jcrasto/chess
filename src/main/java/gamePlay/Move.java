package gamePlay;

import pieces.Piece;
import pieces.PieceType;
import java.util.HashMap;

public class Move {
    public Player player;
    public String moveString;
    public PieceType pieceToMoveType;
    public int x1;
    public int y1;
    public int x2;
    public int y2;
    public boolean capture = false;
    public boolean check = false;
    public boolean castle = false;
    public HashMap<Character, Integer> letterCoords = new HashMap<>();
    public Piece pieceCaptured = null;

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
        try {
            checkMoveSyntax();
        } catch (Exception e) {
            throw e;
        }
    }

    private void checkMoveSyntax() throws Exception {
        if (Character.isLowerCase(this.moveString.charAt(0))){
            setPieceToMove(null);
        } else if (this.moveString.length() > 2 && Character.isUpperCase(this.moveString.charAt(0))
                && this.moveString.charAt(0)!='O'){
            setPieceToMove(this.moveString.charAt(0));
        } else if (this.moveString.charAt(0)!='O'){
            checkCastle();
        } else {
            throw new Exception("[Move - checkMoveSyntax] Not a valid move");
        }

    }

    public void setMoveCoordinates(Square[][] squares) {
        if (this.pieceToMoveType == PieceType.PAWN){

        }

//        String startString = new String();
//        String endString = new String();
//        if (moveArray[0].length() == 3) {
//            startString = moveArray[0].substring(1, 3);
//            endString = moveArray[1].substring(1, 3);
//        } else {
//            startString = moveArray[0];
//            endString = moveArray[1];
//        }
//        Character startXCoord = startString.charAt(0);
//        Character startYCoord = startString.charAt(1);
//        this.x1 = letterCoords.get(startXCoord);
//        this.y1 = Character.getNumericValue(startYCoord) - 1;
//        Character endXCoord = endString.charAt(0);
//        Character endYCoord = endString.charAt(1);
//        this.x2 = letterCoords.get(endXCoord);
//        this.y2 = Character.getNumericValue(endYCoord) - 1;

    }

    private void setPieceToMove(Character pieceChar) throws Exception {
        if (pieceChar.equals(null)) {
            pieceToMoveType = PieceType.PAWN;
        } else {
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
                throw new Exception("[Move - setPieceToMove] Piece must be K,Q,R,B,N");
            }
        }
    }

    public void setPieceCaptured(Piece piece){
        this.pieceCaptured = piece;
        this.capture = true;
    }

    public void checkCastle(){
        this.castle = true;
    }


}