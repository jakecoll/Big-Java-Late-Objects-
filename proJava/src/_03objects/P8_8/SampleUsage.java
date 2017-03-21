package _03objects.P8_8;

/**
 * Created by jakecoll on 10/15/16.
 */
public class SampleUsage {

    public static void main(String[] args) {
        Student janeDoe = new Student("Jane Doe", 78);
        janeDoe.addQuiz(84);
        System.out.println(janeDoe.getAverageScore());
        Grade janeGrade = new Grade(janeDoe.getAverageScore());
        janeGrade.computeLetterGrade();
        janeGrade.computeGPA();
        System.out.println(janeGrade.getLetterGrade());
        System.out.println(janeGrade.getGPA());
    }

}
