package gamePlay;

import org.junit.jupiter.api.Test;

public class PgnReaderTest {

    @Test
    public void readFileTest() throws Exception{
        String filepath = "./src/test/resources/PolgarTest.pgn";
//        String filepath = "/Users/joshcrasto 1/JoshCrasto/2020/data-directory/chesspgn/PolgarJ.pgn";
        PgnReader reader = new PgnReader(filepath);
    }

}
