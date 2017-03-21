package _07blackjack.YodaApps.YodaSpeak;

/**
 * Created by jakecoll on 11/11/16.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class YodaSpeakFrame extends JFrame {

    private JButton mBut0;

    private JTextArea mInputText;
    private JTextArea mOutputText;

    private JLabel inputText;
    private JLabel outputText;

    private static final int FRAME_WIDTH = 600;
    private static final int FRAME_HEIGHT = 300;

    /**
     * Constructs YodaSpeakFrame object
     */
    public YodaSpeakFrame()
    {
        createComponents();
        setSize(FRAME_WIDTH,FRAME_HEIGHT);

        /**
         * Constructs ActionListener for Convert to Yoda speak button
         */
        class ConvertStringListener implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                // the following implements reverse sentence in iterative form

                ArrayList<String> arrYodaSpeak = new ArrayList<String>();
                String strYodaSpeak = "";

                String strOriginal = mInputText.getText();
                String[] parts = strOriginal.split(" ");

                for (String part: parts)
                {
                    arrYodaSpeak.add(0, part);
                }

                for(String part: arrYodaSpeak)
                {
                    strYodaSpeak += part + " ";
                }

                mOutputText.setText(strYodaSpeak);

            }
        }

        ActionListener yodaSpeakButton = new ConvertStringListener();
        mBut0.addActionListener(yodaSpeakButton);
    }

    /**
     * Method add the components for the YodaSpeak GUI
     */
    public void createComponents()
    {
        this.mBut0 = new JButton("Convert to Yoda Speak");
        mBut0.setSize(30,10);

        //layout
        JPanel yodaSpeakPanel = new JPanel();
        yodaSpeakPanel.setLayout(new BorderLayout());

        //input panel layout
        JPanel inputTextPanel = new JPanel(new BorderLayout());
        inputText = new JLabel("Enter Text Here:");
        mInputText = new JTextArea();
        inputTextPanel.add(inputText, BorderLayout.NORTH);
        inputTextPanel.add(mInputText, BorderLayout.CENTER);
        inputTextPanel.setBorder(BorderFactory.createLineBorder(Color.CYAN));

        //output panel
        JPanel outputTextPanel = new JPanel(new BorderLayout());
        outputText = new JLabel("Yoda Says:");
        mOutputText = new JTextArea();
        outputTextPanel.add(outputText, BorderLayout.NORTH);
        outputTextPanel.add(mOutputText, BorderLayout.CENTER);
        outputTextPanel.setBorder(BorderFactory.createLineBorder(Color.CYAN));

        //button panel
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(mBut0);

        //test panel
        JPanel textAreaPanel = new JPanel(new GridLayout(1,2));
        textAreaPanel.add(inputTextPanel);
        textAreaPanel.add(outputTextPanel);
        textAreaPanel.setBorder(BorderFactory.createLineBorder(Color.CYAN));

        yodaSpeakPanel.add(buttonPanel, BorderLayout.NORTH);
        yodaSpeakPanel.add(textAreaPanel, BorderLayout.CENTER);

        add(yodaSpeakPanel);

    }
}
