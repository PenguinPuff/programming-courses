package de.tum.cit.ase.component;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.checkerframework.checker.index.qual.NonNegative;

public class RAM {
    private final @NonNull String model;
    private final @NonNull String technology;
    private final @NonNegative int amountOfMemory;
    private final int powerConsumption; // assume power is measured in watts
    private final double price;

    public RAM(@NonNull String model, @NonNull String technology, @NonNegative int amountOfMemory,   int powerConsumption, double price) {
        this.model = model;
        this.technology = technology;
        this.amountOfMemory = amountOfMemory;
        this.powerConsumption = powerConsumption;
        this.price = price;
    }

    public @NonNull String getModel() {
        return model;
    }

    public @Nullable String getTechnology() {
        return technology; // Can be nullable if optional
    }

    public @NonNegative int getAmountOfMemory() {
        return amountOfMemory;
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public double getPrice() {
        return price;
    }
}
