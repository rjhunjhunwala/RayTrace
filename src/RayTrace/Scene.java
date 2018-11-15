package RayTrace;

import java.awt.*;
import java.util.ArrayList;

public final class Scene {
    /**
     * Hide constructor
     */
    private Scene(){

    }
    public static void getSpheresInReflectiveSphere(ArrayList<Surface> SURFACES){
        SURFACES.add(new ReflectiveSphere(0,0,0,15));
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
        next = new Sphere(0,0,10, 3);
        next.setColor(Color.white);
        SURFACES.add(next);

    }
public static void getTestA(ArrayList<Surface> SURFACES){
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
    }
    public static void getTestB(ArrayList<Surface> SURFACES){
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
        SURFACES.add(new ReflectiveSphere(3,3,5,1.5));
        SURFACES.add(new ReflectiveSphere(3,-3,5,1.5));
        SURFACES.add(new ReflectiveSphere(-3,-3,5,1.5));
        SURFACES.add(new ReflectiveSphere(-3,3,5,1.5));

        next = new Sphere(2,2,7, 1);
        next.setColor(Color.yellow);
        SURFACES.add(next);
        next = new Sphere(2,-2,7, 1);
        next.setColor(Color.red);
        SURFACES.add(next);
        next = new Sphere(-2,2,7, 1);
        next.setColor(Color.blue);
        SURFACES.add(next);
        next = new Sphere(-2,-2,7, 1);
        next.setColor(Color.green);
        SURFACES.add(next);

        SURFACES.add(new ReflectiveSphere(0,0,20,10));

        next = new Sphere(0,0,-50, 30);
        next.setColor(Color.white);
        SURFACES.add(next);
    }
    public static void setColor(ArrayList<Surface> surfaces, int index, Color c){

        surfaces.get(index).setColor(c);
    }
    public static void getPlaneTest(ArrayList<Surface> SURFACES){
    SURFACES.add(new ReflectivePane(VectorMath.ELEM_K, VectorMath.ELEM_I,VectorMath.ELEM_J, new double[]{-5,-5,10},11,11));
        SURFACES.add(new Pane(VectorMath.ELEM_I, VectorMath.ELEM_J,VectorMath.ELEM_K, new double[]{-5,-5,0},11,11));
        SURFACES.add(new Pane(VectorMath.ELEM_I, VectorMath.ELEM_J,VectorMath.ELEM_K, new double[]{5,-5,0},11,11));
        SURFACES.add(new Pane(VectorMath.ELEM_J, VectorMath.ELEM_I,VectorMath.ELEM_K, new double[]{-5,-5,0},11,11));
        SURFACES.add(new Pane(VectorMath.ELEM_J, VectorMath.ELEM_I,VectorMath.ELEM_K, new double[]{-5,5,0},11,11));
        SURFACES.add(new ReflectivePane(VectorMath.ELEM_K, VectorMath.ELEM_I,VectorMath.ELEM_J, new double[]{-5,-5,0},11,11));
        setColor(SURFACES,1,Color.red);
                setColor(SURFACES,2,Color.red);
        setColor(SURFACES,3,Color.blue);
        setColor(SURFACES,4,Color.blue);
        Sphere next = new Sphere(1,1, 7, .5);
        next.setColor(Color.pink);
        //SURFACES.add(next);
        next = new Sphere(-1,-1, 5.6, .4);
        next.setColor(Color.orange);
        //SURFACES.add(next);
        next = new Sphere(0,-1, 4, .3);
        next.setColor(Color.blue);
        //SURFACES.add(next);
        SURFACES.add(new ReflectiveSphere(0,-1,8, 1.3));
    }
}
