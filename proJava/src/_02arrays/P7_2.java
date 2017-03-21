package _02arrays;

/**
 * Created by jakecoll on 10/9/16.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class P7_2 {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner console = new Scanner(System.in);
        System.out.print("Input File: ");
        String inputFileName = console.next();
        System.out.print("Output File: ");
        String outputFileName = console.next();

        File inputFile = new File(inputFileName);
        Scanner in = new Scanner(inputFile);
        PrintWriter out = new PrintWriter(outputFileName);

        int nLineCount = 1;

        while (in.hasNextLine())
        {
            String line = in.nextLine();
            String incLine = "/* " + nLineCount + " */ " + line;
            out.printf("%s\n", incLine);
            nLineCount++;
        }

        in.close();
        out.close();

    }
}
