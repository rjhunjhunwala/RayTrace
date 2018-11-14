package RayTrace;

import java.awt.*;

public class Pane implements Surface {
    /**
     * Long story short, this is the best way to handle division by zero...
     */

    private final double radius = 3;
    public double X_LENGTH, Y_LENGTH;
    private double[] normal;
    private double[] X_AXIS, Y_AXIS, upper_left;
    private double[] center = new double[3];
    private double[] myColor = new double[]{0, 0, 255.0};
    private double REFLECTIVITY = 0.5;

    public Pane(double[] normal, double[] X_AXIS, double[] Y_AXIS, double[] upper_left, double X_LENGTH, double Y_LENGTH) {
        this.normal = normal;
        this.X_AXIS = X_AXIS;
        this.Y_AXIS = Y_AXIS;
        this.upper_left = upper_left;
        this.X_LENGTH = X_LENGTH;
        this.Y_LENGTH = Y_LENGTH;
    }

    public double getREFLECTIVITY() {
        return REFLECTIVITY;
    }

    public void setREFLECTIVITY(double REFLECTIVITY) {
        this.REFLECTIVITY = REFLECTIVITY;
    }

    public double[] getNormalVector(double[] surface, double[] direction) {

        if (VectorMath.dot(normal, direction) < 0) {
            return normal;
        } else {
            return VectorMath.scale(normal, -1);
        }
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
        //We solve a 3x3 system of equations...
        double[][] A = new double[3][3];
        double[] b = new double[3];
        A[0][2] = normal[0];
        A[1][2] = normal[1];
        A[2][2] = normal[2];

        b[2] = VectorMath.dot(normal, upper_left);


        A[0][0] = direction[1];
        A[1][0] = -direction[0];
        b[0] = direction[1] * source[0] - direction[0] * source[1];

        A[1][1] = direction[2];
        A[2][1] = -direction[1];
        b[1] = direction[2] * source[1] - direction[1] * source[2];

        double[] intersection = VectorMath.matrixProduct(VectorMath.invert3(A), b);

        double[] disp = VectorMath.subtract(intersection, upper_left);

        double dotProd1 = VectorMath.dot(disp, X_AXIS);
        double dotProd2 = VectorMath.dot(disp, Y_AXIS);
        if (dotProd1 > 0 && dotProd2 > 0 && dotProd1 < X_LENGTH && dotProd2 < Y_LENGTH) {
           double res = VectorMath.dot(VectorMath.subtract(intersection,source),direction);
           if(res > Sphere.MIN_DISTANCE) {
               //System.out.println(res);
               return res;
           }
        }

        return null;
    }


}
