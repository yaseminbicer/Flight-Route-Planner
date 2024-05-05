import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
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
                ImageIcon icon = new ImageIcon("images/icon.png");
                panel2.setIconImage(icon.getImage());

            }
        });
    }

}