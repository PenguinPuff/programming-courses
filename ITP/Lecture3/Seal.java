package de.tum.cit.ase;

public class Seal {
    private String name;
    private boolean driversLicense;
    private Car car;

    public Seal(String name, boolean driversLicense) {
        this.name = name;
        this.driversLicense = driversLicense;
    }

    public void getIntoCar(Car car) {
        this.car = car;
        this.car.setSeal(this);
    }

    public void exitCar() {
        this.car.setSeal(null);
        this.car = null;
    }

    public boolean passDrivingTest() {
        driversLicense = true;
        return true;
    }

    public boolean failDrivingTest() {
        driversLicense = false;
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDriversLicense() {
        return driversLicense;
    }

    public void setDriversLicense(boolean driversLicense) {
        this.driversLicense = driversLicense;
    }

    @Override
    public String toString() {
        return "Seal{" +
                "name='" + name + '\'' +
                ", driversLicense=" + driversLicense +
                ", car=" + car +
                '}';
    }
}
