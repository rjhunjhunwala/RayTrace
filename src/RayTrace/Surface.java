package RayTrace;



public interface Surface {
    /**
     * Return the scalar multiple of direction null, if the given ray does not actually intersect
     * @return
     */
    public Double getIntersection(double[] source,double[] direction);
    default double[] getColor(){
        return new double[]{255.0,255.0,255.0};
    }
    default double getREFLECTIVITY(){return 0.5;}
    default double getNOISE(){return 0;}
    public double[] getNormalVector(double[] surface, double[] direction);
    default double[] getIllumination(double[] surface, double[]direction, int depth){
        double[] normal_vector = VectorMath.normalize(getNormalVector(surface, direction));
        double[] to_light = VectorMath.normalize(VectorMath.subtract(Render.LIGHT_SOURCE,surface));
        double intensity = Render.AMBIENT_LIGHT + (1-Render.AMBIENT_LIGHT) * Math.max(0,VectorMath.dot(to_light,normal_vector));
        double[] direct = VectorMath.scale(getColor(),intensity);
        if(depth==1){
            return direct;
        }else{
            double cos = VectorMath.dot(direction, normal_vector);
            double[] bounce = VectorMath.normalize(VectorMath.add(VectorMath.subtract(direction,
                    VectorMath.scale(normal_vector, 2*cos)),VectorMath.getNoiseVector(getNOISE())));
            double[] reflected = Render.trace_ray(surface, bounce, depth -1 );

                return VectorMath.mix(direct, reflected, (1 - getREFLECTIVITY()) + getREFLECTIVITY() * Math.pow(intensity, 30));

            }

    }
}
