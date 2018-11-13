package RayTrace;

import GUI.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Main {
    public static final int SIZE = MainFrame.SIZE;
    public static final Color[][] colors = new Color[SIZE][SIZE];

    /**
     * Entry point
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
        for (;;)
            main.repaint();
    }
}
