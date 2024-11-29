package de.tum.cit.ase;

import de.tum.cit.ase.component.*;
import de.tum.cit.ase.exception.*;

public class PC {
    private final Motherboard motherboard;
    private final CPU cpu;
    private final GPU gpu;
    private final PSU psu;
    private final RAM ram;

    public PC(Motherboard motherboard, CPU cpu, GPU gpu, PSU psu, RAM ram) {
        if (cpu == null) throw new MissingCPUException(); // Throws if CPU is missing
        if (gpu == null) throw new MissingGPUException(); // Throws if GPU is missing
        if (ram == null) throw new MissingRAMException(); // Throws if RAM is missing

        this.motherboard = motherboard;
        this.cpu = cpu;
        this.gpu = gpu;
        this.psu = psu;
        this.ram = ram;
    }

    public Motherboard getMotherboard() {
        return motherboard;
    }

    public CPU getCpu() {
        return cpu;
    }


    public GPU getGpu() {
        return gpu;
    }

    public PSU getPsu() {
        return psu;
    }

    public RAM getRam() {
        return ram;
    }

    public double calculateTotalPrice() {
        // TODO 2.3: Implement the method
        return motherboard.getPrice() + psu.getPrice() + cpu.getPrice() + ram.getPrice() + gpu.getPrice();
    }

    private boolean isPSUCompatibleWithGPU() {
        // TODO 2.4: Implement the method
        return psu.getConnectorTypes().contains(gpu.getConnectorType());
    }

    private boolean isRAMCompatibleWithMotherboard() {
        // TODO 2.5: Implement the method
        return motherboard.getSupportedRAMTechnology().equals(ram.getTechnology());
    }

    private boolean isGPUCompatibleWithMotherboard() {
        // TODO 2.6: Implement the method
        return motherboard.getSupportedGPUInterface().equals(gpu.getRequiredMotherboardInterface());
    }

    private boolean isCPUCompatibleWithMotherboard() {
        // TODO 2.7: Implement the method
        return motherboard.getSupportedCPUSocket().equals(cpu.getSocket());
    }

    private boolean isEnoughPower() {
        // TODO 2.8: Implement the method
        int totalPowerConsumption = cpu.getPowerConsumption() + gpu.getPowerConsumption()
                + ram.getPowerConsumption() + motherboard.getPowerConsumption();
        return psu.getWattage() >= totalPowerConsumption;
    }

    private String boot() {
        // TODO 2.9: Implement the method and make sure to throw exceptions according to validity checks.
        if (!isEnoughPower()) {
            throw new NotEnoughPowerException();
        }

        if (!isPSUCompatibleWithGPU()) {
            throw new MissingConnectorException("Connector type not found, the supported PSU connector types are: "
                    + psu.getConnectorTypes() + "\nBut GPU connector type is: " + gpu.getConnectorType());
        }

        if (!isRAMCompatibleWithMotherboard()) {
            throw new UnsupportedDeviceException("Detected incompatible devices, the supported RAM technology is: "
                    + motherboard.getSupportedRAMTechnology() + "\nBut actual is: " + ram.getTechnology());
        }

        if (!isGPUCompatibleWithMotherboard()) {
            throw new UnsupportedDeviceException("Detected incompatible devices, the supported GPU interface is: "
                    + motherboard.getSupportedGPUInterface() + "\nBut actual is: " + gpu.getRequiredMotherboardInterface());
        }

        if (!isCPUCompatibleWithMotherboard()) {
            throw new UnsupportedDeviceException("Detected incompatible devices, the supported CPU socket is: "
                    + motherboard.getSupportedCPUSocket() + "\nBut actual is: " + cpu.getSocket());
        }

        return "SUCCESS";
    }

    public void start() {
        // TODO 2.10: Implement the method and make sure to handle the exceptions properly.
        try {
            String status = boot();
            System.out.println("Boot status: " + status);
            System.out.println("The computer started successfully.");
        } catch (BootFailedException e) {
            System.out.println("Boot status: FAILURE");
            System.out.println("Could not start the computer, because " + e.getClass().getSimpleName() + " was thrown.");
            System.out.println("Failure reason: " + e.getMessage() + ".");
        }
    }
}
