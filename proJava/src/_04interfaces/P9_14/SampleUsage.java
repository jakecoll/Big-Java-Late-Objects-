package _04interfaces.P9_14;

/**
 * Created by jakecoll on 10/22/16.
 */
import java.util.Scanner;
import java.util.ArrayList;

public class SampleUsage {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Please enter the number of Soda Cans you want average surface area for: ");
        int nTotalSodaCans = in.nextInt();

        double dTotalSurfaceArea = 0.0;

        for (int i=0; i < nTotalSodaCans; i++)
        {
            System.out.print("Enter height for Soda Can " + (i+1) + ": ");
            double height = in.nextDouble();

            System.out.print("Enter radius for Soda Can " + (i+1) + ": ");
            double radius =  in.nextDouble();

            SodaCan newSodaCan = new SodaCan(height,radius);
            dTotalSurfaceArea += newSodaCan.getMeasure();
        }

        System.out.println("The average Soda Can surface area is: " + (dTotalSurfaceArea/nTotalSodaCans));
        in.close();

    }
}
