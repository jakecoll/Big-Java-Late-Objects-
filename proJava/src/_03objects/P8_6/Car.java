package _03objects.P8_6;

/**
 * Created by jakecoll on 10/14/16.
 */
public class Car {

    //initial variables
    private double dGasLevel;
    private double dMilesPerGallon;

    /**
     * Constructs a car object with 0 gas and fuel efficiency
     */

    public Car()
    {
        dGasLevel = 0;
        dMilesPerGallon = 0;
    }

    /**
     * Constructs a car with 0 gas and initial fuel efficiency
     * @param milesPerGallon
     */

    public Car(double milesPerGallon)
    {
        dGasLevel = 0;
        dMilesPerGallon = milesPerGallon;
    }

    /**
     * adds gas to the gas level
     * @param addToGasLevel
     */
    public void addGas(double addToGasLevel)
    {
        dGasLevel = dGasLevel + addToGasLevel;
    }

    /**
     * method changes gas level based on miles driven
     * @param dMilesDriven
     */
    public void drive(double dMilesDriven)
    {
        double dGasUsed = dMilesDriven / dMilesPerGallon;
        dGasLevel = dGasLevel - dGasUsed;
    }

    /**
     * accessor method that returns gas level
     * @return
     */
    public double getGasLevel()
    {
        return dGasLevel;
    }

}
