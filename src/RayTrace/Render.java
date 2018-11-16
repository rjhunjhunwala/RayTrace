package RayTrace;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Render{
    public static final double MAGIC_SATURATION_THRESHOLD = .90;
    public static final int MAX_BOUNCES = 6;
    public static final double[] VOID_COLOR = new double[]{0,0,0};
    public static final double[] SKY_COLOR = new double[]{0,150,255};
    public static final ArrayList<Surface> SURFACES = new ArrayList<>();
    public static final int SCENE = 5;
    /**
     * Some small Double value
     */
    public static final double EPSILON = .01;
    public static final double PERFECT_REFLECTION = 1.0;

    static{
        switch(SCENE){
            case 0:
                Scene.getSpheresInReflectiveSphere(SURFACES);
            break;
            case 1:
                Scene.getTestA(SURFACES);
                break;
            case 2:
                Scene.getTestB(SURFACES);
                break;
            case 3:
                Scene.getPlaneTest(SURFACES);
                break;
            case 4:
                Scene.getTextureTest(SURFACES);
                break;
            case 5:
                Scene.getBetterStanfordTree(SURFACES);
                break;
            default:
                System.err.println("No Scene found!");
        }
    }
    public static final double FOV = 1.6;
    public static final double AMBIENT_LIGHT = .2;
    public static double[] LIGHT_SOURCE = new double[]{3,3,3};

    public static Color renderColor(int x, int y) {
        double x1 = (double) x , y1 = (double) y;
        double[] direction = VectorMath.normalize(new double[]{FOV*(x1/Main.SIZE-.5),EPSILON+ FOV*(.5 - y1/Main.SIZE ), 1});
        double[] rendered = trace_ray(Camera.source_loc, direction, MAX_BOUNCES);
try {
    return new Color((int) (rendered[0] * MAGIC_SATURATION_THRESHOLD), (int) (rendered[1] * MAGIC_SATURATION_THRESHOLD), (int) (rendered[2] * MAGIC_SATURATION_THRESHOLD));
}catch(Exception ex){
    System.err.println(Arrays.toString(rendered));
    return Color.white;
}
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
