package _07blackjack.blackjack;

import javax.swing.*;

/**
 * Created by jakecoll on 11/13/16.
 */
public class BlackJackViewer {

    /**
     * main() method for running game GUI
     * @param args
     */
    public static void main(String[] args) {
        Player player = new Player();
        JFrame frame = new BlackJackFrame(player);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
