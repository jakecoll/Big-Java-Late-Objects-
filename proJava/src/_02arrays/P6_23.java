package _02arrays;

/**
 * Created by jakecoll on 10/7/16.
 */

import java.util.Scanner;
import java.util.Arrays;

public class P6_23 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Please enter the number of inputs: ");
        int nTotal = in.nextInt();

        String[][] inputsDict = new String[nTotal][2];

        for (int i = 0; i < inputsDict.length; i++)
        {
            System.out.print("Enter name for input " + (i+1) + ": ");
            inputsDict[i][0] = in.next();

            System.out.print("Enter value (integer) for input " + (i+1) + ": ");
            inputsDict[i][1] =  in.next();
        }

        int nMaxValue = findMaxValue(inputsDict);
        int nMinValue = findMinValue(inputsDict);
        int nMaxNameLength = findMaxNameLength(inputsDict);

        inputsDict = replaceWithAsterisks(inputsDict, nMinValue, nMaxValue);
        inputsDict = formatNames(inputsDict, nMaxNameLength);

        for (int i=0; i < inputsDict.length; i++)
        {
            for (int j=0; j < 2; j++)
            {
                System.out.print(inputsDict[i][j]);
            }
            System.out.println(" ");
        }
        //System.out.println(Arrays.deepToString(inputsDict));

    }


    public static int findMaxValue(String[][] array2D)
    {
        int nMaxValue = Integer.MIN_VALUE;

        for (int i=0; i < array2D.length; i++)
        {
            int nValue = Integer.parseInt(array2D[i][1]);

            if (nValue > nMaxValue)
            {
                nMaxValue = nValue;
            }
        }

        return nMaxValue;
    }

    public static int findMinValue(String[][] array2D)
    {
        int nMinValue = Integer.MAX_VALUE;

        for (int i=0; i < array2D.length; i++)
        {
            int nValue = Integer.parseInt(array2D[i][1]);

            if (nValue < nMinValue)
            {
                nMinValue = nValue;
            }
        }

        return nMinValue;
    }

    public static int findMaxNameLength(String[][] array2D)
    {
        int nMaxNameLength = Integer.MIN_VALUE;

        for (int i=0; i < array2D.length; i++)
        {
            int nNameLength = array2D[i][0].length();
            if (nNameLength > nMaxNameLength)
            {
                nMaxNameLength = nNameLength;
            }
        }

        return nMaxNameLength;
    }

    public static String[][] replaceWithAsterisks(String[][] array2D, int minVal ,int maxVal)
    {

        for (int i=0; i < array2D.length; i++)
        {
            String nAsterisks = "";

            int nValue = Integer.parseInt(array2D[i][1]);
            int indexedValue = 40 * (nValue)/(maxVal);


            for (int j = 1; j <= indexedValue; j++)
            {
                nAsterisks += "*";
            }

            array2D[i][1] = nAsterisks;

        }

        return array2D;

    }

    public static String[][] formatNames(String[][] array2D, int maxNameLength)
    {

        for (int i = 0; i < array2D.length; i++)
        {
            String formattedName = "";

            int nameLength = array2D[i][0].length();

            for (int j = 1; j <= (maxNameLength - nameLength); j++)
            {
                formattedName += " ";
            }

            formattedName += array2D[i][0] + " ";

            array2D[i][0] = formattedName;
        }

        return array2D;
    }

}
