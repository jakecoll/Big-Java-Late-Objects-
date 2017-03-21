package _05dice.pig;

import java.util.Random;

/**
 * Created by jakecoll on 10/31/16.
 */
public class ComputerAI {

    private int nTargetPoints;
    private int nCurrentPoints = 0;
    private int nScore;

    /**
     * Constructs a computerAI object with a score for a given turn based on target points and dice rolls
     */
    public ComputerAI()
    {
        //picks a random points target for computer between 5 and 20
        nTargetPoints = new Random().nextInt(15) + 5;


        //while loop for deciding to roll or getting 0 points if computer rolls a 1
        while (nCurrentPoints < nTargetPoints)
        {
            //random number between 1 and 6 to represent die roll
            int dieRoll = new Random().nextInt(5) + 1;

            if (dieRoll == 1)
            {
                nCurrentPoints = 0;
                break;
            }
            else
            {
                nCurrentPoints = nCurrentPoints + dieRoll;
            }
        }

        nScore = nCurrentPoints;

    }

    /**
     * method for returning the score of the ComputerAI object
     * @return
     */
    public int getTurnScore()
    {
        return nScore;
    }
}
