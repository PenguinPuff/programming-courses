package de.tum.cit.ase.component;

import de.tum.cit.ase.exception.MissingRAMException;

public class GPU {
    private final String model;
    private final String requiredMotherboardInterface;
    private final RAM ram;
    private final String connectorType;
    private final int powerConsumption;
    private final double price;

    public GPU(String model, String requiredMotherboardInterface, RAM ram, String connectorType,
               int powerConsumption, double price) {
        // TODO 2.1: Check that the ram attribute is not null, otherwise throw a MissingRAMException.
        if (ram == null) throw new MissingRAMException();
        this.model = model;
        this.requiredMotherboardInterface = requiredMotherboardInterface;
        this.ram = ram;
        this.connectorType = connectorType;
        this.powerConsumption = powerConsumption;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public String getRequiredMotherboardInterface() {
        return requiredMotherboardInterface;
    }

    public RAM getRam() {
        return ram;
    }

    public String getConnectorType() {
        return connectorType;
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public double getPrice() {
        // TODO 2.1: Update the price() method
        return ram.getPrice() + price;
    }
}
