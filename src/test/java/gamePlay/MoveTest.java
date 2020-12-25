package gamePlay;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class MoveTest {
    Player player = new Player(true);

    @Test
    public void checkSyntaxMoves(){
        ArrayList<String> testStrings = new ArrayList<String>(Arrays.asList("d4", "Kf3"));
        for(String moveString: testStrings){
            try {
                Move move = new Move(player, moveString);
                System.out.println(move.moveString + " is a valid move");
            } catch(Exception e){
                System.out.println(e);
            }
        }
    }

    @Test
    public void pawnMoveTest() throws Exception{
        Move move = new Move (player,"d4");
        System.out.println(String.format("Moved: %s",move.pieceToMoveType));
    }

    @Test
    public void knightMoveTest() throws Exception{
        Move move = new Move (player,"Kf3");
        System.out.println(String.format("Moved: %s",move.pieceToMoveType));
    }

}
