import javax.swing.*;

public class Main {


    public static void main(String[] args) {


        SwingUtilities.invokeLater(new Runnable() {
            public void run() {

                try {
                    GUI gui = new GUI();
                } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
                    e.printStackTrace();
                }

            }

        });
    }
}