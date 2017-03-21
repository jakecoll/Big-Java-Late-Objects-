package _06design.P12_6;

import java.util.Random;

/**
 * Created by jakecoll on 11/5/16.
 */
public class Level2Question {

    private int nAnswer;
    private int nFirstNum;
    private int nSecondNum;
    private int LEVEL_MAX = 9;
    private int LEVEL_MIN = 0;

    /**
     * method constructs a Level2Question objects without any parameters
     */
    public Level2Question() {
        //declares and initialize random numbers to create question
        Random firstR = new Random();
        Random secondR = new Random();

        //sets first single digit number to be added
        nFirstNum = firstR.nextInt(LEVEL_MAX-LEVEL_MIN) + LEVEL_MIN;

        //ets second single digit number to be added
        nSecondNum = secondR.nextInt(LEVEL_MAX-LEVEL_MIN) + LEVEL_MIN;

        //sets answer based on first to variables
        nAnswer = nFirstNum + nSecondNum;
    }

    /**
     * method returns a question for user as a string based on the variables of the Level2Question object
     * @return
     */
    public String getQuestion()
    {
        return nFirstNum + " + " + nSecondNum + " =";
    }

    /**
     * method returns the answer for the level 2 question as an int
     * @return
     */
    public int getAnswer()
    {
        return nAnswer;
    }

}
