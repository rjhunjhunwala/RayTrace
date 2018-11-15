package GUI;
import javax.swing.*;


public class MainFrame extends JFrame {
    public static final int SIZE = 1024;
    public MainFrame() {
        super("Here is your rendering!");
        this.add(new MainPanel());
        this.pack();
        this.setVisible(true);
        this.setResizable(false);
        this.setAlwaysOnTop(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}