package de.tum.cit.ase;

import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * Class representing a ghost train.
 */
public class GhostTrain {
    private int id;
    private int amountOfCars;
    @NonNull private String ghostConductorName;

    /**
     * Constructor for the GhostTrain class.
     *
     * @param id The id of the ghost train.
     * @param amountOfCars The amount of cars the ghost train has.
     * @param ghostConductorName The name of the ghost conductor. The name must be non-null.
     */
    public GhostTrain(int id, int amountOfCars, @NonNull String ghostConductorName) {
        this.id = 6000 + id;
        this.amountOfCars = amountOfCars;
        this.ghostConductorName = ghostConductorName;
    }

    /**
     * Getter for the amount of cars.
     *
     * @return The amount of cars.
     */
    public int getAmountOfCars() {
        return amountOfCars;
    }

    /**
     * Setter for the amount of cars.
     *
     * @param amountOfCars The new amount of cars.
     */
    public void setAmountOfCars(int amountOfCars) {
        this.amountOfCars = amountOfCars;
    }

    /**
     * Getter for the id.
     *
     * @return The id.
     */
    public int getId() {
        return id;
    }

    /**
     * Setter for the id.
     *
     * @param id The new id.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter for the ghost conductor name.
     *
     * @return The ghost conductor name.
     */
    @NonNull public String getGhostConductorName() {
        return ghostConductorName;
    }

    /**
     * Setter for the ghost conductor name.
     *
     * @param ghostConductorName The new ghost conductor name.
     */
    public void setGhostConductorName(String ghostConductorName) {
        this.ghostConductorName = ghostConductorName;
    }
}
