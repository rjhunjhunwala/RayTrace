package RayTrace;

import java.awt.*;

public class Sphere implements Surface {
    private double[] center = new double[3];
    public static final double MIN_DISTANCE = 0.01;
    private final double radius;
    private double[] myColor = new double[]{0, 255.0,0};
    private double REFLECTIVITY = 0.5;

    public double getREFLECTIVITY() {
        return REFLECTIVITY;
    }
    public void setREFLECTIVITY(double REFLECTIVITY){
        this.REFLECTIVITY = REFLECTIVITY;
    }

    public Sphere(double x, double y, double z, double r){
        center[0] =  x;
        center[1]  = y;
        center[2]  = z;
        radius = r;
    }
    public Sphere(double x, double y, double z, double r, Color c){
        center[0] =  x;
        center[1]  = y;
        center[2]  = z;
        radius = r;
        myColor =  new double[]{c.getRed(),c.getGreen(), c.getBlue()};
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

 public double[] getNormalVector(double[] surface, double[] direction){
        double[] out = VectorMath.subtract(surface,center);
        if(VectorMath.dot(out, direction)<0){
            return out;
        }else{
            return VectorMath.scale(out,-1);
        }
 }
}

