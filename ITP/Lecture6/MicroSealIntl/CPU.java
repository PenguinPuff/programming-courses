package de.tum.cit.ase.component;

public class CPU {
    private final String model;
    private final String socket;
    private final int powerConsumption;
    private final double price;

    public CPU(String model, String socket, int powerConsumption, double price) {
        this.model = model;
        this.socket = socket;
        this.powerConsumption = powerConsumption;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public String getSocket() {
        return socket;
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public double getPrice() {
        return price;
    }
}
