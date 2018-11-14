package RayTrace;

import GUI.MainFrame;
import GUI.MainPanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.util.Arrays;

public class Main {
    public static final int SIZE = MainFrame.SIZE;
    public static final Color[][] colors = new Color[SIZE][SIZE];

    /**
     * Entry point
     *
     * @param args unused CLA
     */

    public static void main(String[] args) {



        Render render = new Render();
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                colors[x][y] = render.renderColor(x, y);
            }
        }


        GUI.MainFrame main = new MainFrame();
        main.repaint();

        new Thread(
                new Runnable() {
                    public void run() {
                        System.out.println("test!");
                        try {
                            ImageIO.write(MainPanel.canvas,"png",new File((new java.util.Scanner(System.in)).nextLine()));
                        } catch (Exception ex) {
                            System.err.println("Oops!");
                            ex.printStackTrace();
                        }
                    }
                }
        ).start();

    }
}
