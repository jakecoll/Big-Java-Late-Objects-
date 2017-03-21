package _04interfaces.P9_8;

/**
 * Created by jakecoll on 10/20/16.
 */


public class Instructor extends Person {

    private double dSalary;

    /**
     * Constructs an instructor subclass objec
     * @param name
     * @param year
     * @param salary
     */

    public Instructor (String name, int year, double salary) {
        super(name, year);
        dSalary = salary;
    }

    /**
     * overrides toString method to return string
     * @return
     */
    @Override
    public String toString() {
        return super.toString() + "; Salary: " + dSalary;
    }

}
