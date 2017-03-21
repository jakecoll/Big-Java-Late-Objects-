package _04interfaces.R9_8;

/**
 * Created by jakecoll on 10/21/16.
 * ...................________________Vehicle_______________________...................
 ................../.........../.............\.........\..........\..................
 ..............Bicycle......Car..........Motorcycle....Truck.....Minivan...............
 ............................|............................|............................
 .........................../.\........................../.\..........................
 .....................Sedan....Coupe..........PickupTruck...SportUtilityVehicle.......
 */
public class Vehicle {
}

class Bicycle extends Vehicle {}

class Car extends Vehicle {}

class Motorcylce extends Vehicle {}

class Truck extends Vehicle {}

class Minivan extends Vehicle {}

class Sedan extends Car {}

class Coupe extends Car {}

class PickupTruck extends Truck {}

class SportUtilityVehicle extends Truck {}

