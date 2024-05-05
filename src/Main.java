import javax.swing.*;
public class Main {
    public static void main(String[] args) {


        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                WelcomeScreen panel2 = new WelcomeScreen();
                panel2.setTitle("Flight Route Planner");
                panel2.setVisible(true);
                panel2.setSize(800, 600);
                panel2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                panel2.setResizable(false);
                ImageIcon icon = new ImageIcon("images/icon.png");
                panel2.setIconImage(icon.getImage());

            }
        });
    }

}