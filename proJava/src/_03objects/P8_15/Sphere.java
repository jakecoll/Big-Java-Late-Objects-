package _03objects.P8_15;

/**
 * Created by jakecoll on 10/16/16.
 */
import java.lang.Math;

public class Sphere {

    private double dRadius;

    /**
     * Constructs a sphere object with radius "r"
     * @param r
     */
    public Sphere(double r)
    {
        dRadius = r;
    }

    /**
     * computes and returns the volume of the sphere
     * @return
     */
    public double getVolume()
    {
        return (4.0/3.0) * Math.PI * Math.pow(dRadius,3);
    }

    /**
     * computes and returns the surface area of the sphere object
     * @return
     */
    public double getSurfaceArea()
    {
        return 4.0 * Math.PI * dRadius * dRadius;
    }
}
