package _04interfaces.P9_23;

/**
 * Created by jakecoll on 10/23/16.
 */

import java.text.ParseException;

public class Monthly extends Appointment {

    /**
     * Constructs a monthly appointment object for subclass of Appointment
     * @param description
     * @param year
     * @param month
     * @param day
     * @throws ParseException
     */
    public Monthly (String description, int year, int month, int day) throws ParseException
    {
        super(description, year, month, day);
    }
}
