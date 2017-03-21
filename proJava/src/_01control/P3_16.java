package _01control;

import java.util.Scanner;

/**
 * Created by jakecoll on 10/2/16.
 */
public class P3_16 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.print("Enter three strings: ");
        String words = in.nextLine();
        String[] array = words.split(" ", -1);
        String str1 = array[0];
        String str2 = array[1];
        String str3 = array[2];

        String firstString = null;
        String middleString = null;
        String lastString = null;

        //str1 position

        if (str1.compareTo(str2) < 0 && str1.compareTo(str3) < 0)
        {
            firstString = str1;
        }
        else if (str1.compareTo(str2) > 0 && str1.compareTo(str3) > 0)
        {
            lastString = str1;
        }
        else {
            middleString = str1;
        }

        //str2 position

        if (str2.compareTo(str1) < 0 && str2.compareTo(str3) < 0)
        {
            firstString = str2;
        }
        else if (str2.compareTo(str1) > 0 && str2.compareTo(str3) > 0)
        {
            lastString = str2;
        }
        else {
            middleString = str2;
        }

        //str3 position

        if (str3.compareTo(str1) < 0 && str1.compareTo(str2) < 0)
        {
            firstString = str3;
        }
        else if (str3.compareTo(str1) > 0 && str1.compareTo(str2) > 0)
        {
            lastString = str3;
        }
        else {
            middleString = str3;
        }

        System.out.println(firstString);
        System.out.println(middleString);
        System.out.println(lastString);


    }
}
