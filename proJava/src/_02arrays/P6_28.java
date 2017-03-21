package _02arrays;

/**
 * Created by jakecoll on 10/9/16.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class P6_28 {
    public static void main(String[] args) {

        ArrayList<Integer> firstList = new ArrayList<Integer>();
        ArrayList<Integer> secondList = new ArrayList<Integer>();

        Scanner in1 = new Scanner(System.in);
        System.out.print("Please enter first list of integers and one non-integer to terminate: ");

        while (in1.hasNextInt())
        {
            int input = in1.nextInt();
            firstList.add(input);
        }

        Scanner in2 = new Scanner(System.in);
        System.out.print("Please enter second list of integers and one non-integer to terminate: ");

        while (in2.hasNextInt())
        {
            int input = in2.nextInt();
            secondList.add(input);
        }

        ArrayList<Integer> mergedArray = mergeSorted(firstList,secondList);

        //System.out.println(Arrays.toString(firstList.toArray()));
        //System.out.println(Arrays.toString(secondList.toArray()));

        System.out.println(Arrays.toString(mergedArray.toArray()));


    }

    public static ArrayList<Integer> mergeSorted(ArrayList<Integer> a, ArrayList<Integer> b)
    {
        ArrayList<Integer> mergedArray = new ArrayList<Integer>();

        //combine arrays into one
        for (int i=0; i < a.size(); i++)
        {
            mergedArray.add(a.get(i));
        }

        for (int i=0; i < b.size(); i++)
        {
            mergedArray.add(b.get(i));
        }

        //insertion sort
        for (int k = 1; k < mergedArray.size(); k++)
        {
            int valueToSort = mergedArray.get(k);
            int j = k;
            while (j > 0 && mergedArray.get(j-1) > valueToSort)
            {
                mergedArray.set(j, mergedArray.get(j-1));
                j = j - 1;
            }

            mergedArray.set(j, valueToSort);
        }

        return mergedArray;
    }


}
