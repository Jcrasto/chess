package gamePlay;

import java.util.Scanner;

public class GamePlayBootstrap {
    public static void main(String[] args) {
        Game game = new Game();
        while (game.getStatus() == GameStatus.WHITE_TURN || game.getStatus() == GameStatus.BLACK_TURN) {

            if (game.getStatus() == GameStatus.WHITE_TURN) {
                Scanner myObj = new Scanner(System.in);
                System.out.println("White Move");

                String move = myObj.nextLine();
                System.out.println("White Move " + move);
                game.setStatus(GameStatus.BLACK_TURN);
            }

            if (game.getStatus() == GameStatus.BLACK_TURN) {
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