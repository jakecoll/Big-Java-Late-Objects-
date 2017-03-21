package _05dice.P10_35;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.peer.PopupMenuPeer;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by jakecoll on 10/30/16.
 * Write a graphical application that produces a restaurant bill.
 * Provide buttons for ten popular dishes or drink items. (You decide on the items and their prices.)
 * Provide text fields for entering less popular items and prices. In a text area, show the bill, including tax and a suggested tip.
 */
public class RestaurantBillFrame extends JFrame {

    private JButton mBut0;
    private JButton mBut1;
    private JButton mBut2;
    private JButton mBut3;
    private JButton mBut4;
    private JButton mBut5;
    private JButton mBut6;
    private JButton mBut7;
    private JButton mBut8;
    private JButton mBut9;
    private JButton mAddOtherItem;

    private JTextField mMealCharge;
    private JTextField mTaxes;
    private JTextField mSuggestTip;
    private JTextField mTotalBill;
    private JTextField mOtherItemName;
    private JTextField mOtherItemPrice;

    private JLabel mealChargeLabel;
    private JLabel taxesLabel;
    private JLabel suggestedTipLabel;
    private JLabel totalBillLabel;
    private JLabel otherItemNameLabel;
    private JLabel otherItemPriceLabel;

    private JTextArea mDisplay;

    private static final int FRAME_WIDTH = 600;
    private static final int FRAME_HEIGHT = 600;

    private double dMealCharge = 0.0;
    private double dTaxRate = 0.0675;
    private double dProperTipRate = .20;

