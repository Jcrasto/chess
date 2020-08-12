package gamePlay;

import pieces.*;

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
        this.status = GameStatus.ACTIVE;
    }

    void initialize(Player p1, Player p2) {
        players[0] = p1;
        players[1] = p2;

        board.resetBoard();

        if (p1.isWhiteSide()){
            this.currentTurn = p1;
        }
        else {
            this.currentTurn = p2;
        }

        movesPlayed.clear();
    }

    public boolean isEnd(){
        return this.getStatus() != GameStatus.ACTIVE;
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
