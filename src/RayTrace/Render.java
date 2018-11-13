package RayTrace;

import java.awt.*;
import java.util.ArrayList;

public class Render{
    public static final double MAGIC_SATURATION_THRESHOLD = .95;
    public static final int MAX_BOUNCES = 10;
    public static final ArrayList<Surface> SURFACES = new ArrayList<>();
    static{
        Sphere next = new Sphere(0,2,5, 1);
        next.setColor(Color.red);
        SURFACES.add(next);
        next = new Sphere(2,0,5, 1);
        next.setColor(Color.green);
        SURFACES.add(next);
        next = new Sphere(0,-2,5, 1);
        next.setColor(Color.blue);
        SURFACES.add(next);
        next = new Sphere(-2,0,5, 1);
        next.setColor(Color.yellow);
        SURFACES.add(next);
        next = new Sphere(0,0, 15, 5);
        next.setColor(new Color(51,153, 255));
        SURFACES.add(next);
    }
    public static double FOV = 1.0;
    public static final double AMBIENT_LIGHT = .2;
    public static double[] LIGHT_SOURCE = new double[]{5,0,0};

    public static Color renderColor(int x, int y) {
        double x1 = (double) x , y1 = (double) y;
        double[] direction = VectorMath.normalize(new double[]{x1/Main.SIZE-.5,y1/Main.SIZE -.5, 1});
        double[] rendered = trace_ray(Camera.source_loc, direction, MAX_BOUNCES);
        return new Color((int) (rendered[0]*MAGIC_SATURATION_THRESHOLD), (int) (rendered[1]*MAGIC_SATURATION_THRESHOLD), (int) (rendered[2] *MAGIC_SATURATION_THRESHOLD));
    }
    public static double[] trace_ray(double[] source, double[] direction, int bounce){
        Surface best_surface = null;
        double best_dist = Integer.MAX_VALUE;
        for(Surface surface : SURFACES){
            Double this_dist = surface.getIntersection(source, direction);
            if(this_dist!=null && this_dist<best_dist){
                best_dist = this_dist;
                best_surface = surface;
            }
        }
        if(best_surface == null){
            return new double[]{0,0,0};
        }else{
            double[] surface = VectorMath.add(source, VectorMath.scale(direction, best_dist));
            return best_surface.getIllumination(surface,direction, bounce);
        }
    }

}
