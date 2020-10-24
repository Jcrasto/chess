package gamePlay;

import pieces.*;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Player[] players;
    private Board board;
    private Player currentTurn;
    private GameStatus status;
    private List<Move> movesPlayed;

    public Game(){
        this.players = new Player[2];
        this.board = new Board();
        this.status = GameStatus.WHITE_TURN;
        this.movesPlayed = new ArrayList<>();
    }

    void initialize(Player white, Player black) {
        players[0] = white;
        players[1] = black;

        board.resetBoard();

        if (this.status == GameStatus.WHITE_TURN){
            this.currentTurn = white;
        }
        else if (this.status == GameStatus.BLACK_TURN) {
            this.currentTurn = black;
        }

        movesPlayed.clear();
    }

    public boolean isEnd(){
        return (this.getStatus() != GameStatus.WHITE_TURN ||this.getStatus() != GameStatus.BLACK_TURN);
    }

    public GameStatus getStatus(){
        return this.status;
    }

    public void setStatus(GameStatus status){
        this.status = status;
    }

    public boolean playerMove(Player player, int startX, int startY,
                              int endX, int endY) throws Exception{
        Square startSquare = board.getSquare(startX, startY);
        Square endSquare = board.getSquare(endX, endY);
        Move move = new Move(player, startSquare, endSquare);
        return this.makeMove(move, player);
    }

    private boolean makeMove(Move move, Player player){
        Piece sourcePiece = move.getStart().getPiece();
        if (sourcePiece == null){
            return false;
        }

        if (player != currentTurn){
            return false;
        }

        if (sourcePiece.isWhite() != player.isWhiteSide()){
            return false;
        }

        if(!sourcePiece.canMove(board, move.getStart(), move.getEnd())){
            return false;
        }

        Piece destPiece = move.getEnd().getPiece();
        if (destPiece != null){
            destPiece.setCaptured(true);
        }

        if (sourcePiece != null && sourcePiece instanceof King){
            if (player.isWhiteSide()){
                this.setStatus(GameStatus.WHITE_WIN);
            }
            else{
                this.setStatus(GameStatus.BLACK_WIN);
            }
        }

        if (this.currentTurn == players[0]){
            this.currentTurn = players[1];
        }
        else {
            this.currentTurn = players[0];
        }
        return true;
    }

}
