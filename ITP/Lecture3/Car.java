package de.tum.cit.ase;

import java.util.Arrays;

public class Car {
    public static int numberOfTires = 4;
    public static int frontLeftTire = 0;
    public static int frontRightTire = 1;
    public static int rearLeftTire = 2;
    public static int rearRightTire = 3;

    private String manufacturer;
    private Engine engine;
    private Door leftDoor;
    private Door rightDoor;
    private Tire[] tires;
    private boolean hasRoof;

    private Seal seal;

    public Car(String manufacturer, Engine engine, Door leftDoor, Door rightDoor) {
        this.manufacturer = manufacturer;
        this.engine = engine;
        this.leftDoor = leftDoor;
        this.rightDoor = rightDoor;
        this.tires = new Tire[numberOfTires];
        this.hasRoof = true;
    }

    public Seal getSeal() {
        return seal;
    }

    public void setSeal(Seal seal) {
        this.seal = seal;
    }

    public Tire[] getTires() {
        return tires;
    }

    public void setTires(Tire[] tires) {
        this.tires = tires;
    }

    public Door getRightDoor() {
        return rightDoor;
    }

    public void setRightDoor(Door rightDoor) {
        this.rightDoor = rightDoor;
    }

    public Door getLeftDoor() {
        return leftDoor;
    }

    public void setLeftDoor(Door leftDoor) {
        this.leftDoor = leftDoor;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public boolean isHasRoof() {
        return hasRoof;
    }

    public void setHasRoof(boolean hasRoof) {
        this.hasRoof = hasRoof;
    }

    @Override
    public String toString() {
        return "Car{" +
                "manufacturer='" + manufacturer + '\'' +
                ", engine=" + engine +
                ", leftDoor=" + leftDoor +
                ", rightDoor=" + rightDoor +
                ", tires=" + Arrays.toString(tires) +
                ", hasRoof=" + hasRoof +
                ", seal=" + seal +
                '}';
    }
}
