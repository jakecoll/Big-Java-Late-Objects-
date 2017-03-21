package _02arrays;

/**
 * Created by jakecoll on 10/6/16.
 */

import java.util.Scanner;
import java.util.Arrays;

public class P5_25 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Please enter a zip code: ");
        int zipCode = in.nextInt();
        in.close();

        System.out.println(printBarCode(zipCode));

    }

    public static String printDigit(int d)
    {
        String barCodeDigit = new String();
        switch(d) {
            case 1: barCodeDigit = ":::||"; break;
            case 2: barCodeDigit = "::|:|"; break;
            case 3: barCodeDigit = "::||:"; break;
            case 4: barCodeDigit = ":|::|"; break;
            case 5: barCodeDigit = ":|:|:"; break;
            case 6: barCodeDigit = ":||::"; break;
            case 7: barCodeDigit = "|:::|"; break;
            case 8: barCodeDigit = "|::|:"; break;
            case 9: barCodeDigit = "|:|::"; break;
            case 0: barCodeDigit = "||:::"; break;
            default: barCodeDigit = "....."; break;

        }

        return barCodeDigit;
    }

    public static String printBarCode(int zipCode)
    {
        String barCode = "";
        String[] digitArray = new String[6];
        int nZipSum = 0;
        int index = 4;

        //add bar code digits to array
        while (zipCode > 0) {
            int d = zipCode % 10;
            digitArray[index] = printDigit(d);
            index = index - 1;
            nZipSum = nZipSum + d;
            zipCode = zipCode / 10;

        }

        //add check digit
        digitArray[5] = printDigit(10 - (nZipSum % 10));

        //convert array elements to string
        for (int i=0; i < digitArray.length; i++)
        {
            barCode += digitArray[i];
        }

        return "|" + barCode + "|";

    }


}
