package _07blackjack.blackjack;

/**
 * Created by jakecoll on 11/12/16.
 */
public class Player {

    private double nBalance;

    /**
     * Constructs a Player object with initial balance of 1000.0
     */
    public Player()
    {
        nBalance = 1000.0;
    }

    /**
     * Method returns the Player object's balance
     * @return
     */
    public double getBalance()
    {
        return round(nBalance);
    }

    /**
     * Method removes a wager amount from the player's balance
     * @param wager
     */
    public void removeWager(double wager)
    {
        nBalance = nBalance - wager;
    }

    /**
     * Method adds a player's winnings to its balance
     * @param winnings
     */
    public void addWinnings(double winnings)
    {
        nBalance = nBalance + winnings;
    }

    /**
     * Method rounds doubles to two decimal places
     * @param value
     * @return
     */
    public static double round(double value) {

        long factor = (long) Math.pow(10, 2);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}
