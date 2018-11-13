package RayTrace;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static final int SIZE = 480;
    public static final Color[][] colors = new Color[SIZE][SIZE];

    public static void main(String[] args) {
        for(int x = 0; x<SIZE; x++){
            for(int y = 0; y<SIZE;y++){
                colors[x][y] = render_color(x,y);
            }
        }
    }
    public static Color render_color(int x, int y){

        //TODO: make this work

        return Color.black;
    }
    public class MainFrame extends JFrame{
        public MainFrame(){
            super("Here is your rendering!");
            this.add(new MainPanel());
            this.setVisible(true);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        }
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
