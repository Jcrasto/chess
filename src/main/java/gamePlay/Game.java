package gamePlay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {
    private Player[] players;
    private Board board;
    private Player currentTurn;
    private GameStatus status;
    private List<String> movesPlayed;



    public Game() {
        this.players = new Player[2];
        this.board = new Board();
        this.status = GameStatus.WHITE_TURN;
        this.movesPlayed = new ArrayList<>();
    }

    public void initialize(Player white, Player black) {
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

    public List<String> getMovesPlayed(){
        return this.movesPlayed;
    }

    public boolean playerMove(String moveString) throws Exception {
        String[] moveArray = moveString.split(" ");
        try{
            Move move = new Move(currentTurn, moveString);
        } catch(Exception e){
            throw e;
        }
        try {
            moveArray = moveString.split(" ");
            board.move(currentTurn, moveArray);
            movesPlayed.add(moveString);
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


}
