package _02arrays;

/**
 * Created by jakecoll on 10/9/16.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

public class P7_17 {
    public static void main(String[] args) throws FileNotFoundException {

        ArrayList<String> fileLines = new ArrayList<String>();

        Scanner console = new Scanner(System.in);
        System.out.print("Input File: ");
        String inputFileName = console.next();

        File inputFile = new File(inputFileName);
        Scanner in = new Scanner(inputFile);

        while (in.hasNextLine())
        {
            String line = in.nextLine();
            fileLines.add(line);

        }

        ArrayList<String> uniqueServiceCategories = serviceCategories(fileLines);

        //loop through categories and output files with correct names
        //uses printServiceCategories method for output files
        for (int i=0; i < uniqueServiceCategories.size(); i++)
        {
            String category = uniqueServiceCategories.get(i);
            printServiceCategories(fileLines,category);
        }

        in.close();

        //to check if file is inputing correctly
        //System.out.println(Arrays.deepToString(fileLines.toArray()));

    }

    public static ArrayList<String> serviceCategories(ArrayList<String> input)
    {
        ArrayList<String> serviceCategories = new ArrayList<String>();

        for (int i = 0; i < input.size(); i++)
        {
            String[] parts = input.get(i).split(";");

            if (!Arrays.asList(serviceCategories).contains(parts[1]))
            {
                serviceCategories.add(parts[1]);
            }

        }

        return serviceCategories;

    }

    public static void printServiceCategories(ArrayList<String> input, String category) throws FileNotFoundException
    {
        ArrayList<String> categoryEntries = new ArrayList<String>();

        for (int i=0; i < input.size(); i++)
        {
            String[] parts = input.get(i).split(";");
            if (parts[1].equals(category))
            {
                categoryEntries.add(input.get(i));
            } else { ; }
        }

        String outputFileName = category + ".txt";
        PrintWriter out = new PrintWriter(outputFileName);

        for (int j = 0; j < categoryEntries.size(); j++)
        {
            String line = categoryEntries.get(j);
            out.printf("%s\n",line);
        }

        out.close();

    }
}
