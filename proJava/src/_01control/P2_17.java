package _01control;

/**
 * Created by jakecoll on 10/1/16.
 */

import java.util.Scanner;

public class P2_17 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Please enter the first time: ");
        int nTime1 = in.nextInt();

        System.out.print("Please enter the second time: ");
        int nTime2 = in.nextInt();

        //Convert times to minutes
        ////extract minutes
        int nMin_nTime1 = nTime1 % 100;
        int nMin_nTime2 = nTime2 % 100;
        ////extract hours
        int nHours_nTime1 = (nTime1 - nMin_nTime1) / 100;
        int nHours_nTime2 = (nTime2 - nMin_nTime2) / 100;
        ////conversion to minutes
        int nTime1_minutes = (nHours_nTime1 * 60) + nMin_nTime1;
        int nTime2_minutes = (nHours_nTime2 * 60) + nMin_nTime2;

        int nTimeDiff = Math.abs(nTime1_minutes - nTime2_minutes);
        int nMinDiff = nTimeDiff % 60;
        int nHourDiff = (nTimeDiff - nMinDiff) / 60;

        System.out.printf("%d hours %d minutes",nHourDiff, nMinDiff);
    }
}
