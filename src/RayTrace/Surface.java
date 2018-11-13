package RayTrace;

public interface Surface {
    /**
     * Return the scalar multiple of direction null, if the given ray does not actually intersect
     * @return
     */
    public Double getIntersection(double[] source,double[] direction);
    public double[] getColor();
    public double[] getIllumination(double[] surface, double[] direction, int depth);


}
