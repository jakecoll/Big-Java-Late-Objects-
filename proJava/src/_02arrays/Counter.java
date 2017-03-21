package _02arrays;

/**
 * Created by jakecoll on 10/9/16.
 */
public class Counter {

    private int value;

    public void count()
    {
        value = value + 1;
    }

    public void undo()
    {
        value = value - 1;
    }

    public int getValue()
    {
        return value;
    }
}
