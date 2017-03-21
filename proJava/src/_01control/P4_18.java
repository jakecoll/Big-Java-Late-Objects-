package _01control;

/**
 * Created by jakecoll on 10/2/16.
 */

import java.util.Scanner;

public class P4_18 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.print("Please enter an integer: ");
        int num = in.nextInt();
        in.close();


        for (int i = 1; i < num; i++) {

            boolean isPrime = true;

            for (int j = 2; j < i; j++)
            {

                if (i % j == 0)
                {
                    isPrime = false;
                    break;
                }

            }

            if (isPrime){

                System.out.print(i + " ");

            }
        }
    }
}
