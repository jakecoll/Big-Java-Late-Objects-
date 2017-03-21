package _03objects.P8_9;

/**
 * Created by jakecoll on 10/15/16.
 */
public class SampleUsage {
    public static void main(String[] args) {
        ComboLock lock = new ComboLock(38,37,40);

        lock.turnRight(38);
        lock.open();
        lock.turnLeft(1);
        lock.open();
        lock.turnRight(7);
        lock.open();


    }
}