    public RestaurantBillFrame() {
        //array stores all popular items so they can be constructed or referenced by index
        final ArrayList<PopularItem> arrayPopularItems = addItems();

        createComponents();
        setSize(FRAME_WIDTH,FRAME_HEIGHT);

        /*
         * inner class action listener for popular items buttons
         * Takes in button number and then pulls relevant data from Popular Item objects in itemBill array list
         */
        class PopularItemListener implements ActionListener
        {
            int nItem;
            DecimalFormat numberFormat = new DecimalFormat("#.00");

            /**
             * Constructs PopularItemListener with index number associated with button and index location in arrayPopularItems
             * @param itemNum
             */
            public PopularItemListener(int itemNum)
            {
                nItem = itemNum;

            }

            /**
             * actionPerformed method updates bill with corresponding individual costs in bill area
             * then updates corresponding meal, tax, tip, and total charges in respective text fields
             * @param event
             */
            @Override
            public void actionPerformed(ActionEvent event)
            {
                dMealCharge = dMealCharge + arrayPopularItems.get(nItem).getPrice();
                double dTaxesAmount = dMealCharge * dTaxRate;
                double dTipAmount = dMealCharge * dProperTipRate;
                double dBillTotal = dMealCharge + dTaxesAmount + dTipAmount;

                mDisplay.setText(mDisplay.getText() + arrayPopularItems.get(nItem).getName() + " $" + arrayPopularItems.get(nItem).getPrice() + " \n");
                mMealCharge.setText("$" + numberFormat.format(dMealCharge));
                mTaxes.setText("$" + numberFormat.format(dTaxesAmount));
                mSuggestTip.setText("$" + numberFormat.format(dTipAmount));
                mTotalBill.setText("$" + numberFormat.format(dBillTotal));
            }
        }

        //Following add action listeners to buttons with corresponding index numbers
        ActionListener pancakes = new PopularItemListener(0);
        mBut0.addActionListener(pancakes);

        ActionListener frenchToast = new PopularItemListener(1);
        mBut1.addActionListener(frenchToast);

        ActionListener eggsBenedict = new PopularItemListener(2);
        mBut2.addActionListener(eggsBenedict);

        ActionListener huevosRancheros = new PopularItemListener(3);
        mBut3.addActionListener(huevosRancheros);

        ActionListener biscuitsGravy = new PopularItemListener(4);
        mBut4.addActionListener(biscuitsGravy);

        ActionListener breakfastSkillet = new PopularItemListener(5);
        mBut5.addActionListener(breakfastSkillet);

        ActionListener omelet = new PopularItemListener(6);
        mBut6.addActionListener(omelet);

        ActionListener eggsFlorentine = new PopularItemListener(7);
        mBut7.addActionListener(eggsFlorentine);

        ActionListener yogurtParfait = new PopularItemListener(8);
        mBut8.addActionListener(yogurtParfait);

        ActionListener breakfastSpecial = new PopularItemListener(9);
        mBut9.addActionListener(breakfastSpecial);

        /**
         * Add action listener for Add Other Item Fields
         * Wasn't sure how to get the input from the text fields so found help from this stack overflow question
         * http://stackoverflow.com/questions/5752307/how-to-retrieve-value-from-jtextfield-in-java-swing
         */
        mAddOtherItem.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event)
            {
                String strName = mOtherItemName.getText();
                double dPrice = Double.parseDouble(mOtherItemPrice.getText());

                DecimalFormat numberFormat = new DecimalFormat("#.00");

                dMealCharge = dMealCharge + dPrice;
                double dTaxesAmount = dMealCharge * dTaxRate;
                double dTipAmount = dMealCharge * dProperTipRate;
                double dBillTotal = dMealCharge + dTaxesAmount + dTipAmount;

                mDisplay.setText(mDisplay.getText() + strName + " $" + dPrice + " \n");
                mMealCharge.setText("$" + numberFormat.format(dMealCharge));
                mTaxes.setText("$" + numberFormat.format(dTaxesAmount));
                mSuggestTip.setText("$" + numberFormat.format(dTipAmount));
                mTotalBill.setText("$" + numberFormat.format(dBillTotal));
            }
        });



    }

    /**
     * method for constructing arrayPopularItems
     * @return
     */
    public static ArrayList<PopularItem> addItems()
    {
        ArrayList<PopularItem> itemBill = new ArrayList<PopularItem>();
        PopularItem pancakes = new PopularItem("Pancakes", 5.99);
        PopularItem frenchToast = new PopularItem("French Toast", 6.99);
        PopularItem eggsBenedict = new PopularItem("Eggs Benedict", 11.99);
        PopularItem huevosRanchers = new PopularItem("Huevos Rancheros", 9.99);
        PopularItem biscuitsGravy = new PopularItem("Biscuits & Gravy", 6.99);
        PopularItem breakfastSkillet = new PopularItem("Breakfast Skillet", 8.99);
        PopularItem omelet = new PopularItem("Omelet", 5.99);
        PopularItem eggsFlorentine = new PopularItem("Eggs Florentine", 13.99);
        PopularItem yogurtParfait = new PopularItem("Yogurt Parfait", 8.99);
        PopularItem breakfastSpecial = new PopularItem("Breakfast Special", 7.99);
        itemBill.add(pancakes);
        itemBill.add(frenchToast);
        itemBill.add(eggsBenedict);
        itemBill.add(huevosRanchers);
        itemBill.add(biscuitsGravy);
        itemBill.add(breakfastSkillet);
        itemBill.add(omelet);
        itemBill.add(eggsFlorentine);
        itemBill.add(yogurtParfait);
        itemBill.add(breakfastSpecial);

        return itemBill;

    }


    /**
     * method for constructing components of GUI interface
     */
    public void createComponents()
    {
        this.mBut0 = new JButton("Pancakes");
        this.mBut1 = new JButton("French Toast");
        this.mBut2 = new JButton("Eggs Benedict");
        this.mBut3 = new JButton("Huevos Rancheros");
        this.mBut4 = new JButton("Biscuits & Gravy");
        this.mBut5 = new JButton("Breakfast Skillet");
        this.mBut6 = new JButton("Omelet");
        this.mBut7 = new JButton("Eggs Florentine");
        this.mBut8 = new JButton("Yogurt Parfait");
        this.mBut9 = new JButton("Breakfast Special");
        this.mAddOtherItem = new JButton("Add Item");

        this.mDisplay = new JTextArea("*****Items Ordered*****\n");

        final int DISPLAY_WIDTH = 400;
        final int DISPLAY_HEIGHT = 200;
        this.mDisplay.setPreferredSize(new Dimension(DISPLAY_WIDTH,DISPLAY_HEIGHT));

        //final layout
        JPanel restaurantBillPanel = new JPanel();

        restaurantBillPanel.setLayout(new BorderLayout());

        //layout of popular items button
        JPanel popularItemsPanel = new JPanel();
        popularItemsPanel.setLayout(new GridLayout(5,2));

        popularItemsPanel.add(mBut0);
        popularItemsPanel.add(mBut1);
        popularItemsPanel.add(mBut2);
        popularItemsPanel.add(mBut3);
        popularItemsPanel.add(mBut4);
        popularItemsPanel.add(mBut5);
        popularItemsPanel.add(mBut6);
        popularItemsPanel.add(mBut7);
        popularItemsPanel.add(mBut8);
        popularItemsPanel.add(mBut9);

        //meal charge panel layout
        JPanel mealChargePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        mealChargeLabel = new JLabel("Meal Charge: ");
        mMealCharge = new JTextField(10);
        mMealCharge.setText("$0.00");
        mealChargePanel.add(mealChargeLabel);
        mealChargePanel.add(mMealCharge);

        //taxes panel layout
        JPanel taxesPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        taxesLabel = new JLabel("Taxes: ");
        mTaxes = new JTextField(10);
        mTaxes.setText("$0.00");
        taxesPanel.add(taxesLabel);
        taxesPanel.add(mTaxes);

        //gratuity panel layout
        JPanel suggestTipPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        suggestedTipLabel = new JLabel("Suggested Gratuity: ");
        mSuggestTip = new JTextField(10);
        mSuggestTip.setText("$0.00");
        suggestTipPanel.add(suggestedTipLabel);
        suggestTipPanel.add(mSuggestTip);

        //total amout panel layout
        JPanel totalBillPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        totalBillLabel = new JLabel("Amount Owed: ");
        mTotalBill = new JTextField(10);
        mTotalBill.setText("$0.00");
        totalBillPanel.add(totalBillLabel);
        totalBillPanel.add(mTotalBill);

        //panel combiens all charges and total amout into one panel
        JPanel chargesPanel = new JPanel();
        chargesPanel.setLayout(new GridLayout(4,1));

        chargesPanel.add(mealChargePanel);
        chargesPanel.add(taxesPanel);
        chargesPanel.add(suggestTipPanel);
        chargesPanel.add(totalBillPanel);

        //poorly named panel for itemized list of items ordered
        JPanel testPanel = new JPanel();
        testPanel.setLayout(new BorderLayout());
        testPanel.add(mDisplay, BorderLayout.NORTH);
        testPanel.add(chargesPanel, BorderLayout.SOUTH);

        //panel for non-popular items to be added to bill
        JPanel otherItemPanel = new JPanel();
        otherItemNameLabel = new JLabel("Other Item - Name: ");
        mOtherItemName = new JTextField(10);
        mOtherItemName.setText("");
        otherItemPriceLabel = new JLabel("Price: ");
        mOtherItemPrice = new JTextField(10);
        mOtherItemPrice.setText("");
        otherItemPanel.add(otherItemNameLabel);
        otherItemPanel.add(mOtherItemName);
        otherItemPanel.add(otherItemPriceLabel);
        otherItemPanel.add(mOtherItemPrice);
        otherItemPanel.add(mAddOtherItem);


        restaurantBillPanel.add(popularItemsPanel, BorderLayout.CENTER);
        restaurantBillPanel.add(testPanel, BorderLayout.NORTH);
        restaurantBillPanel.add(otherItemPanel, BorderLayout.SOUTH);

        add(restaurantBillPanel);
    }


}
