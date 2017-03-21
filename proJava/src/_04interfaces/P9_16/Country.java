package _04interfaces.P9_16;

/**
 * Created by jakecoll on 10/22/16.
 */
public class Country implements Measurable {

    private String strName;
    private double dArea;

    /**
     * Constructs Country object with name of the country and the area
     * @param name
     * @param area
     */
    public Country (String name, double area)
    {
        strName = name;
        dArea = area;
    }

    /**
     * method for returning the name of the the Country object
     * @return
     */
    public String getCountryName() {
        return strName;
    }

    /**
     * method for returning area of country through interface
     * @return
     */
    public double getMeasure()
    {
        return dArea;
    }
}
