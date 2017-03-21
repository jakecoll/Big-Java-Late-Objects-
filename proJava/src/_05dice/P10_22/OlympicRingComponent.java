package _05dice.P10_22;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;

/**
 * Created by jakecoll on 10/29/16.
 */
public class OlympicRingComponent extends JPanel {


    /**
     * method paints the olympic rings in JPanel when called
     * @param g
     */
    public void paintComponent(Graphics g)
    {
        g.setColor(Color.CYAN);
        g.drawOval(100,100,30,30);

        g.setColor(Color.BLACK);
        g.drawOval(130,100,30,30);

        g.setColor(Color.RED);
        g.drawOval(160,100,30,30);

        g.setColor(Color.YELLOW);
        g.drawOval(115,115,30,30);

        g.setColor(Color.GREEN);
        g.drawOval(145,115,30,30);

    }

}
