package de.tum.cit.ase;

public class Car {
    private String serialNumber;
    private boolean handbrakeApplied;
    private Engine engine;
    private Seal driver;
    private Door doorFrontLeft;
    private Door doorFrontRight;
    private Door doorRearLeft;
    private Door doorRearRight;

    public Car(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Car(String serialNumber, Engine engine, Door doorFrontLeft, Door doorFrontRight, Door doorRearLeft, Door doorRearRight) {
        this.serialNumber = serialNumber;
        this.engine = engine;
        this.doorFrontLeft = doorFrontLeft;
        this.doorFrontRight = doorFrontRight;
        this.doorRearLeft = doorRearLeft;
        this.doorRearRight = doorRearRight;
    }

    //TODO 4.1: Implement the function checkCar()
    public String checkCar() {
        if (engine == null || driver == null || doorFrontLeft == null || doorFrontRight == null || doorRearLeft == null || doorRearRight == null) {
            return "One of the car components is missing!";
        }
        if (!engine.workingEngine()) {
            return "The engine is not working properly!";
        }
        if (!driver.isEligibleDriver()) {
            return "The seal is not allowed to drive a car!";
        }
        return "The car is checked and ready to go!";
    }

    public void startCar() {
        this.doorFrontLeft.setOpened(false);
        this.doorFrontRight.setOpened(false);
        this.doorRearLeft.setOpened(false);
        this.doorRearRight.setOpened(false);

        this.engine.setRunning(true);

        this.handbrakeApplied = false;
    }

    public void stopCar() {
        this.engine.setRunning(false);
        this.handbrakeApplied = true;
    }

    public void setWindowHeight(Door door, int windowHeight) {
        door.setWindowHeight(windowHeight);
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public boolean isHandbrakeApplied() {
        return handbrakeApplied;
    }

    public void setHandbrakeApplied(boolean handbrakeApplied) {
        this.handbrakeApplied = handbrakeApplied;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Seal getDriver() {
        return driver;
    }

    public void setDriver(Seal driver) {
        this.driver = driver;
    }

    public Door getDoorFrontLeft() {
        return doorFrontLeft;
    }

    public void setDoorFrontLeft(Door doorFrontLeft) {
        this.doorFrontLeft = doorFrontLeft;
    }

    public Door getDoorFrontRight() {
        return doorFrontRight;
    }

    public void setDoorFrontRight(Door doorFrontRight) {
        this.doorFrontRight = doorFrontRight;
    }

    public Door getDoorRearLeft() {
        return doorRearLeft;
    }

    public void setDoorRearLeft(Door doorRearLeft) {
        this.doorRearLeft = doorRearLeft;
    }

    public Door getDoorRearRight() {
        return doorRearRight;
    }

    public void setDoorRearRight(Door doorRearRight) {
        this.doorRearRight = doorRearRight;
    }

    @Override
    public String toString() {
        return "Car{" +
                "serialNumber='" + serialNumber + '\'' +
                ", handbrakeApplied=" + handbrakeApplied +
                ", engine=" + engine +
                ", driver=" + driver +
                ", doorFrontLeft=" + doorFrontLeft +
                ", doorFrontRight=" + doorFrontRight +
                ", doorRearLeft=" + doorRearLeft +
                ", doorRearRight=" + doorRearRight +
                '}';
    }
}
