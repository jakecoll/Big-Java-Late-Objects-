package _06design.R12_14;

/**
 * Created by jakecoll on 11/6/16.
 */

import java.util.ArrayList;

public class CountryEvaluator {

    private ArrayList<Country> arrayCountries;

    /**
     * Contructs CountryEvaluator Object
     */
    public CountryEvaluator()
    {
        arrayCountries = new ArrayList<Country>();
    }

    /**
     * Add country to list for evaluator
     * @param country
     */
    public void addCountry(Country country) {
        arrayCountries.add(country);
    }

    /**
     * returns most populous country
     * @return
     */
    public Country getMostPopulousCountry()
    {

        int largestPopulation = 0;
        Country mostPopulousCountry = new Country();


        for (Country country: arrayCountries)
        {
            if (country.getPopulation() > largestPopulation)
                largestPopulation = country.getPopulation();
                mostPopulousCountry = country;
        }

        return mostPopulousCountry;
    }

    /**
     * Returns largest country by land area
     * @return
     */
    public Country getLargestCountry()
    {

        double largestArea = 0.0;
        Country mostPopulousCountry = new Country();


        for (Country country: arrayCountries)
        {
            if (country.getArea() > largestArea)
                largestArea = country.getPopulation();
            mostPopulousCountry = country;
        }

        return mostPopulousCountry;
    }
}
