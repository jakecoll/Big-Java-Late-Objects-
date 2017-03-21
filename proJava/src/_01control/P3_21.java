package _01control;

import java.util.Scanner;

/**
 * Created by jakecoll on 10/2/16.
 */
public class P3_21 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.print("Please enter your income: ");
        double income = in.nextDouble();

        Double dTaxes = 0.0;

        Double dTaxRate_1 = 0.01;
        Double dTaxRate_2 = 0.02;
        Double dTaxRate_3 = 0.03;
        Double dTaxRate_4 = 0.04;
        Double dTaxRate_5 = 0.05;
        Double dTaxRate_6 = 0.06;

        /* Calculate max taxes for each income bracket segment*/
        Double dPartialTax_Bracket_1 = 50000.0 * dTaxRate_1;
        Double dPartialTax_Bracket_2 = (75000.0 - 50000.0) * dTaxRate_2;
        Double dPartialTax_Bracket_3 = (100000.0 - 75000.0) * dTaxRate_3;
        Double dPartialTax_Bracket_4 = (250000.0 - 100000.0) * dTaxRate_4;
        Double dPartialTax_Bracket_5 = (500000.0 - 250000.0) * dTaxRate_5;

        if (income <= 50000.0)
        {
            dTaxes += income * dTaxRate_1;
        }
        else if (income > 50000.0 && income <= 75000.00) {
            dTaxes += dPartialTax_Bracket_1 + ((income % 50000.0) * dTaxRate_2);
        }
        else if (income > 75000.0 && income <= 100000.00) {
            dTaxes += dPartialTax_Bracket_1
                    + dPartialTax_Bracket_2
                    + ((income % 75000.0) * dTaxRate_3);
        }
        else if (income > 100000.0 && income <= 250000.00) {
            dTaxes += dPartialTax_Bracket_1
                    + dPartialTax_Bracket_2
                    + dPartialTax_Bracket_3
                    + ((income % 100000.0) * dTaxRate_4);
        }
        else if (income > 250000.0 && income <= 500000.00) {
            dTaxes += dPartialTax_Bracket_1
                    + dPartialTax_Bracket_2
                    + dPartialTax_Bracket_3
                    + dPartialTax_Bracket_4
                    + ((income % 250000.0) * dTaxRate_5);
        }
        else if (income > 500000.00) {
            dTaxes += dPartialTax_Bracket_1
                    + dPartialTax_Bracket_2
                    + dPartialTax_Bracket_3
                    + dPartialTax_Bracket_4
                    + dPartialTax_Bracket_5
                    + ((income % 500000.0) * dTaxRate_6);
        }


        System.out.printf("Taxes Owed: %f",dTaxes);



    }

}
