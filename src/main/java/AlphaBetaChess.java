import javax.swing.*;

public class AlphaBetaChess {

    static String chessBoard[][] = {
            {"r", "n", "b", "q", "k", "b", "n", "r"},
            {"p", "p", "p", "p", "p", "p", "p", "p"},
            {" ", " ", " ", " ", " ", " ", "P", " "},
            {" ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " "},
            {"P", "P", "P", "P", "P", "P", "P", "P"},
            {"R", "N", "B", "Q", "K", "B", "N", "R"}};

    static int kingPositionWhite;
    static int kingPositionBlack;

    public static void main(String[] args) {
        JFrame f = new JFrame("Logic Crazy Chess Tutorial");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        UserInterface ui = new UserInterface();
        f.add(ui);
        f.setSize(500, 500);
        f.setVisible(true);
    }

    public static String possibleMoves() {
        String list = "";
        for (int i = 0; i < 64; i++) {
            switch (chessBoard[i / 8][i % 8]) {
                case "P":
                    list += possibleP(i);
                    break;
                case "N":
                    list += possibleN(i);
                    break;
                case "R":
                    list += possibleR(i);
                    break;
                case "B":
                    list += possibleB(i);
                    break;
                case "Q":
                    list += possibleQ(i);
                    break;
                case "K":
                    list += possibleK(i);
                    break;
            }
        }
        return "";// x1, y1, x2, y2, captured piece
    }

    public static String possibleP(int i) {
        String list = "";
        return list;
    }

    public static String possibleN(int i) {
        String list = "";
        return list;
    }

    public static String possibleR(int i) {
        String list = "";
        return list;
    }

    public static String possibleB(int i) {
        String list = "";
        return list;
    }

    public static String possibleQ(int i) {
        String list = "";
        String oldPiece;
        int r = i / 8;
        int c = i % 8;
        int temp = 1;
        for (int j = -1; j <= 1; j++) {
            for (int k = -1; k <= 1; k++) {
                try {
                    while (" ".equals(chessBoard[r + temp * j][c + temp * k])) {
                        oldPiece = chessBoard[r + temp * j][c + temp * k];
                        chessBoard[r][c] = " ";
                        chessBoard[r + temp * j][c + temp * k] = "Q";
                        if (kingSafe()) {
                            list = list + r + c + (r + temp * j) + (c + temp * k) + oldPiece;
                        }
                        chessBoard[r][c] = "Q";
                        chessBoard[r + temp * j][c + temp * k] = oldPiece;
                        temp++;
                    }
                    if (Character.isLowerCase(chessBoard[r + temp * j][c + temp * k].charAt(0))) {
                        oldPiece = chessBoard[r + temp * j][c + temp * k];
                        chessBoard[r][c] = " ";
                        chessBoard[r + temp * j][c + temp * k] = "Q";
                        if (kingSafe()) {
                            list = list + r + c + (r + temp * j) + (c + temp * k) + oldPiece;
                        }
                        chessBoard[r][c] = "Q";
                        chessBoard[r + temp * j][c + temp * k] = oldPiece;
                    }
                } catch (Exception e) {
                }
                temp = 1;
            }
        }
        return list;
    }

    public static String possibleK(int i) {
        String list = "";
        String oldPiece;
        int r = i / 8;
        int c = i % 8;
        for (int j = 0; j < 9; j++) {
            if (j != 4) {
                try {
                    if (Character.isLowerCase(chessBoard[r - 1 + j / 3][c - 1 + j % 3].charAt(0)) || " ".equals(chessBoard[r - 1 + j / 3][c - 1 + j % 3])) {
                        oldPiece = chessBoard[r - 1 + j / 3][c - 1 + j % 3];
                        chessBoard[r][c] = " ";
                        chessBoard[r - 1 + j / 3][c - 1 + j % 3] = "A";
                        int kingTemp = kingPositionWhite;
                        kingPositionWhite = i + (j / 3) * 8 + j % 3 - 9;
                        if (kingSafe()) {
                            list = list + r + c + (r - 1 + j / 3) + (c - 1 + j % 3) + oldPiece;
                        }
                        chessBoard[r][c] = "A";
                        chessBoard[r - 1 + j / 3][c - 1 + j % 3] = oldPiece;
                        kingPositionWhite = kingTemp;
                    }
                } catch (Exception e) {
                }
            }
        }
        //need to add casting later
        return list;
    }

    public static boolean kingSafe() {
        return true;
    }
}