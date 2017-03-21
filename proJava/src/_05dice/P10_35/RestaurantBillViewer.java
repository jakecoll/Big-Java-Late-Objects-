package _05dice.P10_35;

import javax.swing.*;

/**
 * Created by jakecoll on 10/31/16.
 */
public class RestaurantBillViewer {

    /**
     * main method for viewing restaurant bill application
     * @param args
     */
    public static void main(String[] args) {
        JFrame frame = new RestaurantBillFrame();
        frame.setTitle("Best Breakfast Diner Bill");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
