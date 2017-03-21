package _04interfaces.P9_23;

/**
 * Created by jakecoll on 10/23/16.
 */
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import java.text.DateFormat;



public class Appointment {

    private String strDescription;
    private Date date;

    /**
     * Constructs an Appointment object with appointment description and date
     * @param description
     * @param year
     * @param month
     * @param day
     * @throws ParseException
     */

    public Appointment (String description, int year, int month, int day) throws ParseException
    {
        strDescription = description;
        DateFormat apptDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        date = apptDateFormat.parse(String.format("%d-%d-%d", year, month, day));
    }

    public boolean occursOn(int year, int month, int day) throws ParseException
    {
        DateFormat apptDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date checkDate = apptDateFormat.parse(String.format("%d-%d-%d", year, month, day));
        return checkDate.equals(date);
    }

    public void print()
    {
        System.out.println(String.format("Appointment: %s\nDate: %s", strDescription, date.toString()));
    }

    public Date getDate()
    {
        return date;
    }

    @Override
    public String toString()
    {
        return String.format("Appointment: %s\nDate: %s", strDescription, date.toString());
    }


}
