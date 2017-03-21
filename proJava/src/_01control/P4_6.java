package _01control;

/*
Translatethefollowingpseudocodeforfindingtheminimumvaluefromasetof inputs into a Java program.
Set a Boolean variable "first" to true.
While another value has been read successfully
If first is true
Set the minimum to the value. Set first to false.
Else if the value is less than the minimum Set the minimum to the value.
Print the minimum.
 */

import java.util.Scanner;

/**
 * Created by jakecoll on 10/2/16.
 */
public class P4_6 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Please enter integers: ");

        boolean first = true;
        int min = Integer.MAX_VALUE;
        while (in.hasNextInt()) {
            int newInt = in.nextInt();

            if (first) {
                min = newInt;
                first = false;
            }

            else if (newInt < min) {
                min = newInt;
            }

        }

        System.out.printf("Minimum Value: %d", min);
        in.close();
    }

}
