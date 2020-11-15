package pieces;

import gamePlay.Game;
import gamePlay.GameStatus;
import gamePlay.Player;
import org.junit.jupiter.api.Test;

public class KnightTest {
    @Test
    public void RetiTest() throws Exception{
        Game game = new Game();
        Player white = new Player(true);
        Player black = new Player(false);
        game.initialize(white, black);
        game.setStatus(GameStatus.WHITE_TURN);
        game.playerMove("Ng1 Nf3");
        System.out.println(game.getMovesPlayed());

    }
}
