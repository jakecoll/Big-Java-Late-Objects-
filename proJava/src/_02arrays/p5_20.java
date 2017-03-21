package _02arrays;

/**
 * Created by jakecoll on 10/6/16.
 */

import java.util.Scanner;

public class p5_20 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.print("Please enter a year: ");
        int year = in.nextInt();
        in.close();

        System.out.println(isLeapYear(year));

    }

    public static boolean isLeapYear(int year)
    {
        boolean isLeapYear = false;
        if (year % 4 == 0)
        {
            if (year % 100 == 0 && year % 400 != 0) {
                isLeapYear = false;
            } else { isLeapYear = true;}

        } else { isLeapYear = false;}

        return isLeapYear;
    }
}
