package _04interfaces.P9_23;

import java.text.ParseException;

/**
 * Created by jakecoll on 10/23/16.
 */
public class Daily extends Appointment {

    /**
     * Constructs Daily subclass object of superclass Appointment
     * @param description
     * @param year
     * @param month
     * @param day
     * @throws ParseException
     */
    public Daily(String description, int year, int month, int day) throws ParseException
    {
        super(description,year,month,day);
    }
}
