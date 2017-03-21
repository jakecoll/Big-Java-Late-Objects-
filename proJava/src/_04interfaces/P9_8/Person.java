package _04interfaces.P9_8;

/**
 * Created by jakecoll on 10/20/16.
 *
 * Implement a superclass Person. Make two classes, Student and Instructor, that inherit from Person.
 * A person has a name and a year of birth. A student has a major, and an instructor has a salary.
 * Write the class declarations, the constructors, and the methods toString for all classes.
 * Supply a test program that tests these classes and methods.
 */


public class Person {


    private String strName;
    private int nYear;

    /**
     * Constructs a person object with parameter name and year of birth
     * @param name
     * @param year
     */

    public Person(String name, int year) {
        strName = name;
        nYear = year;
    }

    /**
     * overrides toString() method to return name and year of birth of object
     * @return
     */
    @Override
    public String toString() {
        return "Name: " + strName + "; Year of Birth: " + nYear;
    }


}