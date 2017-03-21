package _04interfaces.P9_16;

/**
 * Created by jakecoll on 10/22/16.
 */

import java.util.Scanner;

public class SampleUsage {
    public static void main(String[] args) {

        Country[] arrayCountries = {new Country("Russia",100.0), new Country("USA", 98.0), new Country("UK", 2.5)};
        Measurable largest = maximum(arrayCountries);
        Country largestCountry = (Country) largest;
        System.out.println("The largest country is " + largestCountry.getCountryName());


    }

    /**
     * method for returning object with maximum area
     * @param objects
     * @return
     */
    public static Measurable maximum(Measurable[] objects) {
        Measurable largest = objects[0];
        for (int i = 1; i < objects.length; i++) {
            if (objects[i].getMeasure() > largest.getMeasure()) {
                largest = objects[i];
            }
        }
        return largest;
    }


}
