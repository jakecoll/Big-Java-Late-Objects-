package _07blackjack.blackjack;

/**
 * Created by jakecoll on 11/13/16.
 */
import java.util.ArrayList;

public class Hand {

    private ArrayList<Card> playerCards;
    private ArrayList<Card> dealerCards;

    private int nPlayerTotal;
    private int nDealerLessHiddenTotal;
    private int nDealerTotal;
    private int nPlayerSoftAces;

    private int nDealerSoftAces;

    private boolean PlayerHandIsSoft;
    private boolean DealerHandIsSoft;
    private boolean DealerCardHidden;

    /**
     * Constructs a Hand object from a deck of cards to simulate a hand of blackjack
     * @param deck
     */
    public Hand(Deck deck)
    {
        playerCards = new ArrayList<Card>();
        dealerCards = new ArrayList<Card>();

        DealerCardHidden = true;

        PlayerHandIsSoft = false;
        DealerHandIsSoft = false;

        //deals cards one at a time between player and dealer
        ArrayList<Card> deckCards = deck.getDeck();
        Card firstCard = deckCards.get(0);
        Card secondCard = deckCards.get(1);
        Card thirdCard = deckCards.get(2);
        Card fourthCard = deckCards.get(3);

        //totals value of cards
        nPlayerTotal = firstCard.getValue() + thirdCard.getValue();
        nDealerTotal = secondCard.getValue() + fourthCard.getValue();
        nDealerLessHiddenTotal = fourthCard.getValue();

        //adds card objects to array for player and dealer
        playerCards.add(firstCard);
        playerCards.add(thirdCard);
        dealerCards.add(secondCard);
        dealerCards.add(fourthCard);

        //for loop sets booleans related to whether hands are hard or soft and adds number of aces
        for (int i = 1; i <= 4; i++)
        {
            if (i % 2 != 0 && deckCards.get(0).getValue() == 11)
            {
                PlayerHandIsSoft = true;
                nPlayerSoftAces += 1;
            }
            if (i % 2 == 0 && deckCards.get(0).getValue() == 11)
            {
                DealerHandIsSoft = true;
                nDealerSoftAces += 1;
            }

            deck.removeCard(0);
        }
    }

    /**
     * Method adds a new card to the players hand and recalculates the players total
     * @param card
     */
    public void addPlayerCard(Card card)
    {
        playerCards.add(card);
        recalculatePlayerTotal();
    }

    /**
     * Method recalculates the players total including accounting for aces and adjusting accordingly
     */
    public void recalculatePlayerTotal()
    {
        int tempTotal = 0;
        nPlayerSoftAces = 0;


        for (Card card: playerCards)
        {
            tempTotal += card.getValue();

            if (card.getValue() == 11)
            {
                PlayerHandIsSoft = true;
                nPlayerSoftAces += 1;
            }
        }

        if (tempTotal > 21 && PlayerHandIsSoft)
        {
            while(tempTotal > 21 && nPlayerSoftAces > 0)
            {
                tempTotal = tempTotal - 10;
                nPlayerSoftAces -= 1;
            }

            if (nPlayerSoftAces == 0)
            {
                PlayerHandIsSoft = false;
            }
        }

        nPlayerTotal = tempTotal;
    }

    /**
     * Method returns a boolean for whether or not the Dealer's hand is soft (true is soft)
     * @return
     */
    public boolean isDealerHandIsSoft()
    {
        if(DealerHandIsSoft)
        {
            return true;
        } else { return false; }
    }

    /**
     * Adds a Card object to the Dealer's hand and recalculates dealer's total card value
     * @param card
     */
    public void addDealerCard(Card card)
    {
        dealerCards.add(card);
        recalculateDealerTotal();
    }

    /**
     * Method changes the boolean value indicating that the Dealer is hiding his first card to true
     */
    public void hideDealerCard()
    {
        DealerCardHidden = true;
    }

    /**
     * Method recalculates the Dealer's card values and takes account of whether or not hand has aces and adjusts values accordiningly
     */
    public void recalculateDealerTotal()
    {
        int tempDealerTotal = 0;
        nDealerLessHiddenTotal = dealerCards.get(0).getValue() * -1;
        nDealerSoftAces = 0;

        for (Card card: dealerCards)
        {
            tempDealerTotal += card.getValue();
            nDealerLessHiddenTotal += card.getValue();

            if (card.getValue() == 11)
            {
                DealerHandIsSoft = true;
                nDealerSoftAces += 1;
            }
        }

        if (tempDealerTotal > 21 && DealerHandIsSoft)
        {
            while(tempDealerTotal > 21 && nDealerSoftAces > 0)
            {
                tempDealerTotal = tempDealerTotal - 10;
                nDealerSoftAces -= 1;
            }

            if (nDealerSoftAces == 0)
            {
                DealerHandIsSoft = false;
            }
        }

        nDealerTotal = tempDealerTotal;
    }

    /**
     * Method returns the player's total card value as an int
     * @return
     */
    public int getPlayerTotal()
    {
        return nPlayerTotal;
    }

    /**
     * Method returns the value of the Dealer's face up cards (e.g. does not include the hidden card)
     * @return
     */
    public int getDealerLessHiddenTotal()
    {
        return nDealerLessHiddenTotal;
    }

    /**
     * Method returns the total value of the Dealer's cards including the hidden card
     * @return
     */
    public int getDealerTotal()
    {

        return nDealerTotal;
    }

    /**
     * Method returns the player's hand as an array of Card objects
     * @return
     */
    public ArrayList<Card> getPlayerCards()
    {
        return playerCards;
    }

    /**
     * Method returns the Dealer's hand as an array of Card objects
     * @return
     */
    public ArrayList<Card> getDealerCards()
    {
        return dealerCards;
    }
}
