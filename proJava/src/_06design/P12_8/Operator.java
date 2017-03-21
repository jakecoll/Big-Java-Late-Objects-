package _06design.P12_8;

/**
 * Created by jakecoll on 11/6/16.
 */
public class Operator {
    private String strName;
    private String nOperatorPassword;
    private double dMoneyCollected;


    /**
     * Constructs a Operator object with no parameters
     */
    public Operator()
    {
        strName = "Master Operator";
        nOperatorPassword = "1234";
        dMoneyCollected = 0.0;
    }

    /**
     * Constructs a Operator object based on an input name as a String
     * @param name
     */
    public Operator(String name)
    {
        strName = name;
        nOperatorPassword = "1234";
        dMoneyCollected = 0.0;
    }

    /**
     * method sets the String name of an Operator object
     * @param name
     */
    public void setName(String name)
    {
        strName = name;
    }

    /**
     * method returns the name of an Operator object as a String
     * @return
     */
    public String getName()
    {
        return strName;
    }

    /**
     * method sets a new operator password based on a String parameter
     * @param newPassword
     */
    public void setNewPassword(String newPassword)
    {
        nOperatorPassword = newPassword;
    }

    /**
     * Method
     * @param collectionAmount
     */
    public void addCollectedMoney(double collectionAmount)
    {
        dMoneyCollected = dMoneyCollected + collectionAmount;
    }

    /**
     * method returns the money collected by an Operator object
     * @return
     */
    public double getCollectionAmount()
    {
        return dMoneyCollected;
    }

    /**
     * method returns a boolean value after checking is a String parameter variable is equal to the nOperatorPassword variable
     * @param enteredPasscode
     * @return
     */
    public boolean checkPassword(String enteredPasscode)
    {
        if (enteredPasscode.equals(nOperatorPassword))
        {
            return true;
        } else { return false; }
    }
}
