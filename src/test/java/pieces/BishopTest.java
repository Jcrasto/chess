package pieces;

import gamePlay.Game;
import gamePlay.GameStatus;
import gamePlay.Move;
import gamePlay.Player;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class BishopTest {
    @Test
    public void firstMoveTest() throws Exception{
        Game game = new Game();
        Player white = new Player(true);
        Player black = new Player(false);
        game.initialize(white, black);

        game.setStatus(GameStatus.WHITE_TURN);

        ArrayList<String> testStrings = new ArrayList<>(Arrays.asList("Bc1 Bg5", "Bf8 Bb4"));
        for(String moveString: testStrings){
            try {
                game.playerMove(moveString);
            } catch(Exception e){
                System.out.println(e);
            }
        }
    }

    @Test
    public void trompowsky() throws Exception{
        Game game = new Game();
        Player white = new Player(true);
        Player black = new Player(false);
        game.initialize(white, black);

        game.setStatus(GameStatus.WHITE_TURN);
        game.playerMove("d2 d4");
        game.setStatus(GameStatus.BLACK_TURN);
        game.playerMove("Ng8 Nf6");
        game.setStatus(GameStatus.WHITE_TURN);
        game.playerMove("Bc1 Bg5");
    }

}
