package _03objects.P8_11;

/**
 * Created by jakecoll on 10/15/16.
 */
public class Letter {
    private String strFrom;
    private String strTo;
    private String strBodyText;

    /**
     * Constructs a Letter object and initializes instance variables as empty strings
     */
    public Letter()
    {
        strFrom = "";
        strTo = "";
        strBodyText = "";
    }

    /**
     * Constructs a letter object and initialize strFrom and strTo with paramter variables, and strBodyText with empty string.
     * @param from
     * @param to
     */
    public Letter(String from, String to)
    {
        strFrom = from;
        strTo = to;
        strBodyText = "";
    }

    /**
     * mutator method that adds a line to the body text of the letter
     * @param line
     */
    public void addLine(String line)
    {
        strBodyText = strBodyText + line + "\n";
    }

    /**
     * accessor method that returns the full letter
     * @return
     */
    public String getText()
    {
        return  "Dear " + strTo + ":\n"
                + "\n"
                + strBodyText
                + "\n"
                + "Sincerely,\n"
                + "\n"
                + strFrom;
    }
}
