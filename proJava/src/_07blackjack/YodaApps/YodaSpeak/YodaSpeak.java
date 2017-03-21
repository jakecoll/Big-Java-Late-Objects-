package _07blackjack.YodaApps.YodaSpeak;

/**
 * Created by jakecoll on 11/11/16.
 */
import javax.swing.*;

public class YodaSpeak extends JFrame {

    //main method for running yoda app GUI
    public static void main(String[] args) {

        JFrame frame = new YodaSpeakFrame();
        frame.setTitle("Yoda Speak");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
