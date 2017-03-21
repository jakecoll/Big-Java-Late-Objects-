package _03objects.P8_9;

/**
 * Created by jakecoll on 10/15/16.
 */
public class ComboLock {

    private int nFirstSecret;
    private int nSecondSecret;
    private int nThirdSecret;
    private int nCurrentNumber;
    private int nTurn;

    /**
     * Constructs a combo lock object with combo numbers set to 0, the dial pointing to 0 and indicates first turn
     */
    public ComboLock()
    {
        nFirstSecret = 0;
        nSecondSecret = 0;
        nThirdSecret = 0;
        nCurrentNumber = 0;
        nTurn = 1;
    }

    /**
     * Constructs a combo lock object with combo numbers set by parameter variables, dial pointing to 0, and turns set at 1
     * @param secret1
     * @param secret2
     * @param secret3
     */
    public ComboLock(int secret1, int secret2, int secret3)
    {
        nFirstSecret = secret1;
        nSecondSecret = secret2;
        nThirdSecret = secret3;
        nCurrentNumber = 0;
        nTurn = 1;
    }

    /**
     * mutator method that resets dial at zero and turns to 1
     * Use this method to attempt to unlock combo lock again. You should create a new combo lock for different combo numbers
     */
    public void reset()
    {
        nCurrentNumber = 0;
        nTurn = 1;
    }

    /**
     * method turns the dial to the left based on number of ticks. Uses modular arithmetic if you go past 0.
     * @param ticks
     */
    public void turnLeft(int ticks)
    {
        if (nCurrentNumber - ticks >= 0)
        {
            nCurrentNumber = nCurrentNumber - ticks;
        }
        else if (nCurrentNumber - ticks < 0)
        {
            nCurrentNumber = ((nCurrentNumber - ticks) % 39) + 1;
        }
    }

    /**
     * method turns the dial to the right by given number of ticks. Uses modular arithmetic if you go past 39.
     * @param ticks
     */
    public void turnRight(int ticks)
    {
        if (nCurrentNumber + ticks <= 39)
        {
            nCurrentNumber = nCurrentNumber + ticks;
        }
        else if (nCurrentNumber + ticks > 39)
        {
            nCurrentNumber = ((nCurrentNumber + ticks) % 39) - 1;
        }
    }

    /**
     * method returns boolean and prints whether first combo number a success.
     * method should be called after each turn. Left or right.
     * method also modifies number of turns.
     * @return
     */
    public boolean open()
    {
        if (nTurn == 1)
        {
            if (nCurrentNumber == nFirstSecret)
            {
                System.out.println("First combo unlocked.");
                nTurn = nTurn + 1;
                return true;
            } else {
                System.out.println("First combo was wrong");
                return false;
            }

        }
        if (nTurn == 2)
        {
            if (nCurrentNumber == nSecondSecret)
            {
                System.out.println("Second combo unlocked.");
                nTurn = nTurn + 1;
                return true;
            } else {
                System.out.println("Second combo was wrong");
                return false;
            }

        }
        if (nTurn == 3)
        {
            if (nCurrentNumber == nThirdSecret)
            {
                System.out.println("The combo lock has been unlocked.");
                nTurn = nTurn + 1;
                return true;
            } else {
                System.out.println("Third combo was wrong");
                return false;
            }

        }
        return false;
    }

    public int getnCurrentNumber()
    {
        return nCurrentNumber;
    }

}
