package RayTrace;

import java.awt.*;

public class VectorMath {
    /**
     * Return a "vectorized" weighted average between a and b giving a ratio weight, and b 1 - ratio
     *
     * @param a
     * @param b
     * @param ratio
     * @return
     */
    public static double[] mix(double[] a, double[] b, double ratio) {
        return add(scale(a, ratio), scale(b, 1 - ratio));
    }

    /**
     * Adds two colors, clamps the size to be [0,256)
     *
     * @param c1
     * @param c2
     */
    public static Color add(Color c1, Color c2) {
        return new Color(Math.min(255, c1.getRed() + c2.getRed()), Math.min(255, c1.getGreen() + c2.getGreen()), Math.min(255, c1.getBlue() + c2.getBlue()));
    }

    /**
     * Adds two three dimensional vectors
     */
    public static double[] add(double[] v1, double[] v2) {
        return new double[]{v1[0] + v2[0], v1[1] + v2[1], v1[2] + v2[2]};
    }

    /**
     * Adds two three dimensional vectors
     */
    public static double[] subtract(double[] v1, double[] v2) {
        return new double[]{v1[0] - v2[0], v1[1] - v2[1], v1[2] - v2[2]};
    }

    /**
     * Defines dot product (inner product)
     */
    public static double dot(double[] v1, double[] v2) {
        return v1[0] * v2[0] + v1[1] * v2[1] + v1[2] * v2[2];
    }

    /**
     * Defines scalar multiplication, on three dimensional vectors
     *
     * @param v1 input vector
     * @param a  scalar
     * @return a scaled version
     */
    public static double[] scale(double[] v1, double a) {
        return new double[]{v1[0] * a, v1[1] * a, v1[2] * a};
    }

    /**
     * Defines Euclidean norm on a three dimensional vector
     */
    public static double norm(double[] v1) {
        return Math.sqrt(v1[0] * v1[0] + v1[1] * v1[1] + v1[2] * v1[2]);
    }

    /**
     * @param v1
     * @return
     */
    public static double[] normalize(double[] v1) {
        return scale(v1, 1 / norm(v1));
    }

}
