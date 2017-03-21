package _04interfaces.P9_23;

/**
 * Created by jakecoll on 10/23/16.
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Didn't actually finish but have base code for save method as well as super and subclasses.
 */

public class AppointmentBook {


    public static void main(String[] args) throws ParseException, IOException {
        String apptBookFile = "AppointmentBook.txt";

        OneTime doctorsAppt = new OneTime("doctors appointment",2016,11,01);
        Appointment birthdayParty = new Appointment("birthday",2016,12,01);

        save(doctorsAppt, apptBookFile);
        save(birthdayParty, apptBookFile);

        /*
        ArrayList<String> rawFileAppointments = new ArrayList<String>();

        File inputFile = new File("AppointmentBook.txt");
        Scanner in = new Scanner(inputFile);


        while (in.hasNextLine())
        {


            rawFileAppointments.add(line);

        }

        ArrayList<Appointment> appointmentsArray = createArrayAppointments(rawFileAppointments);

        System.out.println(appointmentsArray[0].getClass().getName());*/


    }

    public static void save(Appointment object, String file) throws ParseException, IOException
    {
        BufferedWriter bw = new BufferedWriter(new FileWriter(file,true));

        bw.write(object.getClass().getName() + "\n" + object.toString() + "\n");
        bw.newLine();
        bw.flush();
    }

    /**
     * my brief attempt reading in file for objects
    public static ArrayList<Appointment> createArrayAppointments(ArrayList<String> input)
    {
        ArrayList<Appointment> tempArrAppointments = new ArrayList<Appointment>();

        for (int i = 0; i < input.size(); i++)
        {
            String[] parts = input.get(i).split(".");

            if (!Arrays.asList(serviceCategories).contains(parts[2]))
            {
                serviceCategories.add(parts[1]);
            }

        }

        return serviceCategories;

    }*/


}
