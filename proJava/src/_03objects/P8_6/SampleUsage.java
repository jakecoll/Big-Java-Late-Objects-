package _03objects.P8_6;

/**
 * Created by jakecoll on 10/15/16.
 */
public class SampleUsage {
    public static void main(String[] args) {

        //just to test class Car
        Car myHybrid = new Car(50);
        myHybrid.addGas(20);
        myHybrid.drive(100);
        System.out.println(myHybrid.getGasLevel());

    }
}
