package RayTrace;

import java.awt.*;

public class ReflectivePane extends Pane {
    public ReflectivePane(double[] normal, double[] X_AXIS, double[] Y_AXIS, double[] upper_left, double X_LENGTH, double Y_LENGTH) {
        super(normal, X_AXIS, Y_AXIS, upper_left, X_LENGTH, Y_LENGTH);
        this.setREFLECTIVITY(.94);
        this.setColor(Color.black);
    }
}
