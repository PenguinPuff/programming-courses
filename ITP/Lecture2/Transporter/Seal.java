package de.tum.cit.ase;

public class Seal {
    private String name;
    private short age;
    private float heightInCm;
    private boolean driversLicense;
    private Car car;

    //TODO 3.1: Add attributes diopter and wearingGlasses
    private float diopter;
    private boolean wearingGlasses;

    //TODO 3.2: Add static attribute crashCount
    private static int crashCount = 0;

    public Seal(String name, short age, float heightInCm, boolean driversLicense, float diopter, boolean wearingGlasses) {
        this.name = name;
        this.age = age;
        this.heightInCm = heightInCm;
        this.driversLicense = driversLicense;
        // TODO 3.1: Initialize attributes diopter and wearingGlasses
        this.diopter = diopter;
        this.wearingGlasses = wearingGlasses;
    }

    //TODO 3.2: Implement the static functions updateCrashCount(), incrementCrashCount() and getCrashCount()
    public static void updateCrashCount(int crashCount) {
        Seal.crashCount = crashCount;
    }

    public static void incrementCrashCount() {
        crashCount++;
    }

    public static int getCrashCount() {
        return crashCount;
    }

    //TODO 3.3: Implement getters and setters for diopter and isWearingGlasses
    public float getDiopter() {
        return diopter;
    }

    public void setDiopter(float diopter) {
        this.diopter = diopter;
    }

    public boolean isWearingGlasses() {
        return wearingGlasses;
    }

    public void setWearingGlasses(boolean wearingGlasses) {
        this.wearingGlasses = wearingGlasses;
    }

    //TODO 3.4: Implement the method validEyesight()
    public boolean validEyesight() {
        return (diopter >= -0.25 && diopter <= 2.0) || wearingGlasses;
    }

    //TODO 3.5: Implement the method isEligibleDriver()
    public boolean isEligibleDriver() {
        return driversLicense && validEyesight() && age > 4;
    }

    public void getIntoCar(Car car) {
        this.car = car;
        this.car.setDriver(this);
    }

    public void exitCar() {
        this.car.setDriver(null);
        this.car = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public short getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public float getHeightInCm() {
        return heightInCm;
    }

    public void setHeightInCm(float heightInCm) {
        this.heightInCm = heightInCm;
    }

    public boolean isDriversLicense() {
        return driversLicense;
    }

    public void setDriversLicense(boolean driversLicense) {
        this.driversLicense = driversLicense;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", heightInCm=" + heightInCm +
                ", driversLicense=" + driversLicense +
                '}';
    }

    public short aging() {
        return ++age;
    }

    public float growing(float by) {
        heightInCm += by;
        return heightInCm;
    }

    public boolean passDrivingTest() {
        driversLicense = true;
        return true;
    }

    public boolean failDrivingTest() {
        driversLicense = false;
        return false;
    }
}
