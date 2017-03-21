package _04interfaces.P9_8;

/**
 * Created by jakecoll on 10/20/16.
 */

public class Student extends Person {

        private String strMajor;

    /**
     * constructs student object as subclass of Person object
     * @param name
     * @param year
     * @param major
     */
        public Student (String name, int year, String major) {
            super(name, year);
            strMajor = major;
        }

    /**
     * override toString() method to return object parameters in one string
     * @return
     */
    @Override
        public String toString() {
            return super.toString() + "; Major: " + strMajor;
        }

}

