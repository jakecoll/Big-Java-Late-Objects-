package _06design.P12_8;

/**
 * Created by jakecoll on 11/6/16.
 */
import java.util.ArrayList;
import java.util.Arrays;

public class InsertedCoins {

    private double[] arrLegalDenominations;
    private ArrayList<Double> arrInsertedCoins;
    private double nCoinTotal;
    private boolean AllLegalCoins;

    /**
     * Constructs a InsertedCoins object with no parameters passed to it
     */
    public InsertedCoins()
    {
        arrInsertedCoins = new ArrayList<Double>();
        arrLegalDenominations = new double[] {0.01, 0.05, 0.10, 0.25, 0.50, 1.00};
        nCoinTotal = 0.0;
        AllLegalCoins = true;

    }

    /**
     * Constructs a InsertedCoins object based on an arraylist of doubles as a parameter variable
     * @param insertedCoins
     */
    public InsertedCoins(ArrayList<Double> insertedCoins)
    {
        double tempTotal = 0.0;

        for(Double coin: insertedCoins)
        {
            arrInsertedCoins.add(coin);
            tempTotal = tempTotal + coin;
        }

        arrLegalDenominations = new double[] {0.01, 0.05, 0.10, 0.25, 0.50, 1.00};
        nCoinTotal = tempTotal;
    }

    /**
     * method returns a boolean if the arrInsertedCoins variable of a InsertedCoins object are all legal denominations accepted
     * @return
     */
    public boolean checkLegalCoins()
    {

        for(Double coin: arrInsertedCoins)
        {
            boolean IsLegal = false;
            for(Double denom: arrLegalDenominations)
            {
                double test = coin - denom;
                if (test==0.0)
                {
                    IsLegal = true;
                }
            }

            if(!IsLegal)
            {
                AllLegalCoins = false;
            }
        }

        if (AllLegalCoins) return true;
        else return false;
    }

    /**
     * method to return the total of the arrInsertedCoins variable of an InsertedCoins object as a double
     * @return
     */
    public double getTotal()
    {
        return nCoinTotal;
    }

    /**
     * method for adding a new coin to the arrInsertedCoins array of an InsertedCOins object
     * @param coin
     */
    public void addCoin(double coin)
    {
        arrInsertedCoins.add(coin);
        nCoinTotal = nCoinTotal + coin;
    }


}
