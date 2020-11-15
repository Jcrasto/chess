package gamePlay;

public class Player {
    public boolean whiteSide;

    public Player(boolean isWhite) {
        whiteSide = isWhite;
    }

    public boolean isWhiteSide() {
        return this.whiteSide == true;
    }
}
