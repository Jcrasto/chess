package gamePlay;

import java.util.Scanner;

public class Player {
    public boolean whiteSide;
    Player(boolean isWhite){
        whiteSide = isWhite;
    }

    public boolean isWhiteSide() {
        return this.whiteSide == true;
    }
}
