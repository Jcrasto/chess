package gamePlay;

import java.util.Scanner;

public abstract class Player {
    public boolean whiteSide;
    public boolean humanPlayer;

    public boolean isWhiteSide() {
        return this.whiteSide == true;
    }

    public boolean isHumanPlayer() {
        return this.humanPlayer == true;
    }

//    public String getMove(){
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("enter a move:");
//        String moveString = scanner.nextLine();
//        return moveString;
//    }

}
