package _06design.R12_14;

/**
 * Created by jakecoll on 11/6/16.
 */
public class Country {
    private String strCountryName;
    private int nPopulation;
    private double dArea;


    public Country()
    {

    }

    /**
     * Constructs a Country object
     * @param name
     * @param population
     * @param area
     */
    public Country(String name, int population, double area)
    {
        strCountryName = name;
        nPopulation = population;
        dArea = area;
    }

    /**
     * Returns the name of the Country
     * @return
     */
    public String getName()
    {
        return strCountryName;
    }

    /**
     * Returns the population of the Country
     * @return
     */
    public int getPopulation()
    {
        return nPopulation;
    }

    /**
     * Returns the area of the country
     * @return
     */
    public double getArea()
    {
        return dArea;
    }

}
