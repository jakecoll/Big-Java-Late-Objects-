package _03objects.P8_14;

/**
 * Created by jakecoll on 10/15/16.
 */
import java.lang.Math;
import java.util.Scanner;

public class Geometry {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double dRadius, dHeight;

        System.out.print("Enter radius: ");
        dRadius = in.nextDouble();
        System.out.print("Enter height: ");
        dHeight = in.nextDouble();

        System.out.println("Sphere Volume: " + sphereVolume(dRadius));
        System.out.println("Sphere Surface Area: " + sphereSurface(dRadius));
        System.out.println("Cylinder Volume: " + cylinderVolume(dRadius, dHeight));
        System.out.println("Cylinder Surface Area: " + cylinderSurface(dRadius,dHeight));
        System.out.println("Cone Volume: " + coneVolume(dRadius,dHeight));
        System.out.println("Cone Surface Area: " + coneSurface(dRadius,dHeight));
    }

    /**
     * static method that computes and returns volume of a sphere
     * @param r
     * @return
     */
    public static double sphereVolume(double r)
    {
        return (4.0/3.0) * Math.PI * Math.pow(r,3);
    }

    /**
     * static method that computes and returns surface area of a sphere
     * @param r
     * @return
     */
    public static double sphereSurface(double r)
    {
        return 4.0 * Math.PI * r * r;
    }

    /**
     * static method that computes and returns volume of a cylinder
     * @param r
     * @param h
     * @return
     */
    public static double cylinderVolume(double r, double h)
    {
        return Math.PI * r * r * h;
    }

    /**
     * static method that computes and returns the surface area of a cylinder
     * @param r
     * @param h
     * @return
     */
    public static double cylinderSurface(double r, double h)
    {
        return (2.0 * Math.PI * r * h) + (2.0 * Math.PI * r * r);
    }

    /**
     * static method that computes and returns the volume of a cone
     * @param r
     * @param h
     * @return
     */
    public static double coneVolume(double r, double h)
    {
        return Math.PI * r * r * (h/3.0);
    }

    /**
     * static method that computes and returns the surface area of a cone
     * @param r
     * @param h
     * @return
     */
    public static double coneSurface(double r, double h)
    {
        return Math.PI * r * (r + Math.sqrt((h * h) + (r * r)));
    }
}
