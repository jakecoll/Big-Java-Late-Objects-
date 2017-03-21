package _03objects.P8_11;

/**
 * Created by jakecoll on 10/15/16.
 */
public class SampleUsage {
    public static void main(String[] args) {
        Letter letter = new Letter("Mary","John");
        letter.addLine("I am sorry we must part.");
        letter.addLine("I wish you all the best.");
        System.out.println(letter.getText());
    }
}
