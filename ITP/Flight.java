package de.tum.cit.ase;

import java.time.LocalDateTime;

public class Flight {

    private final SpaceshipData spaceshipData;
    private final String flightNumber;
    private final String destination;
    private final String hangarBay;
    private final boolean isCoreWorld;
    private final int duration; // in minutes
    private final LocalDateTime date;

    public Flight(SpaceshipData spaceshipData, String flightNumber, String destination, String hangarBay,
            boolean isCoreWorld, int duration, LocalDateTime date) {
        this.spaceshipData = spaceshipData;
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.hangarBay = hangarBay;
        this.isCoreWorld = isCoreWorld;
        this.duration = duration;
        this.date = date;
    }

    public SpaceshipData getSpaceshipData() {
        return spaceshipData;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDestination() {
        return destination;
    }

    public String getHangarBay() {
        return hangarBay;
    }

    public boolean isCoreWorld() {
        return isCoreWorld;
    }

    public int getDuration() {
        return duration;
    }

    public LocalDateTime getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Flight{"
                + "SpaceshipData='" + spaceshipData
                + ", Destination=" + destination
                + ", Hangar Bay=" + hangarBay
                + ", CoreWorld='" + isCoreWorld
                + ", Duration='" + duration
                + ", Date=" + date
                + ", FlightNumber=" + flightNumber
                + "\n}";
    }
}
