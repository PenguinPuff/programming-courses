package de.tum.cit.ase.component;

public class Motherboard {
    private final String model;
    private final String supportedCPUSocket;
    private final String supportedRAMTechnology;
    private final String supportedGPUInterface;
    private final int powerConsumption;
    private final double price;

    public Motherboard(String model, String supportedCPUSocket, String supportedRAMTechnology,
                       String supportedGPUInterface, int powerConsumption, double price) {
        this.model = model;
        this.supportedCPUSocket = supportedCPUSocket;
        this.supportedRAMTechnology = supportedRAMTechnology;
        this.supportedGPUInterface = supportedGPUInterface;
        this.powerConsumption = powerConsumption;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public String getSupportedCPUSocket() {
        return supportedCPUSocket;
    }

    public String getSupportedRAMTechnology() {
        return supportedRAMTechnology;
    }

    public String getSupportedGPUInterface() {
        return supportedGPUInterface;
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public double getPrice() {
        return price;
    }
}
