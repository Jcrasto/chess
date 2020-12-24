import javax.swing.*;

public class AlphaBetaChess {
    public static void main(String[] args) {
        JFrame f=new JFrame("Logic Crazy Chess Tutorial");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        UserInterface ui=new UserInterface();
        f.add(ui);
        f.setSize(500, 500);
        f.setVisible(true);
    }
}