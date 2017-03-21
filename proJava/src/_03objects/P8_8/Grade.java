package _03objects.P8_8;

/**
 * Created by jakecoll on 10/15/16.
 */
public class Grade {

    private String strGrade;
    private double dNumericGrade;
    private double dGPA;

    /**
     * constructs a grade objects with initial values set to 0 or an empty string
     */
    public Grade()
    {
        strGrade = "";
        dNumericGrade = 0;
        dGPA = 0;
    }

    /**
     * constructs a grade object with the numeric grade
     * @param numericGrade
     */
    public Grade(double numericGrade)
    {
        strGrade = "";
        dNumericGrade = numericGrade;
        dGPA = 0.0;

    }

    /**
     * modifies the letter grade of the object Grade based on numeric grade
     */
    public void computeLetterGrade()
    {
        if (dNumericGrade >= 93.0) { strGrade = "A";}
        else if (dNumericGrade >= 90.0) { strGrade = "A-";}
        else if (dNumericGrade >= 87.0) { strGrade = "B+"; }
        else if (dNumericGrade >= 83.0) { strGrade = "B"; }
        else if (dNumericGrade >= 80.0) { strGrade = "B-"; }
        else if (dNumericGrade >= 77.0) { strGrade = "C+"; }
        else if (dNumericGrade >= 73.0) { strGrade = "C"; }
        else if (dNumericGrade >= 70.0) { strGrade = "C-"; }
        else if (dNumericGrade >= 67.0) { strGrade = "D+"; }
        else if (dNumericGrade >= 63.0) { strGrade = "D"; }
        else if (dNumericGrade >= 60.0) { strGrade = "D-"; }
        else if (dNumericGrade < 60.0) { strGrade = "F"; }

    }

    /**
     * oomputes the GPA of the Grade object based on the letter grade
     * Note: must compute letter grade first
     */
    public void computeGPA()
    {
        switch(strGrade)
        {
            case "A": dGPA = 4.0; break;
            case "A-": dGPA = 3.6; break;
            case "B+": dGPA = 3.3; break;
            case "B": dGPA = 3.0; break;
            case "B-": dGPA = 2.6; break;
            case "C+": dGPA = 2.3; break;
            case "C": dGPA = 2.0; break;
            case "C-": dGPA = 1.7; break;
            case "D+": dGPA = 1.3; break;
            case "D": dGPA = 1.0; break;
            case "D-": dGPA = 0.7; break;
            case "F": dGPA = 0.0; break;
        }
    }

    /**
     * accessor method that returns the letter grade
     * Note that you must computer letter grade first
     * @return
     */
    public String getLetterGrade()
    {
        return strGrade;
    }

    /**
     * accessor method that returns GPA
     * must compute GPA first
     * @return
     */
    public double getGPA()
    {
        return dGPA;
    }

}
