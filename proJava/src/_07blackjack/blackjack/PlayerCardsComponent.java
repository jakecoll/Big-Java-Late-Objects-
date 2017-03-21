package _07blackjack.blackjack;


/**
 * Created by jakecoll on 11/13/16.
 */

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import java.util.ArrayList;

public class PlayerCardsComponent extends JPanel {

    private ArrayList<BufferedImage> cardImages;
    private ArrayList<Card> playerCards;

    private BufferedImage mPlayerCard;
    private static final int xDim = 111;
    private static final int yDim = 161;
    private int x = 10;
    private int y = 10;

    /**
     * Constructs a PlayerCardsComponent
     */
    public PlayerCardsComponent()
    {
        playerCards = new ArrayList<Card>();
        cardImages = new ArrayList<BufferedImage>();

    }

    /**
     * Constructs a PlayerCardComponent with given hand of cards references as array of Card objects
     * @param cards
     */
    public PlayerCardsComponent(ArrayList<Card> cards)
    {
        playerCards = cards;
        cardImages = new ArrayList<BufferedImage>();

        for (Card card: playerCards)
        {
            try {
                BufferedImage temp = ImageIO.read(getClass().getResource("./resources/cards_png/" + card.getCardName() + ".png"));
                cardImages.add(temp);

            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    /**
     * Method add card image of Card object to the images array
     * @param card
     */
    public void addCard(Card card)
    {
        playerCards.add(card);

        try {
            BufferedImage cardImage = ImageIO.read(getClass().getResource("./resources/cards_png/" + card.getCardName() + ".png"));
            cardImages.add(cardImage);

        } catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    /**
     * Method resets the CardComponent to be a blank green background with no cards
     */
    public void resetHand()
    {
        cardImages = new ArrayList<BufferedImage>();
        playerCards = new ArrayList<Card>();
    }

    /**
     * Method for repainting cards on component
     */
    public void draw()
    {
        x = 10;
        y = 10;
        repaint();
    }

    /**
     * Method paints background and cards if they exist
     * @param g
     */
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        //background
        g.setColor(Color.GREEN);
        g.fillRect(0,0,600,20+yDim);

        for (BufferedImage image: cardImages)
        {
            g.setColor(Color.WHITE);
            g.fillRect(x,y,xDim,yDim);
            g.drawImage(image,x,y,xDim,yDim,null);
            x = x + 10 + xDim;
        }




    }


}
