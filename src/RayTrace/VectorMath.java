package RayTrace;

import java.awt.*;

public class VectorMath {
    public static final double[] ELEM_I = new double[]{1,0,0};
    public static final double[] ELEM_J = new double[]{0,1,0};
    public static final double[] ELEM_K = new double[]{0,0,1};
    /**
     * Returns a noise vector, to provide "diffused" reflections;
     */
    public static double[] getNoiseVector(double NOISE){
        return new double[]{Math.random()*NOISE -NOISE/2, Math.random()*NOISE-NOISE/2,Math.random()*NOISE-NOISE/2};
    }
    /**
     * Matrix Product (3x3) by vector...
     */
    public static double[] matrixProduct(double[][] A, double[] b){
        return new double[]{
                dot(new double[]{A[0][0],A[1][0],A[2][0]},b),
                dot(new double[]{A[0][1],A[1][1],A[2][1]},b),
                dot(new double[]{A[0][2],A[1][2],A[2][2]},b)
        };
    }
    /**
     * Invert a 3x3 matrix
     */
    public static double[][] invert3(double[][] A){
        double det = det3(A);
        A = transpose(A);
        A = checkerboardSigns(A);
        A = minors(A);
        A = new double[][]{scale(A[0],1/det), scale(A[1], 1/det),scale(A[2], 1/det)};
        return A;

    }
    public static double[][] transpose(double[][] in){
        double[][] out = new double[in[0].length][in.length];
        for(int i = 0;i<in.length;i++){
            for(int j = 0;j<in[0].length;j++){
                out[j][i] = in[i][j];
            }
        }
        return out;
    }
    public static double det3(double[][] A){
        return A[0][0] * (A[1][1] * A[2][2]- A[2][1]*A[1][2]) - A[1][0] * (A[0][1] * A[2][2]- A[2][1]*A[0][2])
                +  A[2][0] * (A[0][1] * A[1][2]- A[1][1]*A[0][2]);
    }

    /**
     * det(|a c|
     *     |b d|
     * @param vectorized <a,b,c,d>
     * @return
     */
    private static double det2(double[] vectorized){
        return vectorized[0]*vectorized[3]-vectorized[1]*vectorized[2];
    }
    public static double[][] minors(double[][] A){
        double[][] temp = new double[3][3];
        for(int i = 0;i<3;i++){
            for(int j = 0;j<3;j++){
                double[] vectorized = new double[4];
                int index = 0;
                for(int i1 = 0;i1<3;i1++){
                    for(int j1 = 0; j1<3;j1++){
                        if(i1!=i && j1!=j){
                            vectorized[index] = A[i1][j1];
                            index +=1;
                        }
                    }
                }
                temp[i][j] = det2(vectorized);
            }
        }
        return temp;
    }

    /**
     * in place checkerboards signs
     * @param A
     * @return
     */
    public static double[][] checkerboardSigns(double[][] A){
        for(int i = 0;i<A.length;i++){
            for(int j = 0;j<A.length;j++){
                A[i][j] *= 1 - (((i+j)&1)<<1); //branchless hack!
            }
        }
        return A;
    }
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
