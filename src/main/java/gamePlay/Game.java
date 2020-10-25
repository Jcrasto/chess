package gamePlay;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Player[] players;
    private Board board;
    private Player currentTurn;
    private GameStatus status;
    private List<String> startPositions;
    private List<String> movesPlayed;


    public Game() {
        this.players = new Player[2];
        this.board = new Board();
        this.status = GameStatus.WHITE_TURN;
        this.startPositions = new ArrayList<>();
        this.movesPlayed = new ArrayList<>();
    }

    void initialize(Player white, Player black) {
        players[0] = white;
        players[1] = black;

        board.resetBoard();

        this.status = GameStatus.WHITE_TURN;
        currentTurn = white;

        movesPlayed.clear();
    }

    public boolean isEnd() {
        return (this.getStatus() != GameStatus.WHITE_TURN && this.getStatus() != GameStatus.BLACK_TURN);
    }

    public GameStatus getStatus() {
        return this.status;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }

    public boolean playerMove(String moveString) throws Exception {
        String[] moveArray = moveString.split(" ");

        try{
            checkMoveSyntax(moveArray);
        } catch(Exception e){
            throw e;
        }

        try {
            board.move(currentTurn, moveArray);
        } catch(Exception e){
            throw e;
        }

        if (status == GameStatus.WHITE_TURN) {
            currentTurn = players[0];
        }
        if (status == GameStatus.BLACK_TURN) {
            currentTurn = players[1];
        }
        return true;
    }
    public void checkMoveSyntax(String[] moveArray) throws Exception{
        if (moveArray.length != 2) {
            throw new Exception("Enter start and end positions separated by a space");
        }

        String start = moveArray[0];
        String end = moveArray[1];

        if(start.length() != end.length()){
            throw new Exception("Move lengths must match");
        }

        if (start.length() < 2 || start.length() > 3){
            throw new Exception("Enter a valid length move");
        }
        if (start.length() == 3){
            if (start.charAt(0) != end.charAt(0)){
                throw new Exception("Start and end piece must match");
            }
        }

    }
//        Square startSquare = board.getSquare(startX, startY);
//        Square endSquare = board.getSquare(endX, endY);
//        Move move = new Move(player, startSquare, endSquare);
//        return this.makeMove(move, player);
//    }
//
//    private boolean makeMove(Move move, Player player){
//        Piece sourcePiece = move.getStart().getPiece();
//        if (sourcePiece == null){
//            return false;
//        }
//
//        if (player != currentTurn){
//            return false;
//        }
//
//        if (sourcePiece.isWhite() != player.isWhiteSide()){
//            return false;
//        }
//
//        if(!sourcePiece.canMove(board, move.getStart(), move.getEnd())){
//            return false;
//        }
//
//        Piece destPiece = move.getEnd().getPiece();
//        if (destPiece != null){
//            destPiece.setCaptured(true);
//        }
//
//        if (sourcePiece != null && sourcePiece instanceof King){
//            if (player.isWhiteSide()){
//                this.setStatus(GameStatus.WHITE_WIN);
//            }
//            else{
//                this.setStatus(GameStatus.BLACK_WIN);
//            }
//        }
//
//        if (this.currentTurn == players[0]){
//            this.currentTurn = players[1];
//        }
//        else {
//            this.currentTurn = players[0];
//        }
//        return true;
//    }

}
