package gamePlay;

import java.io.File;
import java.util.Scanner;

public class PgnFileReader {
    public PgnFileReader(String pgnFilePath) throws Exception{
        File file = new File(pgnFilePath);
        Scanner sc = new Scanner(file);
        String line;
        String gameString = "";
        while (sc.hasNextLine()) {
            line = sc.nextLine();
            if (line.equals("")){
                continue;
            }
            else if (line.charAt(0) == '['){
                if (gameString != "") {
                    PgnStringReader gameReader = new PgnStringReader(gameString);
                    gameString = "";
                }
                continue;
            } else {
                gameString += line;
            }
        }
    }
}
