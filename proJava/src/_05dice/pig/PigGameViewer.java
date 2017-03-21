package _05dice.pig;

import javax.swing.*;

/**
 * Created by jakecoll on 10/31/16.
 */
public class PigGameViewer {
    public static void main(String[] args) {
        JFrame frame = new PigFrame();
        frame.setTitle("Pig Dice Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
