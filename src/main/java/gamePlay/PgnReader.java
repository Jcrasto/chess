package gamePlay;

import java.io.File;
import java.util.Scanner;

public class PgnReader {
    public PgnReader(String pgnFilePath) throws Exception{
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
                continue;
            } else {
                System.out.println(line);
            }
        }
    }
}
