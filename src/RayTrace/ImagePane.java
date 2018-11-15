package RayTrace;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ImagePane extends Pane{
    private BufferedImage texture;
    public ImagePane(double[] normal, double[] X_AXIS, double[] Y_AXIS, double[] upper_left, double X_LENGTH, double Y_LENGTH, BufferedImage b) {
        super(normal,X_AXIS,Y_AXIS, upper_left,X_LENGTH, Y_LENGTH);
        this.texture = b;
    }

    @Override
    public double getREFLECTIVITY() {
        return 0.1;
    }

    @Override
    public double[] getColorAtPoint(double[] point) {
        double[] disp = VectorMath.subtract(point, upper_left);
        double xDist = VectorMath.dot(disp,X_AXIS);
        double yDist = VectorMath.dot(disp,Y_AXIS);
        int xCoord = (int) (texture.getWidth() * xDist / X_LENGTH);
        int yCoord = (int) (texture.getHeight() * yDist / Y_LENGTH);
        try {
            Color out = new Color(texture.getRGB(xCoord, yCoord));
            return new double[]{out.getRed(), out.getGreen(), out.getGreen()};
        }catch(Exception ex) {
        System.err.println(xCoord+"|"+yCoord);
        return new double[]{0,255.0,0};
        }

    }
}
