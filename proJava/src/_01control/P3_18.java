package _01control;

/**
 * Created by jakecoll on 10/2/16.
 */

import java.util.Scanner;

public class P3_18 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.print("Please enter month: ");
        int nMonth = in.nextInt();

        System.out.print("Please enter day of month: ");
        int nDay = in.nextInt();

        String season = null;

        if (nMonth >= 1 && nMonth <= 3) {
            season = "Winter";
        }
        else if (nMonth >= 4 && nMonth <= 6) {
            season = "Spring";
        }
        else if (nMonth >= 7 && nMonth <= 9) {
            season = "Summer";
        }
        else if (nMonth >= 10 && nMonth <= 12) {
            season = "Fall";
        }


        if (nMonth % 3 == 0 && nDay >= 21) {
            if (season.equals("Winter")); { season = "Spring"; }
            if (season.equals("Spring")); { season = "Summer"; }
            if (season.equals("Summer")); { season = "Fall"; }
            if (season.equals("Fall")); { season = "Winter"; }
        }

        System.out.print(season);

    }
}
