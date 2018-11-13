package GUI;

import RayTrace.Main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;


public class MainPanel extends JPanel {
    public static final int SIZE = MainFrame.SIZE;
    public static BufferedImage canvas = new BufferedImage(SIZE, SIZE, BufferedImage.TYPE_INT_ARGB);

    public Dimension getPreferredSize() {
        return new Dimension(SIZE, SIZE);
    }

    public void paintComponent(Graphics g) {

        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                canvas.setRGB(x, y, Main.colors[x][y].getRGB());
            }
        }
        g.drawImage(canvas, 0, 0, null);

    }
}