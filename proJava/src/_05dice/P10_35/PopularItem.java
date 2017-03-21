package _05dice.P10_35;

/**
 * Created by jakecoll on 10/30/16.
 */
public class PopularItem {

    private String strName;
    private double dPrice;

    /**
     * Constructs a PopularItem object with name and price
     * @param name
     * @param price
     */
    public PopularItem(String name, double price)
    {
        strName = name;
        dPrice = price;
    }

    /**
     * method returns the price of the PopularItem object
     * @return
     */
    public double getPrice()
    {
        return dPrice;
    }

    /**
     * method for returning name of PopularItem object
     * @return
     */
    public String getName()
    {
        return strName;
    }

    /**
     * method for setting/changing name of a PopularItem object
     * @param name
     */
    public void setName(String name)
    {
        strName = name;
    }

    /**
     * method for setting/changing price of PopularItem object
     * @param price
     */
    public void setPrice(double price)
    {
        dPrice = price;
    }
}
