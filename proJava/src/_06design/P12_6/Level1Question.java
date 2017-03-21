package _06design.P12_6;

/**
 * Created by jakecoll on 11/5/16.
 */
import java.util.Random;

public class Level1Question {

    private int nAnswer;
    private int nFirstNum;
    private int nSecondNum;
    private int LEVEL_MAX = 9;
    private int LEVEL_MIN = 0;

    /**
     * method constructs a Level1Question objects without any parameters
     */
    public Level1Question() {

        //declare and initialize random numbers to create question
        Random firstR = new Random();
        Random secondR = new Random();

        //sets answer to level one question
        nAnswer = firstR.nextInt(LEVEL_MAX-LEVEL_MIN) + LEVEL_MIN;

        //sets first input of question based on answer
        if (nAnswer > LEVEL_MIN)
        {
            nFirstNum = secondR.nextInt(nAnswer-LEVEL_MIN) + LEVEL_MIN;
        } else {nFirstNum = LEVEL_MIN; }

        nSecondNum = nAnswer - nFirstNum;
    }

    /**
     * method returns a question for user as a string based on the variables of the Level1Question object
     * @return
     */
    public String getQuestion()
    {
        return nFirstNum + " + " + nSecondNum + " =";
    }

    /**
     * method returns the answer for the level 1 question as an int
     * @return
     */
    public int getAnswer()
    {
        return nAnswer;
    }

}
