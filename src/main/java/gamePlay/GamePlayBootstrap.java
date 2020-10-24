package gamePlay;

import java.util.Scanner;

public class GamePlayBootstrap {
    public static void main(String[] args) {
        Game game = new Game();
        Player white = new Player(true);
        Player black = new Player(false);
        game.initialize(white, black);

        while (game.getStatus() == GameStatus.WHITE_TURN || game.getStatus() == GameStatus.BLACK_TURN) {

            while (game.getStatus() == GameStatus.WHITE_TURN) {
                Scanner myObj = new Scanner(System.in);
                System.out.println("White Move");

                String move = myObj.nextLine();
                System.out.println("White Move " + move);
                try {
                    game.playerMove(move);
                } catch (Exception e){
                    System.out.println(e);
                    continue;
                }
                game.setStatus(GameStatus.BLACK_TURN);
            }

            while (game.getStatus() == GameStatus.BLACK_TURN) {
                Scanner myObj = new Scanner(System.in);
                System.out.println("Black Move");

                String move = myObj.nextLine();
                System.out.println("Black Move " + move);
                game.setStatus(GameStatus.WHITE_TURN);
            }
        }
        System.out.println(game.getStatus());
    }
}