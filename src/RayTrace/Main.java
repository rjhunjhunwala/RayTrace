package RayTrace;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static final int SIZE = 480;
    public static final Color[][] colors = new Color[SIZE][SIZE];

    public static void main(String[] args) {
        for(int x = 0; x<SIZE; x++){
            for(int y = 0; y<SIZE;y++){

            }
        }
    }
    public class MainFrame extends JFrame{
        public MainFrame()
    }
    public class MainPanel extends JPanel{
        public Dimension getPreferredSize(){
            return new Dimension(SIZE,SIZE);
        }
        public void paintComponent(Graphics g){
            for(int x = 0; x<SIZE; x++){
                for(int y = 0; y<SIZE;y++){

                }
            }
        }
    }
}
