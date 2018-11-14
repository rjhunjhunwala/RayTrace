package RayTrace;

import java.awt.*;

public class ReflectiveSphere extends Sphere{
    public ReflectiveSphere(double x, double y, double z, double r){
        super(x,y,z,r);
        super.setColor(new Color((int)(Render.AMBIENT_LIGHT*256),(int)(Render.AMBIENT_LIGHT*256),(int)(Render.AMBIENT_LIGHT*256)));
        //super.setColor(Color.white);
        setREFLECTIVITY(.94);
    }

}
