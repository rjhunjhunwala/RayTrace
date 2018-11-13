package RayTrace;

import java.awt.*;

public class Pane implements Surface {
    /**
     * Long story short, this is the best way to handle division by zero...
     */
    public static final double FAKE_INFINITY = 1000000000.0;
    public static final double MIN_DISTANCE = 0.01;
    private final double radius = 3;
    private double[] normal;
    private double[] X_AXIS, Y_AXIS, upper_left;
    private double[] center = new double[3];
    private double[] myColor = new double[]{0, 255.0, 0};
    private double REFLECTIVITY = 0.5;

    public Pane(double[] normal, double[] X_AXIS, double[] Y_AXIS, double[] upper_left) {
        this.normal = normal;
        this.X_AXIS = X_AXIS;
        this.Y_AXIS = Y_AXIS;
        this.upper_left = upper_left;
    }

    public double getREFLECTIVITY() {
        return REFLECTIVITY;
    }

    public void setREFLECTIVITY(double REFLECTIVITY) {
        this.REFLECTIVITY = REFLECTIVITY;
    }

    public double[] getNormalVector(double[] a, double[] b) {

        return normal;
    }

    @Override
    public double[] getColor() {
        return myColor;
    }

    public void setColor(Color c) {
        myColor = new double[]{c.getRed(), c.getGreen(), c.getBlue()};
    }

    public Color makeCanonicalColor() {
        return new Color((int) myColor[0], (int) myColor[1], (int) myColor[2]);
    }

    @Override
    public Double getIntersection(double[] source, double[] direction) {
        return null;
    }


}
