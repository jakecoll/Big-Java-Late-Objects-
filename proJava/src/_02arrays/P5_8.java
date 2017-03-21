package _02arrays;

/**
 * Created by jakecoll on 10/3/16.
 */

import javax.xml.stream.events.Characters;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class P5_8
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        System.out.println("Please enter a word: ");
        String word = in.nextLine();
        in.close();

        if (word.length() > 3)
        {
            System.out.print(scramble(word));
        } else {System.out.print(word);};


    }

    public static String scramble(String word)
    {

        ArrayList<Character> wordChars = new ArrayList<Character>(word.length());

        for (char c : word.toCharArray())
        {
            wordChars.add(c);
        }

        int randomInt = randInt(1,wordChars.size());

        char itemToMove = wordChars.get(randomInt);
        wordChars.remove(randomInt);
        wordChars.add(randomInt-1,itemToMove);

        String newWord = charListToString(wordChars);

        return newWord;

    }

    public static int randInt(int min, int max)
    {
        Random rand = new Random();

        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;

    }

    public static String charListToString(ArrayList<Character> list)
    {
        StringBuilder builder = new StringBuilder(list.size());
        for (Character chr: list)
        {
            builder.append(chr);
        }

        return builder.toString();
    }

}
