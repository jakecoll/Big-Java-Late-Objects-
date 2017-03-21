package _02arrays;

/**
 * Created by jakecoll on 10/7/16.
 */

import java.util.Random;
import java.util.Arrays;

public class P6_12 {
    public static void main(String[] args) {

        int[] nDieTosses = new int[20];

        for (int i=0; i < nDieTosses.length; i++)
        {
           nDieTosses[i] = randInt(1,6);
        }

        System.out.println("Initial Tosses: " + Arrays.toString(nDieTosses));

        boolean inRun = false;
        String runsString = "";

        for (int i=0; i < nDieTosses.length; i++)
        {

            if (inRun)
            {
                if ( (i < nDieTosses.length-1) && (nDieTosses[i] != nDieTosses[i+1]))
                {
                    //runsString = runsString.substring(0,runsString.length()-1);
                    runsString += String.valueOf(nDieTosses[i]) + ") ";
                    inRun = false;

                } else { runsString += String.valueOf(nDieTosses[i]) + " "; }
            }

            else if (!inRun)
            {
                if ( (i < nDieTosses.length-1) && (nDieTosses[i] == nDieTosses[i+1]))
                {
                    runsString += "(" + String.valueOf(nDieTosses[i]) + " ";
                    inRun = true;
                } else { runsString += String.valueOf(nDieTosses[i]) + " "; }

            }

        }

        if (inRun) {
            runsString = runsString.substring(0,runsString.length()-1);
            runsString += ")";
        }

        System.out.println(runsString);


    }

    public static int randInt(int min, int max)
    {
        Random rand = new Random();

        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;

    }
}
