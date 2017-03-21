package _04interfaces.P9_13;

/**
 * Created by jakecoll on 10/21/16.
 */
import java.awt.Point;



public class LabeledPoint extends Point {

    private String strLabel;

    /**
     * Constructs a point object with x-y coordinates and a label name.
     * Implements LabeledPoint as subclass of superclass Point
     * @param x
     * @param y
     * @param label
     */
    public LabeledPoint (int x, int y, String label) {
        super(x,y);
        strLabel = label;
    }

    /**
     * overrides toString() method to return label and x-y coordinates of LabeledPoint object
     * @return
     */
    @Override
    public String toString() {
        return "Label: " + strLabel + "; Coordinates: " + this.x + "," + this.y;
    }
}
