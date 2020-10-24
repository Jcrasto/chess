package gamePlay;

import java.util.Scanner;

public abstract class Player {
    public boolean whiteSide;

    public boolean isWhiteSide() {
        return this.whiteSide == true;
    }
}
