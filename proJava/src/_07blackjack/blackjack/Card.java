package _07blackjack.blackjack;

/**
 * Created by jakecoll on 11/12/16.
 */
public class Card {

    private String strCardName;
    private int nValue;

    /**
     * Constructs a Card object
     * @param cardName
     * @param value
     */
    public Card(String cardName, int value)
    {
        strCardName = cardName;
        nValue = value;
    }

    /**
     * Returns the Card object name
     * @return
     */
    public String getCardName()
    {
        return strCardName;
    }

    /**
     * Returns the Card object's value
     * @return
     */
    public int getValue()
    {
        return nValue;
    }

}
