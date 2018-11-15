package RayTrace;

import java.awt.*;

public class ReflectivePane extends Pane {
    public ReflectivePane(double[] normal, double[] X_AXIS, double[] Y_AXIS, double[] upper_left, double X_LENGTH, double Y_LENGTH) {
        super(normal, X_AXIS, Y_AXIS, upper_left, X_LENGTH, Y_LENGTH);
        super.setColor(new Color((int)(Render.AMBIENT_LIGHT*256),(int)(Render.AMBIENT_LIGHT*256),(int)(Render.AMBIENT_LIGHT*256)));
        this.setColor(Color.black);
        this.setREFLECTIVITY(Render.PERFECT_REFLECTION);
    }



}
