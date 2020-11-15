package gamePlay;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class MoveTest {
    Player player = new Player(true);

    @Test
    public void badSyntaxmoves(){
        ArrayList<String> testStrings = new ArrayList<String>(Arrays.asList("Test Test Test", "Test Test", "d2 d4"));
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
        Move move = new Move (player,"d2 d4");
        System.out.println(String.format("Moved: %s",move.pieceToMoveType));
    }

    @Test
    public void knightMoveTest() throws Exception{
        Move move = new Move (player,"Kg1 Kf3");
        System.out.println(String.format("Moved: %s",move.pieceToMoveType));
    }

}
