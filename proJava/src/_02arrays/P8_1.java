package _02arrays;

/**
 * Created by jakecoll on 10/9/16.
 */



public class P8_1 extends Counter {
    public static void main(String[] args) {

        //see java class Counter for methods
        Counter tally = new Counter();

        tally.count();
        tally.count();
        tally.undo();
        tally.count();

        //undo subtracts one incremental count
        //in above examples result will be 2

        int result = tally.getValue();

        System.out.print(result);

    }
}
