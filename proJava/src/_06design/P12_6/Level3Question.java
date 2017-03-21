package _06design.P12_6;

import java.util.Random;

/**
 * Created by jakecoll on 11/5/16.
 */
public class Level3Question {

    private int nAnswer;
    private int nFirstNum;
    private int nSecondNum;
    private int LEVEL_MAX = 9;
    private int LEVEL_MIN = 1;

    public Level3Question() {
        Random firstR = new Random();
        Random secondR = new Random();
        nFirstNum = firstR.nextInt(LEVEL_MAX-LEVEL_MIN) + LEVEL_MIN;
        if (nFirstNum > LEVEL_MIN)
        {
            nSecondNum = secondR.nextInt(nFirstNum-0) + 0;
        } else { nSecondNum = 0; }

        nAnswer = nFirstNum - nSecondNum;
    }

    /**
     * method returns a question for user as a string based on the variables of the Level3Question object
     * @return
     */
    public String getQuestion()
    {
        return nFirstNum + " - " + nSecondNum + " =";
    }

    /**
     * method returns the answer for the level 3 question as an int
     * @return
     */
    public int getAnswer()
    {
        return nAnswer;
    }
}
