package _06design.P12_6;

/**
 * Created by jakecoll on 11/5/16.
 */
public class Player {

    private String strName;
    private int nScore;
    private boolean bLevel1;
    private boolean bLevel2;
    private boolean bLevel3;

    /**
     * Constructs a Player object when no parameters are referenced
     */
    public Player()
    {
        strName = "New Player";
        nScore = 0;
        bLevel1 = true;
        bLevel2 = false;
        bLevel3 = false;
    }

    /**
     * Consturcts a Player object based on the parameter variable String name of a user
     * @param name
     */
    public Player(String name)
    {
        strName = name;
        nScore = 0;
        bLevel1 = true;
        bLevel2 = false;
        bLevel3 = false;
    }

    /**
     * method increments the nScore of the Player object
     */
    public void rightAnswer()
    {
        nScore = nScore + 1;
    }

    /**
     * method returns the nScore of a Player object as an int
     * @return
     */
    public int getScore()
    {
        return nScore;
    }

    /**
     * method for advancing to level 2 of a user. It alters the appropriate booleans of the Player object and sets nScore back to 0
     */
    public void advanceToLevel2()
    {
        bLevel1 = false;
        bLevel2 = true;
        nScore = 0;
    }

    /**
     * method for advancing to level 3 of a user. It alters the appropriate booleans of the Player object and sets nScore back to 0
     */
    public void advanceToLevel3()
    {
        bLevel2 = false;
        bLevel3 = true;
        nScore = 0;
    }

    /**
     * method returns the boolean value of bLevel1
     * @return
     */
    public boolean checkLevel1()
    {
        return bLevel1;
    }

    /**
     * method returns the boolean value of bLevel2
     * @return
     */
    public boolean checkLevel2()
    {
        return bLevel2;
    }

    /**
     * method returns the boolean value of bLevel3
     * @return
     */
    public boolean checkLevel3()
    {
        return bLevel3;
    }

    /**
     * method sets all level booleans to false
     */
    public void gameOver()
    {
        bLevel1 = bLevel2 = bLevel3 = false;
    }

}
