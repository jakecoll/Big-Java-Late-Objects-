package _03objects.P8_8;

/**
 * Created by jakecoll on 10/15/16.
 */
public class Student {

    //instance variables
    private String strName;
    private int nQuizScore;
    private int nQuizzesTaken;
    private Grade grade;

    /**
     * Constructs a Student object and initializes name to empty string, quiz score to 0,
     * the number of quizzes to 0
     */
    public Student()
    {
        strName = "";
        nQuizScore = 0;
        nQuizzesTaken = 0; //so no return error
    }

    /**
     * Constructs a Student object based on parameter values and sets quizzes taken to 1
     * @param name
     * @param quizScore
     */
    public Student(String name, int quizScore)
    {
        strName = name;
        nQuizScore = quizScore;
        nQuizzesTaken = 1;

    }

    /**
     * mutator method that adds a quiz to the Student object and updates number of quizzes taken
     * @param score
     */
    public void addQuiz(int score)
    {
        nQuizzesTaken++;
        nQuizScore = nQuizScore + score;
    }

    /**
     * accessor method that returns aggregate quiz scores
     * @return
     */
    public int getTotalScore()
    {
        return nQuizScore;
    }

    /**
     * accessor method that computes and returns the average quiz score
     * @return
     */
    public double getAverageScore()
    {
        return nQuizScore/nQuizzesTaken;
    }








}
