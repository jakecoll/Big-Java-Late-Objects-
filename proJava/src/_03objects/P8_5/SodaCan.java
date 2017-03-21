package _03objects.P8_5;

/**
 * Created by jakecoll on 10/13/16.
 */

import java.lang.Math;

public class SodaCan {

    private double dHeight;
    private double dRadius;

    /**
     * Constructs a SodaCan object with height and radius of 0
     */
    public SodaCan()
    {
        dHeight = 0.0;
        dRadius = 0.0;
    }

    /**
     * Constructs a SodaCan object with initial height and radius as parameters
     */
    public SodaCan(double height, double radius)
    {
        dHeight = height;
        dRadius = radius;
    }

    /**
     * gets the surface area of a soda can
     * @param height
     * @param radius
     * @return
     */
    public double getSurfaceArea(double height, double radius)
    {
        //Surface area of cylinder is 2πrh+2πr2
        return (2 * Math.PI * radius * height) + (2 * Math.PI * radius * radius);
    }

    /**
     * gets the volume of a soda can
     * @param height
     * @param radius
     * @return
     */
    public double getVolume(double height, double radius)
    {
        //volume of cylinder is πr2h
        return Math.PI * radius * radius * height;
    }
}
