package de.tum.cit.ase.component;

import java.util.List;
import org.checkerframework.checker.index.qual.NonNegative;
import org.checkerframework.checker.nullness.qual.NonNull;
public class PSU {
    private final @NonNull String model;
    private final @NonNegative int wattage;
    private final List<String> connectorTypes;
    private final double price;

    public PSU(@NonNull String model, @NonNegative int wattage, List<String> connectorTypes, @NonNegative double price) {
        this.model = model;
        this.wattage = wattage;
        this.connectorTypes = connectorTypes;
        this.price = price;
    }

    public @NonNull String getModel() {
        return model;
    }

    public @NonNegative int getWattage() {
        return wattage;
    }

    public List<String> getConnectorTypes() {
        return connectorTypes;
    }

    public @NonNegative double getPrice() {
        return price;
    }
}
