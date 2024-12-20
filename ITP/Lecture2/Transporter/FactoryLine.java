package de.tum.cit.ase;

public class FactoryLine {

    public static Car buildCar() {
        Door doorFrontLeft = new Door();
        Door doorFrontRight = new Door();
        Door doorRearLeft = new Door();
        Door doorRearRight = new Door();

        Engine engine = new Engine(246);

        String serialNumber = "A001";
        Car car = new Car(serialNumber, engine, doorFrontLeft, doorFrontRight, doorRearLeft, doorRearRight);

        car.getEngine().setCar(car);

        return car;
    }

    public static void pickupCar(Seal human, Car car) {
        human.getIntoCar(car);
    }
}
