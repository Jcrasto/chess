package gamePlay;

import java.util.ArrayList;
import java.util.Arrays;
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
            moveArray = moveString.split(" ");
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
            ArrayList<Character> pieceList = new ArrayList<Character>(Arrays.asList('K', 'Q', 'R', 'N', 'B'));
            if (pieceList.contains(start.charAt(0))){
                moveArray[0] = moveArray[0].substring(1);
                moveArray[1] = moveArray[1].substring(1);
            } else {
                throw new Exception ("Piece must be K,Q,R,B,N");
            }

        }

        for (String move: moveArray){
            Character xCoord = move.charAt(0);
            Character yCoord = move.charAt(1);
            if (xCoord >= 'a' && xCoord <= 'h'){
                if (Character.isDigit(yCoord)){
                    int y = Character.getNumericValue(yCoord);;
                    if ( y < 1 || y > 8){
                        System.out.println(y);
                        throw new Exception ("Second character should be a number between 1 and 8");
                    }
                } else {
                    throw new Exception ("Second character should be a number between 1 and 8");
                }
            } else{
                throw new Exception("First letter of square should be between a and h");
            }
        }

    }

}
