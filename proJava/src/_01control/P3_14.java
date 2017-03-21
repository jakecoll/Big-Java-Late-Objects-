package _01control;

/**
 * Created by jakecoll on 10/2/16.
 */

import java.util.Scanner;

public class P3_14 {


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.print("Enter the Card Notation: ");
        String card = in.nextLine();
        in.close();

        char rank = card.charAt(0);
        char suit = card.charAt(1);

        String cardName = "";

        if (rank == 'A') {
            cardName += "Ace";
        }
        else if (rank == 'K') {
            cardName += "King";
        }
        else if (rank == 'Q') {
            cardName += "Queen";
        }
        else if (rank == 'J') {
            cardName += "Queen";
        }
        else if (rank == '1') {
            cardName += "10";
            suit = card.charAt(2);
        }
        else {
            cardName += Character.toString(rank);
        }

        cardName += " of ";

        if (suit == 'D') {
            cardName += "Diamonds";
        }
        if (suit == 'H') {
            cardName += "Hearts";
        }
        if (suit == 'S') {
            cardName += "Spades";
        }
        if (suit == 'C') {
            cardName += "Clubs";
        }

        System.out.printf("%s",cardName);
    }

}
