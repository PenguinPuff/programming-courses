package de.tum.cit.ase;

import java.util.Locale;

public class SpaceshipData {

    private final Faction faction;
    private final SpaceshipType spaceshipType;
    private final int numberOfPassengers;
    private final int fuel;

    public SpaceshipData(String faction, String spaceship, int passenger, int fuel) {
        this.faction = Faction.valueOf(faction.toUpperCase(Locale.ROOT));
        this.spaceshipType = SpaceshipType.valueOf(spaceship);
        this.numberOfPassengers = passenger;
        this.fuel = fuel;
    }

    public Faction getFaction() {
        return faction;
    }

    public SpaceshipType getSpaceship() {
        return spaceshipType;
    }

    public int getNumberOfPassenger() {
        return numberOfPassengers;
    }

    public int getFuel() {
        return fuel;
    }

    @Override
    public String toString() {
        return "{"
                + "faction=" + faction
                + ", spaceship=" + spaceshipType
                + ", numberOfPassengers=" + numberOfPassengers
                + ", fuel=" + fuel
                + '}';
    }
}
