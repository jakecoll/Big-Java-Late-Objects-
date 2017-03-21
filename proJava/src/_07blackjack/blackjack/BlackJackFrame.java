package _07blackjack.blackjack;

/**
 * Created by jakecoll on 11/12/16.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BlackJackFrame extends JFrame {

    private final Player player;
    private Deck deck;
    private Hand hand;
    private DealerCardsComponent dealerCardsComponent;
    private PlayerCardsComponent playerCardsComponent;

    private JButton mBut0;
    private JButton mBut1;
    private JButton mBut2;

    private JLabel mStatusLabel;
    private JLabel mDealHand;
    private JLabel mPlayerHand;

    private JLabel mCurrentBet;
    private JLabel mHandTotal;
    private JLabel mDealerHand;

    private JTextField statusTextField;
    private JTextField currentBetTextField;
    private JTextField handTotalTextField;
    private JTextField dealerHandTextField;

    private JLabel mMoney;
    private JTextField moneyTextField;
    private JLabel mBet;
    private JTextField wagerTextField;
    private JButton mWagerButton;

    private boolean PlayerCanContinue;
    private boolean OnCurrentHand;
    private boolean AlreadyDoubled;

    private static final Dimension FRAME_DIM = new Dimension(600,600);

    /**
     * Constructs a BlackJackFrame object and references a player object
     * @param newPlayer
     */
    public BlackJackFrame(Player newPlayer)
    {
        player = newPlayer;

        //gets a new 6-Deck shoe
        deck = new Deck();

        //booleans set to false
        PlayerCanContinue = false;
        OnCurrentHand = false;
        AlreadyDoubled = false;

        createComponents();
        setSize(FRAME_DIM.width,FRAME_DIM.height);

        moneyTextField.setText(Double.toString(player.getBalance()));

        /**
         * Constructs ActionListener for the PlaceBet button
         */
        class PlaceBetClickListener implements ActionListener {


            public void actionPerformed(ActionEvent e)
            {
                String strWager = wagerTextField.getText() + ".0";
                double nWager = Double.parseDouble(strWager);

                //checks if a hand is already in progress
                if (OnCurrentHand)
                {
                    statusTextField.setText("Finish this hand before placing another wager.");

                }
                //checks if wager is legal
                else if (nWager > player.getBalance())
                {
                    statusTextField.setText("Can't bet money you don't have! Choose a different wager amount.");
                }

                //implements logic for dealing cards and updating corresponding text fields and booleans
                else {

                    playerCardsComponent.resetHand();
                    dealerCardsComponent.resetHand();

                    if (deck.getDeckCount() < 50)
                    {
                        deck = new Deck();
                    }

                    statusTextField.setText("Cards Dealt. Choose to Hit, Stay or Double Bet");
                    hand = new Hand(deck);

                    player.removeWager(nWager);
                    moneyTextField.setText(Double.toString(player.getBalance()));
                    currentBetTextField.setText(strWager);

                    handTotalTextField.setText(Integer.toString(hand.getPlayerTotal()));
                    dealerHandTextField.setText(Integer.toString(hand.getDealerLessHiddenTotal()));

                    for (Card playerCard : hand.getPlayerCards()) {
                        playerCardsComponent.addCard(playerCard);
                    }

                    playerCardsComponent.draw();

                    for (Card dealerCard : hand.getDealerCards()) {
                        dealerCardsComponent.addCard(dealerCard);
                    }

                    dealerCardsComponent.draw();
                    OnCurrentHand = true;
                    PlayerCanContinue = true;
                    AlreadyDoubled = false;
                }
            }

        }

        ActionListener placeBetListener = new PlaceBetClickListener();
        mWagerButton.addActionListener(placeBetListener);

        /**
         * Contructs ActionListener for Hit Button
         */
        class HitButtonClickListener implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                //checks if a hand is in progress and if player can press the hit button
                //subsequently implements logic dealing card to player and updates appropriate fields and booleans
                if (OnCurrentHand && PlayerCanContinue) {
                    Card hitCard = deck.getDeck().get(0);
                    playerCardsComponent.addCard(hitCard);
                    playerCardsComponent.draw();
                    hand.addPlayerCard(hitCard);
                    handTotalTextField.setText(Integer.toString(hand.getPlayerTotal()));
                    deck.removeCard(0);

                    statusTextField.setText("You hit! Choose again to Hit, Stay or Double?");

                    //if statement to check if player busts on hit
                    //changes booleans so player has to start a new hand and a new wager
                    if (hand.getPlayerTotal() > 21)
                    {
                        statusTextField.setText("BUST! Place another wager to play another hand.");

                        PlayerCanContinue = false;
                        OnCurrentHand = false;
                    }
                } else {
                    statusTextField.setText("Place another wager to play another hand!");
                }

            }
        }

        ActionListener hitButtonListener = new HitButtonClickListener();
        mBut0.addActionListener(hitButtonListener);

        /**
         * Constructs ActionListener for Stand Button
         */
        class StandButtonClickListener implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {

                //checks if hand in progress and if player is allowed to implement Stand action
                if (PlayerCanContinue && OnCurrentHand) {

                    //while loop implements logic for Dealer actions (e.g. hitting until greater than 16 or soft 17
                    while (hand.getDealerTotal() < 17 || (hand.getDealerTotal() == 17 && hand.isDealerHandIsSoft())) {
                        Card dealerHitCard = deck.getDeck().get(0);
                        dealerCardsComponent.addCard(dealerHitCard);
                        hand.addDealerCard(dealerHitCard);
                        deck.removeCard(0);
                    }


                    dealerHandTextField.setText(Integer.toString(hand.getDealerTotal()));
                    dealerCardsComponent.showHiddenCard();
                    dealerCardsComponent.draw();

                    String strWager = currentBetTextField.getText();
                    double nWager = Double.parseDouble(strWager);

                    //if statements check for final outcome and update appropriate fields and booleans so that player has to start another hand

                    //check for push
                    if (hand.getPlayerTotal() == hand.getDealerTotal()) {
                        player.addWinnings(nWager);
                        moneyTextField.setText(Double.toString(player.getBalance()));
                        statusTextField.setText("PUSH! Your wager was returned. Place another wager to play another hand.");
                    }
                    //check for blackjack
                    else if (hand.getPlayerTotal() == 21) {
                        player.addWinnings(nWager * 2.5);
                        moneyTextField.setText(Double.toString(player.getBalance()));
                        statusTextField.setText("BLACKJACK! Place another wager to play another hand.");
                    }
                    //check for player win
                    else if (hand.getPlayerTotal() > hand.getDealerTotal()) {
                        player.addWinnings(nWager * 2.0);
                        moneyTextField.setText(Double.toString(player.getBalance()));
                        statusTextField.setText("You win! Place another wager to play another hand.");
                    }
                    //check for dealer bust
                    else if (hand.getDealerTotal() > 21) {
                        player.addWinnings(nWager * 2.0);
                        moneyTextField.setText(Double.toString(player.getBalance()));
                        statusTextField.setText("DEALER BUSTS! YOUR WIN! Place another wager to play another hand.");

                    } else {
                        statusTextField.setText("YOU LOSE! Place another wager to play another hand.");
                    }

                    PlayerCanContinue = false;
                    OnCurrentHand = false;
                } else {
                    statusTextField.setText("Hand already ended. Place another wager to play another hand.");
                }


            }
        }

        ActionListener standButtonListener = new StandButtonClickListener();
        mBut1.addActionListener(standButtonListener);

        /**
         * Contructs ActionListener for Double Button
         */
        class DoubleButtonClickListener implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
               //checks if player is on current hand, can continue on hand and has not already doubled
                if (PlayerCanContinue && OnCurrentHand && !AlreadyDoubled)
                {
                    String strWager = wagerTextField.getText() + ".0";
                    double nWager = Double.parseDouble(strWager);


                    //logic for doubling wager and updating appropriate fields
                    player.removeWager(nWager);
                    moneyTextField.setText(Double.toString(player.getBalance()));
                    currentBetTextField.setText(Double.toString(nWager * 2));
                    AlreadyDoubled = true;

                    //Automatically implements a Hit when double is pressed
                    Card hitCard = deck.getDeck().get(0);
                    playerCardsComponent.addCard(hitCard);
                    playerCardsComponent.draw();
                    hand.addPlayerCard(hitCard);
                    handTotalTextField.setText(Integer.toString(hand.getPlayerTotal()));
                    deck.removeCard(0);

                    statusTextField.setText("You hit! Choose again to Hit, Stay or Double?");

                    //checks if player busts and ends hand
                    if (hand.getPlayerTotal() > 21)
                    {
                        statusTextField.setText("BUST! Place another wager to play another hand.");

                        PlayerCanContinue = false;
                        OnCurrentHand = false;
                    }
                } else if (PlayerCanContinue && OnCurrentHand && AlreadyDoubled){
                    statusTextField.setText("You can only double your bet once. Choose to Hit or Stand.");
                } else {
                    statusTextField.setText("Hand has ended. Place another wager to play a new hand.");
                }

            }
        }

        ActionListener doubleButtonListener = new DoubleButtonClickListener();
        mBut2.addActionListener(doubleButtonListener);
    }

    /**
     * method for rounding double to two decimal places
     * @param value
     * @return
     */
    public static double round(double value) {

        long factor = (long) Math.pow(10, 2);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    /**
     * Method contructs the GUI components of the BlackJackFrame class
     */
    public void createComponents()
    {
        this.mBut0 = new JButton("Double");
        this.mBut1 = new JButton("Hit");
        this.mBut2 = new JButton("Stand");

        JPanel blackjackPanelGUI = new JPanel(new BorderLayout());

        JPanel playerDealerHandPanel = new JPanel(new GridLayout(2,1));

        //Status Panel
        JPanel statusPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        mStatusLabel = new JLabel("Status: ");
        statusTextField = new JTextField(40);
        statusTextField.setText("Place a wager to begin playing");
        statusPanel.add(mStatusLabel);
        statusPanel.add(statusTextField);

        //Dealer's Hand Panel
        JPanel dealerHandPanel = new JPanel(new BorderLayout());
        JPanel labelDealerHand = new JPanel(new FlowLayout(FlowLayout.CENTER));
        mDealerHand = new JLabel("Dealer's Hand:");
        labelDealerHand.add(mDealerHand);
        dealerCardsComponent = new DealerCardsComponent();
        dealerHandPanel.add(labelDealerHand, BorderLayout.NORTH);
        dealerHandPanel.add(dealerCardsComponent, BorderLayout.CENTER);

        //Player's Hand Panel

        JPanel playerHandPanel = new JPanel(new BorderLayout());
        JPanel labelPlayerHand = new JPanel(new FlowLayout(FlowLayout.CENTER));
        mPlayerHand = new JLabel("Your Hand:");
        labelPlayerHand.add(mPlayerHand);
        playerCardsComponent = new PlayerCardsComponent();
        playerHandPanel.add(labelPlayerHand, BorderLayout.NORTH);
        playerHandPanel.add(playerCardsComponent, BorderLayout.CENTER);

        //hand status panel
        JPanel handStatusPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        mHandTotal = new JLabel("Hand Total:");
        mDealerHand = new JLabel("Dealer Showing:");
        mCurrentBet = new JLabel("Current Bet:");
        handTotalTextField = new JTextField(5);
        dealerHandTextField = new JTextField(5);
        currentBetTextField = new JTextField(5);
        handStatusPanel.add(mHandTotal);
        handStatusPanel.add(handTotalTextField);
        handStatusPanel.add(mDealerHand);
        handStatusPanel.add(dealerHandTextField);
        handStatusPanel.add(mCurrentBet);
        handStatusPanel.add(currentBetTextField);

        //button panel
        this.mBut0 = new JButton("Hit");
        this.mBut1 = new JButton("Stand");
        this.mBut2 = new JButton("Double");
        JPanel buttonPanel = new JPanel(new GridLayout(1,3));
        buttonPanel.add(mBut0);
        buttonPanel.add(mBut1);
        buttonPanel.add(mBut2);

        //wager panel
        JPanel wagerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        mMoney = new JLabel("Money:");
        moneyTextField = new JTextField(10);
        this.mWagerButton = new JButton("Place New Wager");
        wagerTextField = new JTextField(10);
        wagerPanel.add(mMoney);
        wagerPanel.add(moneyTextField);
        wagerPanel.add(mWagerButton);
        wagerPanel.add(wagerTextField);

        //bottom panel (e.g. hand + button + wager panels for south section of border layout)
        JPanel bottomPanel = new JPanel(new GridLayout(3,1));
        bottomPanel.add(handStatusPanel);
        bottomPanel.add(buttonPanel);
        bottomPanel.add(wagerPanel);

        playerDealerHandPanel.add(dealerHandPanel);
        playerDealerHandPanel.add(playerHandPanel);

        blackjackPanelGUI.add(statusPanel, BorderLayout.NORTH);
        blackjackPanelGUI.add(playerDealerHandPanel, BorderLayout.CENTER);
        blackjackPanelGUI.add(bottomPanel, BorderLayout.SOUTH);

        add(blackjackPanelGUI);
    }
}
