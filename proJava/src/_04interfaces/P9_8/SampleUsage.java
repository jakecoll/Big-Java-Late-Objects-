package _04interfaces.P9_8;

/**
 * Created by jakecoll on 10/21/16.
 */
public class SampleUsage {

    /**
     * example output for objects from super and subclasses
     * @param args
     */
    public static void main(String[] args) {
        Person johnDoe = new Person("John Doe", 1980);
        Student janeDoe = new Student("Jane Doe", 1980, "English");
        Instructor missDoe = new Instructor("Miss Jane Doe", 1970, 100000.00);
        System.out.println(johnDoe);
        System.out.println(janeDoe);
        System.out.println(missDoe);
    }

}
