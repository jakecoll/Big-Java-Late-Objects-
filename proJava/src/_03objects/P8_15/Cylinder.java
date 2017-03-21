package _03objects.P8_15;

/**
 * Created by jakecoll on 10/16/16.
 */
import java.lang.Math;

public class Cylinder {

    private double dRadius;
    private double dHeight;

    /**
     * Constructs a cylinder with radius "r" and height "h"
     * @param r
     * @param h
     */
    public Cylinder(double r, double h)
    {
        dRadius = r;
        dHeight = h;
    }

    /**
     * computes and returns volume of cylinder object
     * @return
     */
    public double getVolume()
    {
        return Math.PI * dRadius * dRadius * dHeight;
    }

    /**
     * computes and returns the surface area of the cylinder object
     * @return
     */
    public double getSurfaceArea()
    {
        return (2.0 * Math.PI * dRadius * dHeight) + (2.0 * Math.PI * dRadius * dRadius);
    }
}
