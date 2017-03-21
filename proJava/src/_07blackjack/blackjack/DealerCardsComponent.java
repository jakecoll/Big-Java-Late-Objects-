package _07blackjack.blackjack;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import java.util.ArrayList;

/**
 * Created by jakecoll on 11/13/16.
 */
public class DealerCardsComponent extends JPanel {

    private ArrayList<BufferedImage> cardImages;
    private ArrayList<Card> dealerCards;

    private BufferedImage mHiddenCard;

    private static final int xDim = 111;
    private static final int yDim = 161;

    private boolean DealCardIsHidden;

    private int x = 10;
    private int y = 10;

    /**
     * Constructs a DealerCardComponent object
     */
    public DealerCardsComponent()
    {
        cardImages = new ArrayList<BufferedImage>();
        dealerCards = new ArrayList<Card>();

        DealCardIsHidden = true;

        try {
            mHiddenCard = ImageIO.read(getClass().getResource("./resources/cards_png/back.png"));
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Method adds an image of a card object to the array of images
     * @param card
     */
    public void addCard(Card card)
    {
        dealerCards.add(card);

        try {
            BufferedImage cardImage = ImageIO.read(getClass().getResource("./resources/cards_png/" + card.getCardName() + ".png"));
            cardImages.add(cardImage);

        } catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    /**
     * Method clears the image and card arrays of the object and sets the boolean for hiding the first card back to true
     */
    public void resetHand()
    {
        cardImages = new ArrayList<BufferedImage>();
        dealerCards = new ArrayList<Card>();
        DealCardIsHidden = true;
    }

    /**
     * Method changes the DealCardIsHidden boolean to false so that it flipped when componenet repainted
     */
    public void showHiddenCard()
    {
        DealCardIsHidden = false;
    }

    /**
     * Method repaints componenet
     */
    public void draw()
    {
        repaint();
    }

    /**
     * Method paints background and card images in dealer's hand unless Dealer card is hidden in which case
     * it shows back of first cards and paints each subsequent card.
     * @param g
     */
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        //background
        g.setColor(Color.GREEN);
        g.fillRect(0,0,600,20+yDim);

        if (dealerCards.size() == 0)
        {

        }

        else if (DealCardIsHidden)
        {
            x = 10;
            y = 10;

            g.setColor(Color.WHITE);
            g.fillRect(10,10,xDim,yDim);
            g.drawImage(mHiddenCard,x,y,xDim,yDim,null);
            x = x + 10 + xDim;

            for (int i = 1; i < dealerCards.size(); i++)
            {
                g.setColor(Color.WHITE);
                g.fillRect(x,y,xDim,yDim);
                g.drawImage(cardImages.get(i),x,y,xDim,yDim,null);
                x = x + 10 + xDim;
            }
        } else {

            x = 10;
            y = 10;

            for (BufferedImage image: cardImages)
            {
                g.setColor(Color.WHITE);
                g.fillRect(x,y,xDim,yDim);
                g.drawImage(image,x,y,xDim,yDim,null);
                x = x + 10 + xDim;
            }
        }




    }
}
