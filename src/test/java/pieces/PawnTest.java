package pieces;
import gamePlay.Game;
import gamePlay.GameStatus;
import gamePlay.Player;
import org.junit.jupiter.api.Test;

public class PawnTest {
    @Test
    public void firstMoveTest() throws Exception{
        Game game = new Game();
        Player white = new Player(true);
        Player black = new Player(false);
        game.initialize(white, black);

        game.setStatus(GameStatus.WHITE_TURN);
        try {
            game.playerMove("d2 d5");
        } catch(Exception e){
            System.out.println(e);
        }
        game.playerMove("d2 d4");
    }

    @Test
    public void QueensGambitTest() throws Exception{
        Game game = new Game();
        Player white = new Player(true);
        Player black = new Player(false);
        game.initialize(white, black);
        game.setStatus(GameStatus.WHITE_TURN);
        game.playerMove("d2 d4");
        game.setStatus(GameStatus.BLACK_TURN);
        game.playerMove("d7 d5");
        game.setStatus(GameStatus.WHITE_TURN);
        game.playerMove("c2 c4");


    }
}
