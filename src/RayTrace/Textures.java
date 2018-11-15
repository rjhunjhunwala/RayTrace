package RayTrace;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Textures {
    public static BufferedImage DENERO;
static{
    try {
        DENERO = ImageIO.read(new File("DeNeroTest.jpeg"));
    }catch(Exception ex){
        System.err.println(ex);
        System.err.println("Could not find Denero!");
    }
    }
    public static BufferedImage BRICKS;
    static{
        try {
            BRICKS = ImageIO.read(new File("bricks.jpg"));
        }catch(Exception ex){
            System.err.println(ex);
            System.err.println("Could not find BRICKS!");
        }
    }
    public static BufferedImage CARPET;
    static{
        try {
            CARPET = ImageIO.read(new File("Carpet.jpeg"));
        }catch(Exception ex){
            System.err.println(ex);
            System.err.println("Could not find carpet!");
        }
    }
    public static BufferedImage CEILING;
    static{
        try {
            CEILING = ImageIO.read(new File("Ceiling.jpg"));
        }catch(Exception ex){
            System.err.println(ex);
            System.err.println("Could not find ceiling!");
        }
    }
}
