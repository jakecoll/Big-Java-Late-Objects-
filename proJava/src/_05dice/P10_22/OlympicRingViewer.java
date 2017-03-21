package _05dice.P10_22;

import javax.swing.JFrame;
import javax.swing.JComponent;


/**
 * Created by jakecoll on 10/30/16.
 */
public class OlympicRingViewer {

    public static void main(String[] args) {
        OlympicRingComponent olympicsRings = new OlympicRingComponent();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);

        frame.getContentPane().add(olympicsRings);
        frame.setVisible(true);
    }
}
