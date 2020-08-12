package gamePlay;

import org.junit.jupiter.api.Test;

public class HumanPlayerTest {
    HumanPlayer player;

    @Test
    public void getMoveTest(){
        this.player = new HumanPlayer(true);
        player.getMove();

    }


}
