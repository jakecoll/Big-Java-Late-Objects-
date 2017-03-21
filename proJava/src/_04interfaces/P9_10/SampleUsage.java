package _04interfaces.P9_10;

/**
 * Created by jakecoll on 10/21/16.
 */
public class SampleUsage {

    /**
     * sample implementation and output of BetterRectangle object
     * @param args
     */

    public static void main(String[] args) {

        BetterRectangle betterRectangle = new BetterRectangle(0,0,3,4);
        System.out.println("Perimeter: " + betterRectangle.getPerimeter());
        System.out.println("Area: " + betterRectangle.getArea());
    }
}
