package RayTrace;

import java.awt.*;

public class Sphere implements Surface {
    private double[] center = new double[3];
    public static final double MIN_DISTANCE = 0.01;
    private final double radius;
    private double[] myColor = new double[]{0, 255.0,0};

    public Sphere(double x, double y, double z, double r){
        center[0] =  x;
        center[1]  = y;
        center[2]  = z;
        radius = r;
    }
    @Override
    public double[] getColor(){
        return myColor;
    }
    public Color makeCanonicalColor(){
        return new Color((int) myColor[0], (int) myColor[1], (int) myColor[2]);
    }
    public void setColor(Color c){
        myColor = new double[]{c.getRed(),c.getGreen(), c.getBlue()};
    }
    @Override
    public Double getIntersection(double[] source, double[] direction) {
        double[] v = VectorMath.subtract(source, center);
        double b = -VectorMath.dot(v,direction);
        double v2 = VectorMath.dot(v,v);
        double r2 = radius * radius;
        double d2 = b*b - v2 + r2;

        if(d2<0){
            return null;//no intersection
        }else{
            double d = (b - Math.sqrt(d2));
            if (d>MIN_DISTANCE){
                return d;
            }

            d = (b + Math.sqrt(d2));
            if (d>MIN_DISTANCE){
                return d;
            }
        }
        return null;
    }
    public double[] getIllumination(double[] surface, double[]direction, int depth){
        double[] to_surface = VectorMath.normalize(VectorMath.subtract(surface,center));
        double[] to_light = VectorMath.normalize(VectorMath.subtract(Render.LIGHT_SOURCE,surface));
        double intensity = Render.AMBIENT_LIGHT + (1-Render.AMBIENT_LIGHT) * Math.max(0,VectorMath.dot(to_light,to_surface));
        double[] direct = VectorMath.scale(myColor,intensity);
        if(depth==1){
            return direct;
        }else{
            double cos = VectorMath.dot(direction, to_surface);
            double[] bounce = VectorMath.subtract(direction, VectorMath.scale(to_surface, 2*cos));
            double[] reflected = Render.trace_ray(surface, bounce, depth -1 );
            return VectorMath.mix(direct, reflected, 0.5 + 0.5 * (Math.pow(intensity, 30)));
        }
    }
}

