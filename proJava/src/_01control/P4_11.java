package _01control;


/**
 * Created by jakecoll on 10/2/16.
 */

import java.util.Scanner;
public class P4_11 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Please enter a word: ");
        String word = in.nextLine();

        int nSyllables = 0;

        for (int i = 0; i < word.length(); i++) {
            char thisChar = Character.toLowerCase(word.charAt(i));
            char lastChar = 't';
            boolean thisCharSyllable = false;
            boolean lastCharSyllable = false;

            if (i > 0) {
                lastChar = Character.toLowerCase(word.charAt(i - 1));
            }

            if (((thisChar == 'a') || (thisChar == 'o') || (thisChar == 'u') || (thisChar == 'i') || thisChar == 'y' || ((thisChar == 'e') && (i != (word.length() - 1)))))
            {
                thisCharSyllable = true;
            }

            if (((lastChar == 'a') || (lastChar == 'o') || (lastChar == 'u') || (lastChar == 'i') || lastChar == 'y' || lastChar == 'e' ))
            {
                lastCharSyllable = true;
            }

            if (thisCharSyllable && !lastCharSyllable )
            {
                nSyllables++;
            }


        }

        if (nSyllables == 0) {
            nSyllables = 1;
        }


        System.out.printf("%d",nSyllables);

    }
    }


