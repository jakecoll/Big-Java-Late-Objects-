package _05dice.P10_2;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 * Created by jakecoll on 10/29/16.
 */
public class ButtonFrame1 extends JFrame {

    private static final int FRAME_WIDTH = 100;
    private static final int FRAME_HEIGHT = 60;

    public ButtonFrame1()
    {
        createComponents();
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
    }

    private void createComponents() {
        JButton button = new JButton("Click me!");
        JPanel panel = new JPanel();
        panel.add(button);
        add(panel);

        ActionListener listener = new ClickListener();
        button.addActionListener(listener);
    }
}
