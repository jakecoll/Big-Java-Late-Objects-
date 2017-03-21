package _03objects.P8_15;

/**
 * Created by jakecoll on 10/16/16.
 */

import java.util.Scanner;

public class SampleUsage {
    public static void main(String[] args) {

        /**
         * This approach is more object oriented since it creates separate objects for each shape!
         */

        Scanner in = new Scanner(System.in);

        System.out.print("Enter radius: ");
        double dRadius = in.nextDouble();
        System.out.print("Enter height: ");
        double dHeight = in.nextDouble();

        Sphere sphere = new Sphere(dRadius);
        Cone cone = new Cone(dRadius, dHeight);
        Cylinder cylinder = new Cylinder(dRadius, dHeight);

        System.out.println("Sphere Volume: " + sphere.getVolume());
        System.out.println("Sphere Surface Area: " + sphere.getSurfaceArea());
        System.out.println("Cylinder Volume: " + cylinder.getVolume());
        System.out.println("Cylinder Surface Area: " + cylinder.getSurfaceArea());
        System.out.println("Cone Volume: " + cone.getVolume());
        System.out.println("Cone Surface Area: " + cone.getSurfaceArea());
    }
}
