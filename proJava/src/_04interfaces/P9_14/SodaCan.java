package _04interfaces.P9_14;

/**
 * Created by jakecoll on 10/22/16.
 */

import java.lang.Math;

public class SodaCan implements Measurable {

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
     *
     * @return
     */
    public double getSurfaceArea()
    {
        //Surface area of cylinder is 2πrh+2πr2
        return (2 * Math.PI * this.dRadius * this.dHeight) + (2 * Math.PI * this.dRadius * this.dHeight);
    }

    /**
     * gets the volume of a soda can
     * @return
     */
    public double getVolume()
    {
        //volume of cylinder is πr2h
        return Math.PI * this.dRadius * this.dRadius * this.dHeight;
    }

    /**
     * method for returning surface area to interface
     * @return
     */
    public double getMeasure()
    {
        return this.getSurfaceArea();
    }
}
