package de.tum.cit.ase;

public class Engine {
    private int sealPower;
    private boolean isRunning;
    private Car car;

    //TODO 2.1: Add attribute oilAmount
    private int oilAmount;

    public Engine(int horsePower, Car car, int oilAmount) {
        this.sealPower = horsePower;
        this.car = car;
        this.isRunning = false;
        //TODO 2.1: Initialize attribute oilAmount
        this.oilAmount = oilAmount;

    }

    public Engine(int horsePower) {
        this.sealPower = horsePower;
    }

    //TODO 2.5: Implement the function workingEngine()
    public boolean workingEngine() {
        return enoughOil() && enoughSealPower();
    }

    //TODO 2.3: Implement the function enoughSealPower()
    public boolean enoughSealPower() {
        return sealPower > 0 && sealPower % 3 == 0;
    }

    //TODO 2.4: Implement the function workingOil()
    public boolean enoughOil() {
        return oilAmount > 2000;
    }

    //TODO 2.2: Implement getters and setters for oilAmount

    public void emergencyStop() {
        this.car.stopCar();
    }

    public int getSealPower() {
        return sealPower;
    }

    public void setSealPower(int sealPower) {
        this.sealPower = sealPower;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public int getOilAmount() {return oilAmount;}

    public void setOilAmount(int oilAmount) { this.oilAmount = oilAmount; }

    @Override
    public String toString() {
        return "Engine{" +
                "horsePower=" + sealPower +
                ", isRunning=" + isRunning +
                ", car=" + car.getSerialNumber() +
                '}';
    }
}
