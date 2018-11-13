package RayTrace;

import java.awt.*;
import java.util.ArrayList;

public class Render{
    public static final double MAGIC_SATURATION_THRESHOLD = .95;
    public static final int MAX_BOUNCES = 15;
    public static final double[] VOID_COLOR = new double[]{0,0,0};
    public static final double[] SKY_COLOR = new double[]{0,150,255};
    public static final ArrayList<Surface> SURFACES = new ArrayList<>();
    static{
        Scene.getTestA(SURFACES);
        //Scene.getSpheresInReflectiveSphere(SURFACES);
    }
    public static double FOV = 1.0;
    public static final double AMBIENT_LIGHT = .6;
    public static double[] LIGHT_SOURCE = new double[]{0,0,0};

    public static Color renderColor(int x, int y) {
        double x1 = (double) x , y1 = (double) y;
        double[] direction = VectorMath.normalize(new double[]{x1/Main.SIZE-.5,.5 - y1/Main.SIZE , 1});
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
            return VOID_COLOR;
        }else{
            double[] surface = VectorMath.add(source, VectorMath.scale(direction, best_dist));
            return best_surface.getIllumination(surface,direction, bounce);
        }
    }

}
