package _05dice.pig;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Created by jakecoll on 10/31/16.
 */
public class PigFrame extends JFrame {

    private JButton mRollButton;
    private JButton mHoldButton;

    private JLabel mUserScoreLabel;
    private JLabel mComputerScoreLabel;
    private JLabel mTurnTotalLabel;

    private JTextField userScoreTextField;
    private JTextField computerScoreTextField;
    private JTextField turnTotalTextField;

    private JTextArea dieTextArea;

    private static final int FRAME_WIDTH = 300;
    private static final int FRAME_HEIGHT = 400;

    public PigFrame()
    {
        createComponents();
        setSize(FRAME_WIDTH,FRAME_HEIGHT);


        /**
         * inner class button listener for user roll
         */
        class RollButtonListener implements ActionListener
        {


            @Override
            public void actionPerformed(ActionEvent event)
            {
                //pulls current scores from text fields
                int oldCompScore = Integer.parseInt(computerScoreTextField.getText());
                int yourCurrentScore = Integer.parseInt(userScoreTextField.getText());

                //checks if computer has already reached 100 pts
                if (oldCompScore > 99)
                {
                    dieTextArea.setText("YOU LOSE!\nExit Application and open again for new game.");
                }

                //checks if user has already reached 100 pts
                if (yourCurrentScore > 99)
                {
                    dieTextArea.setText("YOU WIN!\nExit Application and open again for new game.");
                }

                else
                {
                    //gets a random number from 1 to 6 to represent a die roll
                    int die = new Random().nextInt(5) + 1;

                    //if 1 is rolled then turn ends and new ComputerAI object constructed to get a computer score
                    //updates correspecting textfields and text areas
                    if (die == 1)
                    {

                        ComputerAI computerTurn = new ComputerAI();
                        int compScore = computerTurn.getTurnScore();
                        turnTotalTextField.setText("0");
                        dieTextArea.setText("*****YOU ROLLED******\n" + die
                                + "\n YOUR TURN IS OVER\n"
                                + "COMPUTERS TURN\n"
                                + "COMPUTER SCORES: " + compScore + "\n");
                        computerScoreTextField.setText(Integer.toString(oldCompScore + compScore));

                        //check for computer score if game ends print message
                        if (oldCompScore + compScore > 99)
                        {
                            dieTextArea.setText("YOU LOSE!\nExit Application and open again for new game.");
                        }

                        //if none of the above then the user roll is processed
                    } else {
                        dieTextArea.setText("*****YOU ROLLED******" + "\n" + die);
                        int nTurnTotal = Integer.parseInt(turnTotalTextField.getText());
                        turnTotalTextField.setText(Integer.toString(nTurnTotal+die));
                    }
                }

            }
        }

        //add actionlistener to "Roll" button
        ActionListener rollButtonListener = new RollButtonListener();
        mRollButton.addActionListener(rollButtonListener);

        /**
         * inner class ActionListener for "Hold" button
         */
        class HoldButtonListener implements ActionListener
        {
            public HoldButtonListener() {}

            public void actionPerformed(ActionEvent event)
            {
                int checkCompScore = Integer.parseInt(computerScoreTextField.getText());

                //check computer score to see if game has already ended
                if (checkCompScore > 99)
                {
                    dieTextArea.setText("YOU LOSE!\nExit Application and open again for new game.");
                }

                //else add users points, update corresponding textfields and text areas
                //
                else
                {
                    dieTextArea.setText("*****YOU ROLLED******");
                    int nTurnTotal = Integer.parseInt(turnTotalTextField.getText());
                    int nPriorUserScore = Integer.parseInt(userScoreTextField.getText());
                    int nNewScore = nTurnTotal + nPriorUserScore;
                    userScoreTextField.setText(Integer.toString(nNewScore));
                    turnTotalTextField.setText("0");

                    //check to see if user has won
                    if (nNewScore > 99)
                    {
                        dieTextArea.setText("YOU WIN!\nExit Application and open again for new game.");
                    }
                    //else execute computers turn.
                    else
                    {
                        ComputerAI computerTurn = new ComputerAI();
                        int compScore = computerTurn.getTurnScore();
                        turnTotalTextField.setText("0");
                        dieTextArea.setText("YOUR TURN IS OVER\n"
                                + "COMPUTERS TURN\n"
                                + "COMPUTER SCORES: " + compScore + "\n");
                        int oldCompScore = Integer.parseInt(computerScoreTextField.getText());
                        computerScoreTextField.setText(Integer.toString(oldCompScore + compScore));
                    }
                }


            }
        }

        //add actionlistener to "Hold" button
        ActionListener holdButtonListener = new HoldButtonListener();
        mHoldButton.addActionListener(holdButtonListener);
    }


    /**
     * method for constructing GUI componenets
     */
    public void createComponents()
    {
        this.mRollButton = new JButton("Roll");
        this.mHoldButton = new JButton("Hold");

        this.dieTextArea = new JTextArea("*****YOU ROLLED******");

        final int DIE_DISPLAY_HEIGHT = 100;
        dieTextArea.setPreferredSize(new Dimension(FRAME_WIDTH,DIE_DISPLAY_HEIGHT));


        JPanel pigGameGUIPanel = new JPanel();
        pigGameGUIPanel.setLayout(new BorderLayout());

        JPanel scoresPanel = new JPanel();
        scoresPanel.setLayout(new BorderLayout());

        JPanel userScorePanel = new JPanel();
        userScorePanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        mUserScoreLabel = new JLabel("User Score: ");
        userScoreTextField = new JTextField(10);
        userScoreTextField.setText("0");
        userScorePanel.add(mUserScoreLabel);
        userScorePanel.add(userScoreTextField);

        JPanel computerScorePanel = new JPanel();
        computerScorePanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        mComputerScoreLabel = new JLabel("Computer Score: ");
        computerScoreTextField = new JTextField(10);
        computerScoreTextField.setText("0");
        computerScorePanel.add(mComputerScoreLabel);
        computerScorePanel.add(computerScoreTextField);

        JPanel turnTotalPanel = new JPanel();
        turnTotalPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        mTurnTotalLabel = new JLabel("Turn Total: ");
        turnTotalTextField = new JTextField(10);
        turnTotalTextField.setText("0");
        turnTotalPanel.add(mTurnTotalLabel);
        turnTotalPanel.add(turnTotalTextField);

        scoresPanel.add(userScorePanel, BorderLayout.NORTH);
        scoresPanel.add(computerScorePanel, BorderLayout.CENTER);
        scoresPanel.add(turnTotalPanel, BorderLayout.SOUTH);

        JPanel moveChoicePanel = new JPanel();
        moveChoicePanel.setLayout(new FlowLayout());
        moveChoicePanel.add(mRollButton);
        moveChoicePanel.add(mHoldButton);

        pigGameGUIPanel.add(scoresPanel, BorderLayout.NORTH);
        pigGameGUIPanel.add(dieTextArea, BorderLayout.CENTER);
        pigGameGUIPanel.add(moveChoicePanel, BorderLayout.SOUTH);

        add(pigGameGUIPanel);


    }

}
