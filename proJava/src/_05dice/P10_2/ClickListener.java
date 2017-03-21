package _05dice.P10_2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by jakecoll on 10/29/16.
 * EnhancetheButtonViewer1programinSection10.2.1sothatitprintsamessage
 “I was clicked n times!” whenever the button is clicked. The value n should be incre- mented with each click.
 */
public class ClickListener implements ActionListener {

    private static int nCount = 0;

    public void actionPerformed(ActionEvent event)
    {
        nCount++;
        System.out.println("I was clicked " + nCount +" times.");
    }
}
