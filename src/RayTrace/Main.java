package RayTrace;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Main {
    public static final int SIZE = 480;
    public static final Color[][] colors = new Color[SIZE][SIZE];

    /**
     * Adds two colors, clamps the size to be [0,256)
     *
     * @param c1
     * @param c2
     */
    public static void add(Color c1, Color c2) {
        return new Color(Math.min(255, c1.getRed() + c2.getRed()), Math.min(255, c1.getGreen() + c2.getGreen()), Math.min(255, c1.getBlue() + c2.getBlue()))
    }

    /**
     * Adds two three dimensional vectors
     */
    public static double[] add(double[] v1, double[] v2) {
        return new double[]{v1[0] + v2[0], v1[1] + v2[1], v1[2] + v2[2]};
    }

    /**
     * Defines scalar multiplication, on three dimensional vectors
     * @param v1 input vector
     * @param a scalar
     * @return a scaled version
     */
    public static double[] scale(double[] v1, double a){
        return new double[]{v1[0]*a, v1[1]*a, v1[2]*a};
    }
    /**
     * Defines Euclidean norm on a three dimensional vector
     */
    public static void norm()

    /**
     * Entry point
     * @param args unused CLA
     */

    public static void main(String[] args) {
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                colors[x][y] = render_color(x, y);
            }
        }
        MainFrame main = new MainFrame();
        for (; ; )
            main.repaint();
    }

    public static Color render_color(int x, int y) {

        //TODO: make this work

        int a = (((x >>> 4) + (y >>> 4)) & 1) << 8 - 1;
        return new Color(a, a, a);
    }

    public static class MainFrame extends JFrame {
        public MainFrame() {
            super("Here is your rendering!");
            this.add(new MainPanel());
            this.pack();
            this.setVisible(true);
            this.setAlwaysOnTop(true);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        }
    }

    public static class MainPanel extends JPanel {
        public Dimension getPreferredSize() {
            return new Dimension(SIZE, SIZE);
        }

        public void paintComponent(Graphics g) {
            BufferedImage canvas = new BufferedImage(SIZE, SIZE, BufferedImage.TYPE_INT_ARGB);
            for (int x = 0; x < SIZE; x++) {
                for (int y = 0; y < SIZE; y++) {
                    canvas.setRGB(x, y, colors[x][y].getRGB());
                }
            }
            g.drawImage(canvas, 0, 0, null);
        }
    }
}
