package _03objects.P8_15;

/**
 * Created by jakecoll on 10/16/16.
 */
import java.lang.Math;

public class Cone {

    private double dRadius;
    private double dHeight;

    /**
     * Constructs a Cone objest with a radius "r" and height "h"
     * @param r
     * @param h
     */
    public Cone(double r, double h)
    {
        dRadius = r;
        dHeight = h;
    }

    /**
     * computes and returns the volume of the cone object
     * @return
     */
    public double getVolume()
    {
        return Math.PI * dRadius * dRadius * (dHeight/3.0);
    }

    /**
     * computes and returns the surface area of the cone object
     * @return
     */
    public double getSurfaceArea()
    {
        return Math.PI * dRadius * (dRadius + Math.sqrt((dHeight * dHeight) + (dRadius * dRadius)));
    }
}
