package _04interfaces.P9_10;

/**
 * Created by jakecoll on 10/21/16.
 */

import java.awt.Rectangle;

public class BetterRectangle extends Rectangle {


    /**
     * Constructs a rectangle object as subclass of default Java Rectangle with parameters for locations
     * @param xCoord
     * @param yCoord
     * @param width
     * @param height
     */
    public BetterRectangle(int xCoord, int yCoord, int width, int height)
    {
        super(xCoord,yCoord,width,height);
        super.setSize(width,height);
        super.setLocation(xCoord,yCoord);

    }

    /**
     * method for computing and returning BetterRectangle object's perimeter as double
     * @return
     */
    public double getPerimeter()
    {
        return (super.getHeight() + super.getWidth()) * 2;
    }

    /**
     * method for computing and returning BetterRectangle object's area as double
     * @return
     */
    public double getArea()
    {
        return super.getHeight() * super.getWidth();
    }


}
