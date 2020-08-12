package gamePlay;

import org.junit.jupiter.api.Test;
import gamePlay.*;

public class GameTest {
    @Test
    public void GameTest(){
        Game game = new Game();
        HumanPlayer p1 = new HumanPlayer(true);
        HumanPlayer p2 = new HumanPlayer(false);
        game.initialize(p1,p2);
    }

}
