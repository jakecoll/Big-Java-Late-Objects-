package _07blackjack.blackjack;

/**
 * Created by jakecoll on 11/12/16.
 */
import java.util.ArrayList;
import java.util.Random;

public class Deck {

    private ArrayList<Card> deck;
    private int nShoe;
    private String[] cards = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king", "ace"};
    private String[] suits = {"_of_spades", "_of_clubs", "_of_hearts", "_of_diamonds"};
    private int nDeckCount;

    /**
     * Constructs a Deck object from 6 individual card decks
     */
    public Deck() {

        nShoe = 6;
        ArrayList<Card> unshuffledDeck = buildDeck(cards,suits,nShoe);
        deck = shuffle(unshuffledDeck);
        nDeckCount = deck.size();
    }

    /**
     * Constructs a Deck object with custom deck shoe passed as parameter
     * @param nCardPacks
     */
    public Deck(int nCardPacks)
    {
        nShoe = nCardPacks;
        ArrayList<Card> unshuffledDeck = buildDeck(cards,suits,nShoe);
        deck = shuffle(unshuffledDeck);
        nDeckCount = deck.size();
    }

    /**
     * Returns a standard deck of cards as an array of Card objects
     * @param cards
     * @param suits
     * @param cardPacks
     * @return
     */
    public ArrayList<Card> buildDeck(String[] cards, String[] suits, int cardPacks) {
        ArrayList<Card> unshuffledDeck = new ArrayList<>();

        for (int i = 1; i <= cardPacks; i++) {
            for (String card : cards) {
                for (String suit : suits) {

                    String newCardName = card + suit;
                    Card tempCard;

                    try {
                        int cardValue = Integer.parseInt(card);
                        tempCard = new Card(newCardName, cardValue);
                    } catch (NumberFormatException e) {
                        if (card == "ace") {
                            tempCard = new Card(newCardName, 11);
                        } else {
                            tempCard = new Card(newCardName, 10);
                        }

                    }

                    unshuffledDeck.add(tempCard);
                }
            }
        }

        return unshuffledDeck;
    }

    /**
     * Method returns a shuffled standard deck of cards as an array of Card objects in random order
     * @param cardDeck
     * @return
     */
    public ArrayList<Card> shuffle(ArrayList<Card> cardDeck)
    {
        ArrayList<Card> shuffledDeck = new ArrayList<Card>();

        int i = cardDeck.size();
        while(i > 0)
        {
            Random rand = new Random();
            int index = rand.nextInt(i);
            shuffledDeck.add(cardDeck.get(index));
            cardDeck.remove(index);
            i = i -1;
        }

        return shuffledDeck;
    }

    /**
     * Method returns the array of cards in the Deck object
     * @return
     */
    public ArrayList<Card> getDeck()
    {
        return deck;
    }

    /**
     * Method returns the Deck count of the total deck shoe
     * Useful after cards are discarded from deck and a new Deck needs to be constructed
     * @return
     */
    public int getDeckCount()
    {
        return nDeckCount;
    }

    /**
     * Method removes a Card object from the cards array in the Deck object
     * @param index
     */
    public void removeCard(int index)
    {
        deck.remove(index);
    }

}
