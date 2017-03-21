package _07blackjack.YodaApps.YodaSpeakRecursive;

/**
 * Created by jakecoll on 11/11/16.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class YodaSpeakRecursiveFrame extends JFrame {

    private JButton mBut0;

    private JTextArea mInputText;
    private JTextArea mOutputText;

    private JLabel inputText;
    private JLabel outputText;

    private static final int FRAME_WIDTH = 600;
    private static final int FRAME_HEIGHT = 300;

    /**
     * Constructs the frame object for recursive app
     */
    public YodaSpeakRecursiveFrame()
    {
        createComponents();
        setSize(FRAME_WIDTH,FRAME_HEIGHT);

        /**
         * Listener for convert button
         */
        class ConvertStringListener implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {

                //method calls the reverseSentence method on the text entered
                String strOriginal = mInputText.getText();
                String strYodaSpeak = reverseSentence(strOriginal);

                mOutputText.setText(strYodaSpeak);
            }
        }

        ActionListener yodaSpeakButton = new ConvertStringListener();
        mBut0.addActionListener(yodaSpeakButton);
    }

    /**
     * Method reverses the words in a sentence recursively
     * @param sentence
     * @return
     */
    public String reverseSentence(String sentence)
    {
        int index = sentence.indexOf(" ");

        if (index < 0)
        {
            return sentence;
        } else {
            return reverseSentence(sentence.substring(index + 1)) + " " + sentence.substring(0,index);
        }

    }

    /**
     * Method adds components of GUI to frame
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
